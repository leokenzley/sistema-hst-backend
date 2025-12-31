package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API Orçamento Requisito Funcionalidades")
@RequestMapping("/v1/orcamentos-requisitos-funcionalidades")
public interface OrcamentoRequisitoFuncionalidadeAPI {

    @PostMapping
    ResponseEntity<OrcamentoRequisitoFuncionalidadeResponse> created(
            @RequestBody OrcamentoRequisitoFuncionalidadeRequest request
    );

    @PutMapping("/{id}")
    ResponseEntity<OrcamentoRequisitoFuncionalidadeResponse> update(
            @PathVariable Long id,
            @RequestBody OrcamentoRequisitoFuncionalidadeRequest request
    );

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<OrcamentoRequisitoFuncionalidadeResponse> findById(@PathVariable Long id);

    @GetMapping("/orcamento-requisito/{orcamentoRequisitoId}/paginated")
    ResponseEntity<Page<OrcamentoRequisitoFuncionalidadeResponse>> getPaginated(
            @PathVariable("orcamentoRequisitoId") Long orcamentoRequisitoId,
            Pageable pageable);
}

