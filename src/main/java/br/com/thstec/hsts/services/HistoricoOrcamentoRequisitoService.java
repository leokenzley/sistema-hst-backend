package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.historico_orcamento_requisito.request.HistoricoOrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.historico_orcamento_requisito.response.HistoricoOrcamentoRequisitoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoricoOrcamentoRequisitoService {
    HistoricoOrcamentoRequisitoResponse create(HistoricoOrcamentoRequisitoRequest request);
    Page<HistoricoOrcamentoRequisitoResponse> getPaginated(Long orcamentoRequisitoId, Pageable pageable);
}
