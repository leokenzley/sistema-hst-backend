package br.com.thstec.hsts.model.historico_orcamento_requisito.request;

import java.time.LocalDateTime;

public record HistoricoOrcamentoRequisitoRequest(
        String observacao,
        LocalDateTime dtCreated,
        String requisitoStatus,
        Long orcamentoRequisitoId
) {
}
