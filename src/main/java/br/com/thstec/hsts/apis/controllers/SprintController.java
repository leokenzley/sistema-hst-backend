package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.SprintAPI;
import br.com.thstec.hsts.model.sprint.request.SprintRequest;
import br.com.thstec.hsts.model.sprint.response.SprintResponse;
import br.com.thstec.hsts.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SprintController implements SprintAPI {
    private final SprintService service;

    @Override
    public ResponseEntity<SprintResponse> create(SprintRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    public ResponseEntity<SprintResponse> update(Long id, SprintRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<SprintResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<SprintResponse>> getByProjetoPaginated(Long projetoId, Pageable pageable) {
        return ResponseEntity.ok(service.getByProjectPaginated(projetoId, pageable));
    }


    @Override
    public ResponseEntity<List<SprintResponse>> getByProjetoList(Long projetoId) {
        return ResponseEntity.ok(service.getByProjetoList(projetoId));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

