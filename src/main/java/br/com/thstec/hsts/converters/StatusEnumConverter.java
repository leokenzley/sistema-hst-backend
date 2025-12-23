package br.com.thstec.hsts.converters;

import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum status) {
        return status == null ? null : status.getCodigo();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String dbValue) {
        if (dbValue == null) return null;

        return switch (dbValue) {
            case "A" -> StatusEnum.ATIVO;
            case "I" -> StatusEnum.INATIVO;
            default -> throw new IllegalArgumentException("Status inválido: " + dbValue);
        };
    }
}
