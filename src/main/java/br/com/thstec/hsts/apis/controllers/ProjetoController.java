package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.ProjetoAPI;
import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import br.com.thstec.hsts.model.projeto.response.ProjetoResponse;
import br.com.thstec.hsts.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetoController implements ProjetoAPI {

    @Autowired
    private ProjetoService service;

    @Override
    public ResponseEntity<ProjetoResponse> created(ProjetoRequest request) {
        return ResponseEntity.ok(service.created(request));
    }

    @Override
    public ResponseEntity<ProjetoResponse> update(Long id, ProjetoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProjetoResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<ProjetoResponse>> getPaginated(Pageable pageable) {
        return ResponseEntity.ok(service.getPaginated(pageable));
    }
}

