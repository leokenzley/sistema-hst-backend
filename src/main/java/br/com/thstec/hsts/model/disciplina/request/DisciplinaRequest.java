package br.com.thstec.hsts.model.disciplina.request;

import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;

public record DisciplinaRequest(
        String descricao,
        DisciplinaTipoFuncaoEnum tpFuncao,
        StatusEnum status
) {}