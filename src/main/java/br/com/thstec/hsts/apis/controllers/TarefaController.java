package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.TarefaAPI;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import br.com.thstec.hsts.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TarefaController implements TarefaAPI {
    private final TarefaService service;

    @Override
    public TarefaResponse created(TarefaRequest request) {
        return service.created(request);
    }

    @Override
    public TarefaResponse update(Long id, TarefaRequest request) {
        return service.update(id, request);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public TarefaResponse findById(Long id) {
        return service.findById(id);
    }

    @Override
    public Page<TarefaResponse> getPaginated(Pageable pageable) {
        return service.getPaginated(pageable);
    }

}
