package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.OrcamentoRequisitoFuncionalidadeAPI;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import br.com.thstec.hsts.services.OrcamentoRequisitoFuncionalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrcamentoRequisitoFuncionalidadeController
        implements OrcamentoRequisitoFuncionalidadeAPI {

    private final OrcamentoRequisitoFuncionalidadeService service;

    @Override
    public ResponseEntity<OrcamentoRequisitoFuncionalidadeResponse> created(OrcamentoRequisitoFuncionalidadeRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    public ResponseEntity<OrcamentoRequisitoFuncionalidadeResponse> update(Long id, OrcamentoRequisitoFuncionalidadeRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public ResponseEntity<OrcamentoRequisitoFuncionalidadeResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<OrcamentoRequisitoFuncionalidadeResponse>> getPaginated(Long orcamentoRequisitoId, Pageable pageable) {
        return ResponseEntity.ok(service.getPaginated(orcamentoRequisitoId, pageable));
    }
}

