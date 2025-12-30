package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.DisciplinaAPI;
import br.com.thstec.hsts.model.disciplina.request.DisciplinaRequest;
import br.com.thstec.hsts.model.disciplina.response.DisciplinaResponse;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class DisciplinaController implements DisciplinaAPI {

    private final br.com.thstec.hsts.services.DisciplinaService service;

    @Override
    public ResponseEntity<DisciplinaResponse> create(DisciplinaRequest request) {
        return ResponseEntity.ok(service.created(request));
    }

    @Override
    public ResponseEntity<DisciplinaResponse> update(Long id, DisciplinaRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DisciplinaResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<DisciplinaResponse>> getPaginated(String status, Pageable pageable) {
        var statusEnum = Objects.nonNull(status) ? StatusEnum.fromCodigo(status) : null;
        return ResponseEntity.ok(service.getPaginated(statusEnum, pageable));
    }
}
