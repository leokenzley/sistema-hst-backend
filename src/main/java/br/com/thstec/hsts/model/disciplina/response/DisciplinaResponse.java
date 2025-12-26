package br.com.thstec.hsts.model.disciplina.response;

public record DisciplinaResponse(
        Long id,
        String descricao,
        String tpFuncao,
        String status
) {}
