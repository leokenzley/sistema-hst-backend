package br.com.thstec.hsts.model.disciplina.request;

import br.com.thstec.hsts.model.enumerations.StatusEnum;

public record DisciplinaRequest(
        String descricao,
        String tpFuncao,
        StatusEnum status
) {}