package br.com.thstec.hsts.services.impl;

import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.exceptions.commons.NotFoundException;
import br.com.thstec.hsts.repositories.ProjetoRepository;
import br.com.thstec.hsts.mappers.ProjetoMapper;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import br.com.thstec.hsts.model.projeto.response.ProjetoResponse;
import br.com.thstec.hsts.services.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    @Override
    public ProjetoResponse created(ProjetoRequest request) {
        ProjetoEntity entity = mapper.toEntity(request);
        var created = repository.save(entity);
        return mapper.toResponse(created);
    }

    @Override
    public ProjetoResponse update(Long id, ProjetoRequest request) {
        ProjetoEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projeto não encontrado"));

        entity.setNome(request.nome());
        entity.setDetalhe(request.detalhe());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        ProjetoEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projeto não encontrado"));

        entity.setStatus(StatusEnum.INATIVO);
        repository.save(entity);
    }

    @Override
    public ProjetoResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
    }

    @Override
    public Page<ProjetoResponse> getPaginated(Pageable pageable) {
        return repository.findByStatusOrderByNomeAsc(StatusEnum.ATIVO, pageable)
                .map(mapper::toResponse);
    }
}
