package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.OrcamentoRequisitoAPI;
import br.com.thstec.hsts.model.orcamento_requisito.request.OrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.orcamento_requisito.response.OrcamentoRequisitoResponse;
import br.com.thstec.hsts.services.OrcamentoRequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrcamentoRequisitoController implements OrcamentoRequisitoAPI {

    private final OrcamentoRequisitoService service;

    @Override
    public ResponseEntity<OrcamentoRequisitoResponse> create(OrcamentoRequisitoRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    public ResponseEntity<OrcamentoRequisitoResponse> update(Long id, OrcamentoRequisitoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<OrcamentoRequisitoResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<OrcamentoRequisitoResponse>> getPaginated(Pageable pageable) {
        return ResponseEntity.ok(service.getPaginated(pageable));
    }
}
