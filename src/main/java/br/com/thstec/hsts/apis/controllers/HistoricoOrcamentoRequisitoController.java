package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.HistoricoOrcamentoRequisitoAPI;
import br.com.thstec.hsts.model.historico_orcamento_requisito.request.HistoricoOrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.historico_orcamento_requisito.response.HistoricoOrcamentoRequisitoResponse;
import br.com.thstec.hsts.services.HistoricoOrcamentoRequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HistoricoOrcamentoRequisitoController
        implements HistoricoOrcamentoRequisitoAPI {

    private final HistoricoOrcamentoRequisitoService service;

    @Override
    public HistoricoOrcamentoRequisitoResponse create(HistoricoOrcamentoRequisitoRequest request) {
        return service.create(request);
    }

    @Override
    public Page<HistoricoOrcamentoRequisitoResponse> getPaginated(Long orcamentoRequisitoId, Pageable pageable) {
        return service.getPaginated(orcamentoRequisitoId, pageable);
    }
}
