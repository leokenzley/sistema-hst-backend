package br.com.thstec.hsts.services.impl;


import br.com.thstec.hsts.entities.HistoricoOrcamentoRequisitoEntity;
import br.com.thstec.hsts.mappers.HistoricoOrcamentoRequisitoMapper;
import br.com.thstec.hsts.model.historico_orcamento_requisito.request.HistoricoOrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.historico_orcamento_requisito.response.HistoricoOrcamentoRequisitoResponse;
import br.com.thstec.hsts.repositories.HistoricoOrcamentoRequisitoRepository;
import br.com.thstec.hsts.services.HistoricoOrcamentoRequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoricoOrcamentoRequisitoServiceImpl
        implements HistoricoOrcamentoRequisitoService {
    private final HistoricoOrcamentoRequisitoRepository repository;
    private final HistoricoOrcamentoRequisitoMapper mapper;

    @Override
    public HistoricoOrcamentoRequisitoResponse create(HistoricoOrcamentoRequisitoRequest request) {
        HistoricoOrcamentoRequisitoEntity entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public Page<HistoricoOrcamentoRequisitoResponse> getPaginated(Long orcamentoRequisitoId, Pageable pageable) {
        return repository.getPaginated(orcamentoRequisitoId, pageable).map(mapper::toResponse);
    }
}


