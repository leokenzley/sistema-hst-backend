package br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response;


import br.com.thstec.hsts.model.enumerations.StatusEnum;

import java.math.BigDecimal;

public record OrcamentoRequisitoFuncionalidadeResponse(
        Long id,
        Long orcamentoRequisitoId,
        String orcamentoRequisitoNome,
        Long tarefaId,
        String tarefaNome,
        String observacao,
        String comprovante,
        BigDecimal quantidadeHoras,
        BigDecimal valorFinal,
        StatusEnum status
) {
}
