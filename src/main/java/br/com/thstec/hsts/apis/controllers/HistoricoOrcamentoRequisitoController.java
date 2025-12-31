package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.HistoricoOrcamentoRequisitoAPI;
import br.com.thstec.hsts.model.historico_orcamento_requisito.request.HistoricoOrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.historico_orcamento_requisito.response.HistoricoOrcamentoRequisitoResponse;
import br.com.thstec.hsts.services.HistoricoOrcamentoRequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HistoricoOrcamentoRequisitoController
        implements HistoricoOrcamentoRequisitoAPI {

    private final HistoricoOrcamentoRequisitoService service;

    @Override
    public ResponseEntity<HistoricoOrcamentoRequisitoResponse> create(HistoricoOrcamentoRequisitoRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    public ResponseEntity<Page<HistoricoOrcamentoRequisitoResponse>> getPaginated(Long orcamentoRequisitoId, Pageable pageable) {
        return ResponseEntity.ok(service.getPaginated(orcamentoRequisitoId, pageable));
    }
}
