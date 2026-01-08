package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.enumerations.RequisitoStatusEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.orcamento_requisito.request.OrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.orcamento_requisito.response.OrcamentoRequisitoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API Orçamento Requisito")
@RequestMapping("/v1/orcamento-requisitos")
public interface OrcamentoRequisitoAPI {

    @PostMapping
    ResponseEntity<OrcamentoRequisitoResponse> create(@RequestBody OrcamentoRequisitoRequest request);

    @PutMapping("/{id}")
    ResponseEntity<OrcamentoRequisitoResponse> update(
            @PathVariable Long id,
            @RequestBody OrcamentoRequisitoRequest request
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<OrcamentoRequisitoResponse> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<OrcamentoRequisitoResponse>> getPaginated(
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "requisitoStatus", required = false) String requisitoStatusEnum,
            @RequestParam(name = "sprintId", required = false) Long sprintId,
            Pageable pageable);

    @GetMapping("/sprint/{sprintId}/summary")
    ResponseEntity<OrcamentoRequisitoResponse> getSummaryBySprintId(@PathVariable Long sprintId);

    @PatchMapping("/{id}")
    ResponseEntity<OrcamentoRequisitoResponse> patch(
            @PathVariable("id") Long id,
            @RequestParam(name= "requisitoStatus", required = false) String requisitoStatus);

}
