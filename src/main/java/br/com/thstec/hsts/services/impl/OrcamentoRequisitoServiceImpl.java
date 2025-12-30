package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.OrcamentoRequisitoEntity;
import br.com.thstec.hsts.entities.SprintEntity;
import br.com.thstec.hsts.exceptions.commons.NotFoundException;
import br.com.thstec.hsts.mappers.OrcamentoRequisitoMapper;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.orcamento_requisito.request.OrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.orcamento_requisito.response.OrcamentoRequisitoResponse;
import br.com.thstec.hsts.repositories.OrcamentoRequisitoRepository;
import br.com.thstec.hsts.repositories.SprintRepository;
import br.com.thstec.hsts.services.OrcamentoRequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrcamentoRequisitoServiceImpl implements OrcamentoRequisitoService {

    private final OrcamentoRequisitoRepository repository;
    private final OrcamentoRequisitoMapper mapper;
    private final SprintRepository sprintRepository;

    @Override
    public OrcamentoRequisitoResponse create(OrcamentoRequisitoRequest request) {
        try {
            var sprint = sprintRepository.findById(request.sprintId())
                    .orElseThrow(() -> new NotFoundException("Sprint não encontrada"));
            OrcamentoRequisitoEntity entity = mapper.toEntity(request);
            entity.setSprint(sprint);
            return mapper.toResponse(repository.save(entity));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public OrcamentoRequisitoResponse update(Long id, OrcamentoRequisitoRequest request) {
        OrcamentoRequisitoEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Orçamento requisito não encontrado"));

        SprintEntity sprintEntity = sprintRepository.findById(request.sprintId())
                .orElseThrow(() -> new NotFoundException("Sprint não encontrada"));

        entity.setSprint(sprintEntity);
        entity.setRequisito(request.requisito());
        entity.setDetalhe(request.detalhe());
        entity.setDtInicio(request.dtInicio());
        entity.setDtFim(request.dtFim());
        entity.setDtFinalizada(request.dtFinalizada());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        OrcamentoRequisitoEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Orçamento requisito não encontrado"));

        entity.setStatus(StatusEnum.INATIVO);
        repository.save(entity);
    }

    @Override
    public OrcamentoRequisitoResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Orçamento requisito não encontrado"));
    }

    @Override
    public Page<OrcamentoRequisitoResponse> getPaginated(Pageable pageable) {
        return repository.findByStatus(StatusEnum.ATIVO, pageable)
                .map(mapper::toResponse);
    }
}
