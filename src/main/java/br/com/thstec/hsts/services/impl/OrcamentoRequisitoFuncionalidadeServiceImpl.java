package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity;
import br.com.thstec.hsts.entities.TarefaEntity;
import br.com.thstec.hsts.exceptions.commons.BusinessException;
import br.com.thstec.hsts.mappers.OrcamentoRequisitoFuncionalidadeMapper;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import br.com.thstec.hsts.repositories.OrcamentoRequisitoFuncionalidadeRepository;
import br.com.thstec.hsts.repositories.OrcamentoRequisitoRepository;
import br.com.thstec.hsts.repositories.TarefaRepository;
import br.com.thstec.hsts.services.OrcamentoRequisitoFuncionalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrcamentoRequisitoFuncionalidadeServiceImpl
        implements OrcamentoRequisitoFuncionalidadeService {

    private final OrcamentoRequisitoFuncionalidadeRepository repository;
    private final OrcamentoRequisitoFuncionalidadeMapper mapper;
    private final OrcamentoRequisitoRepository orcamentoRequisitoRepository;
    private final TarefaRepository tarefaRepository;

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse create(OrcamentoRequisitoFuncionalidadeRequest request) {
        try {
            var entity = mapper.toEntity(request);
            var tarefa = tarefaRepository.findById(entity.getTarefa().getId())
                    .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
            validaFuncionalidadeSemValorReferencia(request, tarefa);
            calculaValorFinalHSTValorReferencia(request, tarefa, entity);
            entity.setUsername("undefined@thstec.info.br"); // TODO trocar pelo username do usuário logado
            return mapper.toResponse(repository.save(entity));
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void calculaValorFinalHSTValorReferencia(OrcamentoRequisitoFuncionalidadeRequest request, TarefaEntity tarefa, OrcamentoRequisitoFuncionalidadeEntity entity) {
        if(request.valorFinal() == null && tarefa != null && tarefa.getValorHistoricoReferencia() != null) {
            entity.setValorFinal(calculaHstTarefa(entity, tarefa.getValorHistoricoReferencia()));
        }
    }

    private static void validaFuncionalidadeSemValorReferencia(OrcamentoRequisitoFuncionalidadeRequest request, TarefaEntity tarefa) {
        if(tarefa.getValorHistoricoReferencia() == null && request.valorFinal() == null){
            throw new BusinessException("Valor final obrigatório para a tarefa %s"
                    .formatted(tarefa.getId().toString().concat("-").concat(tarefa.getNome())));
        }
    }

    private BigDecimal calculaHstTarefa(OrcamentoRequisitoFuncionalidadeEntity entity, BigDecimal valorReferencia) {
        return entity.getQuantidadeHoras().multiply(valorReferencia);
    }

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse update(Long id, OrcamentoRequisitoFuncionalidadeRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));

        var orcamento = orcamentoRequisitoRepository.findById(request.orcamentoRequisitoId())
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        entity.setOrcamentoRequisito(orcamento);

        var tarefa = tarefaRepository.findById(request.tarefaId())
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        entity.setTarefa(tarefa);
        entity.setObservacao(request.observacao());
        entity.setComprovante(request.comprovante());
        entity.setQuantidadeHoras(request.quantidadeHoras());
        validaFuncionalidadeSemValorReferencia(request, tarefa);
        calculaValorFinalHSTValorReferencia(request, tarefa, entity);
        entity.setUsername("undefined@thstec.info.br"); // TODO trocar pelo username do usuário logado
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    @Override
    public Page<OrcamentoRequisitoFuncionalidadeResponse> getPaginated(Long orcamentoRequisitoId, Pageable pageable) {
        return repository.getPaginatedByOrcamentoRequisitoId(orcamentoRequisitoId, pageable).map(mapper::toResponse);
    }

}
