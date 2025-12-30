package br.com.thstec.hsts.model.tarefa.response;

import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;

import java.math.BigDecimal;

public record TarefaResponse(
        Long id,
        String nome,
        String descricaoHistoricoReferencia,
        BigDecimal valorHistoricoReferencia,
        String detalhe,
        String fatorImpacto,
        String memoriaCalculo,
        StatusEnum status,
        Long disciplinaId,
        String disciplina,
        DisciplinaTipoFuncaoEnum disciplinaTpFuncao
) {
}
