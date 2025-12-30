package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.TarefaEntity;
import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @Mapping(target = "id", ignore = true)
    TarefaEntity toEntity(TarefaRequest request);

    @Mapping(target = "disciplinaId", expression = "java(setDisciplinaId(entity))")
    @Mapping(target = "disciplina", expression = "java(setDisciplinaNome(entity))")
    @Mapping(target = "status", expression = "java(setStatus(entity))")
    @Mapping(target = "disciplinaTpFuncao", expression = "java(setDisciplicaTpFuncao(entity))")
    TarefaResponse toResponse(TarefaEntity entity);

    default Long setDisciplinaId(TarefaEntity entity){
        if(entity == null || entity.getDisciplina() == null)
            return null;

        return entity.getDisciplina().getId();
    }

    default String setDisciplinaNome(TarefaEntity entity){
        if(entity == null || entity.getDisciplina() == null)
            return null;

        return entity.getDisciplina().getDescricao();
    }

    default StatusEnum setStatus(TarefaEntity entity){
        if(entity == null || entity.getStatus() == null)
            return null;

        return entity.getStatus();
    }

    default DisciplinaTipoFuncaoEnum setDisciplicaTpFuncao(TarefaEntity entity){
        if(entity == null || entity.getDisciplina() == null)
            return null;

        return entity.getDisciplina().getTpFuncao();
    }
}
