package br.com.thstec.hsts.model.sprint.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class SprintResponseReport {
    private String descricao;
    private BigDecimal hstOrcado;
}
