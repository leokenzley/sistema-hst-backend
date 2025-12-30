package br.com.thstec.hsts.model.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {

    ATIVO("A"),
    INATIVO("I");

    private final String codigo;

    StatusEnum(String codigo) {
        this.codigo = codigo;
    }

    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    public static StatusEnum fromCodigo(String codigo) {
        for (StatusEnum status : values()) {
            if (status.codigo.equalsIgnoreCase(codigo)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + codigo);
    }
}

