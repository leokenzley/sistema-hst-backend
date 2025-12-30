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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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
    public Page<TarefaResponse> getPaginated(
            Pageable pageable,
            String status,
            DisciplinaTipoFuncaoEnum tpFuncao
            ) {
        var statusEnum = Objects.nonNull(status) ? StatusEnum.fromCodigo(status) : null;
        return service.getPaginated(pageable, statusEnum, tpFuncao);
    }

    @Override
    public List<TarefaResponse> getListed(String status, DisciplinaTipoFuncaoEnum tpFuncao) {
        if(status != null && !status.isEmpty()) {
            return service.getListed(StatusEnum.fromCodigo(status), tpFuncao);
        }
        return service.getListed(null, tpFuncao);
    }

}
