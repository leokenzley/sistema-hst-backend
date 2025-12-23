package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.entities.SprintEntity;
import br.com.thstec.hsts.exceptions.commons.NotFoundException;
import br.com.thstec.hsts.mappers.SprintMapper;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.sprint.request.SprintRequest;
import br.com.thstec.hsts.model.sprint.response.SprintResponse;
import br.com.thstec.hsts.repositories.ProjetoRepository;
import br.com.thstec.hsts.repositories.SprintRepository;
import br.com.thstec.hsts.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintServiceImpl implements SprintService {

    public static final String SPRINT_NAO_ENCONTRADA = "Sprint não encontrada";
    private final SprintRepository repository;
    private final SprintMapper mapper;
    private final ProjetoRepository projetoRepository;

    @Override
    public SprintResponse create(SprintRequest request) {
        SprintEntity entity = mapper.toEntity(request);
        entity.setProjeto(projetoRepository.findById(request.projetoId())
                .orElseThrow(() -> new NotFoundException(SPRINT_NAO_ENCONTRADA)));
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public SprintResponse update(Long id, SprintRequest request) {
        SprintEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(SPRINT_NAO_ENCONTRADA));

        entity.setNumero(request.numero());
        entity.setDetalhe(request.detalhe());
        entity.setDtInicio(request.dtInicio());
        entity.setDtFim(request.dtFim());
        entity.setStatus(request.status());
        entity.setProjeto(projetoRepository.findById(request.projetoId())
                .orElseThrow(() -> new NotFoundException(SPRINT_NAO_ENCONTRADA)));
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        SprintEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(SPRINT_NAO_ENCONTRADA));

        entity.setStatus(StatusEnum.INATIVO);
        repository.save(entity);
    }

    @Override
    public SprintResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException(SPRINT_NAO_ENCONTRADA));
    }

    @Override
    public Page<SprintResponse> getByProjectPaginated(Long projectId, Pageable pageable) {
        Page<SprintEntity> sprintsResponse = repository.findAllByProjetoIdPaganated(projectId, pageable);
        var content = sprintsResponse.getContent().stream().map(mapper::toResponse).toList();
        return new PageImpl<>(content, pageable, sprintsResponse.getTotalElements());
    }

    @Override
    public List<SprintResponse> getByProjetoList(Long projectId) {
        return repository.findAllByProjetoIdList(projectId).stream().map(mapper::toResponse).toList();
    }
}
