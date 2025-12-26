package br.com.thstec.hsts.model.orcamento_requisito.request;


import br.com.thstec.hsts.model.enumerations.StatusEnum;

import java.time.LocalDate;

public record OrcamentoRequisitoRequest(
        Long sprintId,
        String requisito,
        String detalhe,
        LocalDate dtInicio,
        LocalDate dtFim,
        LocalDate dtFinalizada,
        StatusEnum status
) {}
