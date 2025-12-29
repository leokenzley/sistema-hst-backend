package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity;
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

@Service
@RequiredArgsConstructor
public class OrcamentoRequisitoFuncionalidadeServiceImpl
        implements OrcamentoRequisitoFuncionalidadeService {

    private final OrcamentoRequisitoFuncionalidadeRepository repository;
    private final OrcamentoRequisitoFuncionalidadeMapper mapper;
    private final OrcamentoRequisitoRepository orcamentoRequisitoRepository;
    private final TarefaRepository tarefaRepository;

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse created(OrcamentoRequisitoFuncionalidadeRequest request) {
        var entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
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
        entity.setValorFinal(request.valorFinal());

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
    public Page<OrcamentoRequisitoFuncionalidadeResponse> getPaginated(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

}
