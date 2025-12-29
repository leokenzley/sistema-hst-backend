package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrcamentoRequisitoFuncionalidadeMapper {

    @Mapping(target = "id", ignore = true)
    OrcamentoRequisitoFuncionalidadeEntity toEntity(OrcamentoRequisitoFuncionalidadeRequest request);

    OrcamentoRequisitoFuncionalidadeResponse toResponse(OrcamentoRequisitoFuncionalidadeEntity entity);
}
