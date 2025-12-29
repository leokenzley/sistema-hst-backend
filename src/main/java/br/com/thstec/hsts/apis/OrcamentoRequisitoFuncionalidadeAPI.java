package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API Orçamento Requisito Funcionalidades")
@RequestMapping("/orcamentos-requisitos-funcionalidades")
public interface OrcamentoRequisitoFuncionalidadeAPI {

    @PostMapping
    OrcamentoRequisitoFuncionalidadeResponse created(
            @RequestBody OrcamentoRequisitoFuncionalidadeRequest request
    );

    @PutMapping("/{id}")
    OrcamentoRequisitoFuncionalidadeResponse update(
            @PathVariable Long id,
            @RequestBody OrcamentoRequisitoFuncionalidadeRequest request
    );

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @GetMapping("/{id}")
    OrcamentoRequisitoFuncionalidadeResponse findById(@PathVariable Long id);

    @GetMapping
    Page<OrcamentoRequisitoFuncionalidadeResponse> getPaginated(Pageable pageable);
}

