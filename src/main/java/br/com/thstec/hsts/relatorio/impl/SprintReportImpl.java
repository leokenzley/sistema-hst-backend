package br.com.thstec.hsts.relatorio.impl;

import br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity;
import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.entities.SprintEntity;
import br.com.thstec.hsts.exceptions.commons.BusinessException;
import br.com.thstec.hsts.exceptions.commons.NotFoundException;
import br.com.thstec.hsts.model.enumerations.RequisitoStatusEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.sprint.response.SprintResponseReport;
import br.com.thstec.hsts.relatorio.SprintReport;
import br.com.thstec.hsts.repositories.OrcamentoRequisitoFuncionalidadeRepository;
import br.com.thstec.hsts.repositories.ProjetoRepository;
import br.com.thstec.hsts.repositories.SprintRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SprintReportImpl implements SprintReport {
    private final SprintRepository sprintRepository;
    private final ProjetoRepository projetoRepository;
    private final OrcamentoRequisitoFuncionalidadeRepository orcamentoRequisitoFuncionalidadeRepository;

    @Override
    public byte[] gerarPdf(Long id) throws Exception {

        // Carrega o .jasper já compilado
        InputStream jasperStream =
                new ClassPathResource("report/RelatorioSprint.jasper").getInputStream();

        JasperReport report =
                (JasperReport) JRLoader.loadObject(jasperStream);

        var sprint = sprintRepository.findById(id).orElseThrow(()-> new NotFoundException("Sprint não encontrada"));
        var projeto = projetoRepository.findById(sprint.getProjeto().getId()).orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
        var orcReqFuncList = orcamentoRequisitoFuncionalidadeRepository.findBySprintId(id);

        Set<Long> orcReqSet = orcReqFuncList
                .stream()
                .filter(x -> x.getOrcamentoRequisito().getRequisitoStatus().equals(RequisitoStatusEnum.VALIDADO))
                .map(x-> x.getOrcamentoRequisito().getId())
                .collect(Collectors.toSet());

        if(orcReqSet.isEmpty())
            throw new BusinessException("Sprint não possui requisitos validados");

        var sprintResponseCollection =
                orcReqSet
                        .stream()
                        .map(s -> {
                            return SprintResponseReport
                                    .builder()
                                    .descricao(getDescricaoRequisitoFromListByIdRequisito(s, orcReqFuncList))
                                    .hstOrcado(calculaTotalOrcamentoFromListRequisitoByIdRequisito(s, orcReqFuncList))
                                    .build();
                        })
                        .toList();

        Map<String, Object> params = new HashMap<>();

        InputStream logoStream =
                new ClassPathResource("report/images/logo.png").getInputStream();

        params.put("LOGO", logoStream);
        params.put("SPRINT_NUMERO", sprint.getNumero());
        params.put("PROJETO_NOME", projeto.getNome());
        params.put("DATA", getDataPeriodoSprint(sprint));
        params.put("TOTAL", getTotalSprint(sprintResponseCollection));
        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(sprintResponseCollection);
        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        params,
                        dataSource
                );

        return JasperExportManager.exportReportToPdf(print);
    }

    private BigDecimal getTotalSprint(List<SprintResponseReport> sprintResponseCollection) {
        return sprintResponseCollection.stream()
                .filter(Objects::nonNull)
                .map(SprintResponseReport::getHstOrcado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private String getDataPeriodoSprint(SprintEntity sprint) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return formatter.format(sprint.getDtInicio()).concat(" - ").concat(formatter.format(sprint.getDtFim()));
    }

    private String getDescricaoRequisitoFromListByIdRequisito(
            Long id,
            List<OrcamentoRequisitoFuncionalidadeEntity> orcReqFuncList) {

        var descricaoOpt = orcReqFuncList
                .stream()
                .filter(x -> x.getOrcamentoRequisito().getId().equals(id))
                .findFirst()
                .map(x->x.getOrcamentoRequisito().getRequisito());
        if(descricaoOpt.isEmpty())
            throw new BusinessException("Descrição não encontrada!");

        return descricaoOpt.get();
    }

    private BigDecimal calculaTotalOrcamentoFromListRequisitoByIdRequisito(Long id, List<OrcamentoRequisitoFuncionalidadeEntity> orcReqFuncList) {
        return orcReqFuncList.stream()
                .filter(o -> o.getOrcamentoRequisito() != null)
                .filter(o -> o.getOrcamentoRequisito().getId().equals(id))
                .filter(o -> o.getStatus().equals(StatusEnum.ATIVO))
                .map(OrcamentoRequisitoFuncionalidadeEntity::getValorFinal)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
