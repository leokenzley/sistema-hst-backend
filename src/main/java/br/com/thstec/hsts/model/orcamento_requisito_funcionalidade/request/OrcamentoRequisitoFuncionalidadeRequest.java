package br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request;

import java.math.BigDecimal;

public record OrcamentoRequisitoFuncionalidadeRequest(
        Long orcamentoRequisitoId,
        Long tarefaId,
        String observacao,
        String comprovante,
        BigDecimal quantidadeHoras,
        BigDecimal valorFinal
) {
}