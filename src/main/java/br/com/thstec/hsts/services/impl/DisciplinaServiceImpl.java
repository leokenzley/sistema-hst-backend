package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.DisciplinaEntity;
import br.com.thstec.hsts.exceptions.commons.NotFoundException;
import br.com.thstec.hsts.mappers.DisciplinaMapper;
import br.com.thstec.hsts.model.disciplina.request.DisciplinaRequest;
import br.com.thstec.hsts.model.disciplina.response.DisciplinaResponse;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.repositories.DisciplinaRepository;
import br.com.thstec.hsts.services.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService {

    public static final String DISCIPLINA_NAO_ENCONTRADA = "Disciplina não encontrada";
    private final DisciplinaRepository repository;
    private final DisciplinaMapper mapper;

    @Override
    public DisciplinaResponse created(DisciplinaRequest request) {
        DisciplinaEntity entity = mapper.toEntity(request);
        entity.setStatus(StatusEnum.ATIVO);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public DisciplinaResponse update(Long id, DisciplinaRequest request) {
        DisciplinaEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(DISCIPLINA_NAO_ENCONTRADA));

        entity.setDescricao(request.descricao());
        entity.setTpFuncao(request.tpFuncao());
        entity.setStatus(request.status());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        DisciplinaEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(DISCIPLINA_NAO_ENCONTRADA));

        entity.setStatus(StatusEnum.INATIVO);
        repository.save(entity);
    }

    @Override
    public DisciplinaResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException(DISCIPLINA_NAO_ENCONTRADA));
    }

    @Override
    public Page<DisciplinaResponse> getPaginated(StatusEnum status, Pageable pageable) {
        return repository.findByStatus(status, pageable)
                .map(mapper::toResponse);
    }
}


