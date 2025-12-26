package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.DisciplinaEntity;
import br.com.thstec.hsts.model.disciplina.request.DisciplinaRequest;
import br.com.thstec.hsts.model.disciplina.response.DisciplinaResponse;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(setStatus(request))")
    DisciplinaEntity toEntity(DisciplinaRequest request);

    @Mapping(target = "status", expression = "java(setStatus(entity))")
    DisciplinaResponse toResponse(DisciplinaEntity entity);

    default StatusEnum setStatus(DisciplinaRequest request){
        if(request == null)
            return null;

        return request.status();
    }

    default String setStatus(DisciplinaEntity entity){
        if(entity == null)
            return null;

        return entity.getStatus().getCodigo();
    }
}
