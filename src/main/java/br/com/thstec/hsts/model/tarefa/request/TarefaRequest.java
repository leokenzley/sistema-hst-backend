package br.com.thstec.hsts.model.tarefa.request;

import br.com.thstec.hsts.model.enumerations.StatusEnum;

import java.math.BigDecimal;

public record TarefaRequest(
        String nome,
        String descricaoHistoricoReferencia,
        BigDecimal valorHistoricoReferencia,
        String detalhe,
        String fatorImpacto,
        String memoriaCalculo,
        StatusEnum status,
        Long disciplinaId
) {
}
