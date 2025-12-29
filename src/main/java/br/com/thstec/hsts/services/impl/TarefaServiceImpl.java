package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.TarefaEntity;
import br.com.thstec.hsts.mappers.TarefaMapper;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import br.com.thstec.hsts.repositories.DisciplinaRepository;
import br.com.thstec.hsts.repositories.TarefaRepository;
import br.com.thstec.hsts.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository repository;
    private final DisciplinaRepository disciplinaRepository;
    private final TarefaMapper mapper;

    @Override
    public TarefaResponse created(TarefaRequest request) {
        var entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public TarefaResponse update(Long id, TarefaRequest request) {
        TarefaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        entity.setNome(request.nome());
        entity.setDescricaoHistoricoReferencia(request.descricaoHistoricoReferencia());
        entity.setValorHistoricoReferencia(request.valorHistoricoReferencia());
        entity.setDetalhe(request.detalhe());
        entity.setFatorImpacto(request.fatorImpacto());
        entity.setMemoriaCalculo(request.memoriaCalculo());
        entity.setStatus(request.status());
        var disciplina = disciplinaRepository.findById(request.disciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        entity.setDisciplina(disciplina);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TarefaResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    @Override
    public Page<TarefaResponse> getPaginated(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }
}

