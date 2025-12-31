package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.HistoricoOrcamentoRequisitoEntity;
import br.com.thstec.hsts.model.historico_orcamento_requisito.request.HistoricoOrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.historico_orcamento_requisito.response.HistoricoOrcamentoRequisitoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricoOrcamentoRequisitoMapper {

    @Mapping(target = "id", ignore = true)
    HistoricoOrcamentoRequisitoEntity toEntity(HistoricoOrcamentoRequisitoRequest request);
    HistoricoOrcamentoRequisitoResponse toResponse(HistoricoOrcamentoRequisitoEntity entity);
}
