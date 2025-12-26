package br.com.thstec.hsts.model.projeto.request;

import br.com.thstec.hsts.model.enumerations.StatusEnum;

public record ProjetoRequest(
        String nome,
        String detalhe,
        StatusEnum status
) {
}
