package br.com.thstec.hsts.model.tarefa.request;

import java.math.BigDecimal;

public record TarefaRequest(
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
