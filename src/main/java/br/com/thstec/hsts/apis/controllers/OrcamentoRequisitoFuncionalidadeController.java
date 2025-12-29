package br.com.thstec.hsts.apis.controllers;

import br.com.thstec.hsts.apis.OrcamentoRequisitoFuncionalidadeAPI;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import br.com.thstec.hsts.services.OrcamentoRequisitoFuncionalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrcamentoRequisitoFuncionalidadeController
        implements OrcamentoRequisitoFuncionalidadeAPI {

    private final OrcamentoRequisitoFuncionalidadeService service;

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse created(OrcamentoRequisitoFuncionalidadeRequest request) {
        return service.created(request);
    }

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse update(Long id, OrcamentoRequisitoFuncionalidadeRequest request) {
        return service.update(id, request);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public OrcamentoRequisitoFuncionalidadeResponse findById(Long id) {
        return service.findById(id);
    }

    @Override
    public Page<OrcamentoRequisitoFuncionalidadeResponse> getPaginated(Pageable pageable) {
        return service.getPaginated(pageable);
    }
}

