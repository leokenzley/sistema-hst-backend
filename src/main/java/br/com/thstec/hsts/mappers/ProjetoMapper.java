package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.ProjetoEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import br.com.thstec.hsts.model.projeto.response.ProjetoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(setStatus(request))")
    ProjetoEntity toEntity(ProjetoRequest request);

    ProjetoResponse toResponse(ProjetoEntity entity);

    default StatusEnum setStatus(ProjetoRequest request){
        if(request == null)
            return null;

        return request.status();
    }
}

