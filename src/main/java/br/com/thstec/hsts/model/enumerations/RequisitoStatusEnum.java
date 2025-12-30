package br.com.thstec.hsts.model.enumerations;

/**
 *     INICIADO = Requisito foi criado na sprint
 *     PENDENTE_VALIDACAO = Foi finalizado e precisa ser validado
 *     VALIDADO = Requisito foi validado
 *     COBRADO = Planilha foi finalizada e o requisito foi cobrado
 */
public enum RequisitoStatusEnum {
    INICIADO,
    PENDENTE_VALIDACAO,
    VALIDADO,
    COBRADO;
}
