package br.com.thstec.hsts.model.historico_orcamento_requisito.response;


import java.time.LocalDateTime;

public record HistoricoOrcamentoRequisitoResponse(
        Long id,
        String observacao,
        LocalDateTime dtCreated,
        String requisitoStatus,
        Long orcamentoRequisitoId
) {
}