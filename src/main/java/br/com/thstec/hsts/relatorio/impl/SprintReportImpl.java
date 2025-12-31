package br.com.thstec.hsts.relatorio.impl;

import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.entities.SprintEntity;
import br.com.thstec.hsts.exceptions.commons.NotFoundException;
import br.com.thstec.hsts.relatorio.SprintReport;
import br.com.thstec.hsts.repositories.ProjetoRepository;
import br.com.thstec.hsts.repositories.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class SprintReportImpl implements SprintReport {
    private final SprintRepository sprintRepository;
    private final ProjetoRepository projetoRepository;
    @Override
    public byte[] gerarPdf(Long id) throws Exception {

        // Carrega o .jasper já compilado
        InputStream jasperStream =
                new ClassPathResource("report/RelatorioSprint.jasper").getInputStream();

        JasperReport report =
                (JasperReport) JRLoader.loadObject(jasperStream);

        SprintEntity sprint = sprintRepository.findById(id).orElseThrow(()-> new NotFoundException("Sprint não encontrada"));
        ProjetoEntity projeto = projetoRepository.findById(sprint.getProjeto().getId()).orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
        Map<String, Object> params = new HashMap<>();

        InputStream logoStream =
                new ClassPathResource("report/images/logo.png").getInputStream();

        params.put("LOGO", logoStream);
        params.put("SPRINT_NUMERO", sprint.getNumero());
        params.put("PROJETO_NOME", projeto.getNome());

        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        params,
                        new JREmptyDataSource()
                );

        return JasperExportManager.exportReportToPdf(print);
    }
}
