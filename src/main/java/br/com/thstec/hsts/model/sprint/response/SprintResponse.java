package br.com.thstec.hsts.model.sprint.response;

import java.time.LocalDate;

public record SprintResponse(
        Long id,
        Integer numero,
        String detalhe,
        LocalDate dtInicio,
        LocalDate dtFim,
        String status,
        Long projetoId,
        String projetoNome
) {
}
