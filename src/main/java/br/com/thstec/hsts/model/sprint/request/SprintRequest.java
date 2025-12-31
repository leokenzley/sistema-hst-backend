package br.com.thstec.hsts.model.sprint.request;

import br.com.thstec.hsts.model.enumerations.StatusEnum;

import java.time.LocalDate;

public record SprintRequest(
        Integer numero,
        String detalhe,
        LocalDate dtInicio,
        LocalDate dtFim,
        Long projetoId,
        StatusEnum status,
        Boolean migrarReq
) {
}
