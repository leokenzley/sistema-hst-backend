package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.historico_orcamento_requisito.request.HistoricoOrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.historico_orcamento_requisito.response.HistoricoOrcamentoRequisitoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API Histórico Orçamento Requisito")
@RequestMapping("/v1/historico-orcamento-requisitos")
public interface HistoricoOrcamentoRequisitoAPI {

    @PostMapping
    HistoricoOrcamentoRequisitoResponse create(
            @RequestBody HistoricoOrcamentoRequisitoRequest request
    );

    @GetMapping("/orcamento-requisito/{orcamentoRequisitoId}/paginated")
    Page<HistoricoOrcamentoRequisitoResponse> getPaginated(
            @PathVariable(value = "orcamentoRequisitoId") Long orcamentoRequisitoId,
            Pageable pageable);
}
