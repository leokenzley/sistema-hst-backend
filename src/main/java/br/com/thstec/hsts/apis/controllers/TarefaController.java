package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.TarefaAPI;
import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import br.com.thstec.hsts.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class TarefaController implements TarefaAPI {
    private final TarefaService service;

    @Override
    public ResponseEntity<TarefaResponse> created(TarefaRequest request) {
        return ResponseEntity.ok(service.created(request));
    }

    @Override
    public ResponseEntity<TarefaResponse> update(Long id, TarefaRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public ResponseEntity<TarefaResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<TarefaResponse>> getPaginated(
            Pageable pageable,
            String status,
            DisciplinaTipoFuncaoEnum tpFuncao
            ) {
        var statusEnum = Objects.nonNull(status) ? StatusEnum.fromCodigo(status) : null;
        return ResponseEntity.ok(service.getPaginated(pageable, statusEnum, tpFuncao));
    }

    @Override
    public ResponseEntity<List<TarefaResponse>> getListed(String status, DisciplinaTipoFuncaoEnum tpFuncao) {
        if(status != null && !status.isEmpty()) {
            return ResponseEntity.ok(service.getListed(StatusEnum.fromCodigo(status), tpFuncao));
        }
        return ResponseEntity.ok(service.getListed(null, tpFuncao));
    }

}
