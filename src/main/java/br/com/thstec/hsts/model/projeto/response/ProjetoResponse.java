package br.com.thstec.hsts.model.projeto.response;

import br.com.thstec.hsts.model.enumerations.StatusEnum;

public record ProjetoResponse(
        Long id,
        String nome,
        String detalhe,
        StatusEnum status
) {
}
