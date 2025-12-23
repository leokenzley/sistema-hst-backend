package br.com.thstec.hsts.model.enumerations;

public enum StatusEnum {

    ATIVO("A"),
    INATIVO("I");

    private final String codigo;

    StatusEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
