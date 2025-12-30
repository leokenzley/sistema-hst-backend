package br.com.thstec.hsts.model.disciplina.response;

import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;

public record DisciplinaResponse(
        Long id,
        String descricao,
        DisciplinaTipoFuncaoEnum tpFuncao,
        String status
) {}
