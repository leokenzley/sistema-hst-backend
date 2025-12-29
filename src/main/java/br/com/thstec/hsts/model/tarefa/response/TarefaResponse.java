package br.com.thstec.hsts.model.tarefa.response;

import java.math.BigDecimal;

public record TarefaResponse(
        Long id,
        String nome,
        String descricaoHistoricoReferencia,
        BigDecimal valorHistoricoReferencia,
        String detalhe,
        String fatorImpacto,
        String memoriaCalculo,
        String status,
        Long disciplinaId
) {
}
