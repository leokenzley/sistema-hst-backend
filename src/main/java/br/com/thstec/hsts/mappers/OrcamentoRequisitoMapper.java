package br.com.thstec.hsts.mappers;


import br.com.thstec.hsts.entities.OrcamentoRequisitoEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.orcamento_requisito.request.OrcamentoRequisitoRequest;
import br.com.thstec.hsts.model.orcamento_requisito.response.OrcamentoRequisitoResponse;
import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrcamentoRequisitoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(setStatus(request))")
    OrcamentoRequisitoEntity toEntity(OrcamentoRequisitoRequest request);

    @Mapping(target = "status", expression = "java(setStatus(entity))")
    OrcamentoRequisitoResponse toResponse(OrcamentoRequisitoEntity entity);

    default StatusEnum setStatus(OrcamentoRequisitoRequest request){
        if(request == null)
            return null;

        return request.status();
    }

    default String setStatus(OrcamentoRequisitoEntity entity){
        if(entity == null)
            return null;

        return entity.getStatus().getCodigo();
    }
}