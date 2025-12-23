package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.SprintEntity;
import br.com.thstec.hsts.model.sprint.request.SprintRequest;
import br.com.thstec.hsts.model.sprint.response.SprintResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SprintMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "detalhe", source = "detalhe")
    @Mapping(target = "status", source = "status")
    SprintEntity toEntity(SprintRequest request);

    @Mapping(target = "status", expression = "java(setStatus(entity))")
    @Mapping(target = "projetoId", expression = "java(setProjetoId(entity))")
    @Mapping(target = "projetoNome", expression = "java(setProjetoNome(entity))")
    SprintResponse toResponse(SprintEntity entity);

    default Long setProjetoId(SprintEntity entity){
        if(entity == null || entity.getProjeto() == null)
            return null;

        return entity.getProjeto().getId();
    }

    default String setProjetoNome(SprintEntity entity){
        if(entity == null || entity.getProjeto() == null)
            return null;

        return entity.getProjeto().getNome();
    }
    default String setStatus(SprintEntity entity){
        if(entity == null)
            return null;

        return entity.getStatus().getCodigo();
    }
}

