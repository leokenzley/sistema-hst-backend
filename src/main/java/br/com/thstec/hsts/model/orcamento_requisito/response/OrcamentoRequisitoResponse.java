package br.com.thstec.hsts.model.orcamento_requisito.response;


import java.time.LocalDate;

public record OrcamentoRequisitoResponse(
        Long id,
        Long sprintId,
        String requisito,
        String detalhe,
        LocalDate dtInicio,
        LocalDate dtFim,
        LocalDate dtFinalizada,
        String status
) {}
