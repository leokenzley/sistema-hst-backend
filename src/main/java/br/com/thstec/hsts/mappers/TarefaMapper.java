package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.TarefaEntity;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @Mapping(target = "id", ignore = true)
    TarefaEntity toEntity(TarefaRequest request);

    TarefaResponse toResponse(TarefaEntity entity);
}
