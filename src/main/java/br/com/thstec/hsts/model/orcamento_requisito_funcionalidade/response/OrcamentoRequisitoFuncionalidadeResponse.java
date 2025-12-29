package br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response;


import java.math.BigDecimal;

public record OrcamentoRequisitoFuncionalidadeResponse(
        Long id,
        Long orcamentoRequisitoId,
        Long tarefaId,
        String observacao,
        String comprovante,
        BigDecimal quantidadeHoras,
        BigDecimal valorFinal
) {
}
