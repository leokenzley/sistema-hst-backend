package br.com.thstec.hsts.converters;

import br.com.thstec.hsts.model.enumerations.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter
        implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum status) {
        return status != null ? status.getCodigo() : null;
    }

    @Override
    public StatusEnum convertToEntityAttribute(String dbValue) {
        if (dbValue == null) {
            return null;
        }

        try {
            return StatusEnum.fromCodigo(dbValue);
        } catch (IllegalArgumentException ex) {
            throw new IllegalStateException(
                    "Valor inválido para StatusEnum no banco: " + dbValue, ex
            );
        }
    }
}

