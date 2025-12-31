package br.com.thstec.hsts.mappers;

import br.com.thstec.hsts.entities.OrcamentoRequisitoEntity;
import br.com.thstec.hsts.entities.OrcamentoRequisitoFuncionalidadeEntity;
import br.com.thstec.hsts.entities.TarefaEntity;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.request.OrcamentoRequisitoFuncionalidadeRequest;
import br.com.thstec.hsts.model.orcamento_requisito_funcionalidade.response.OrcamentoRequisitoFuncionalidadeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrcamentoRequisitoFuncionalidadeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarefa", expression = "java(setTarefa(request))")
    @Mapping(target = "orcamentoRequisito", expression = "java(setOrcamentoRequisito(request))")
    @Mapping(target = "status", expression = "java(setStatus(request))")
    OrcamentoRequisitoFuncionalidadeEntity toEntity(OrcamentoRequisitoFuncionalidadeRequest request);


    @Mapping(target = "status", expression = "java(setStatus(entity))")
    @Mapping(target = "tarefaNome", expression = "java(setTarefaNome(entity))")
    @Mapping(target = "tarefaId", expression = "java(setTarefaId(entity))")
    @Mapping(target = "orcamentoRequisitoNome", expression = "java(setOrcamentoRequisitoNome(entity))")
    @Mapping(target = "orcamentoRequisitoId", expression = "java(setOrcamentoRequisitoId(entity))")
    OrcamentoRequisitoFuncionalidadeResponse toResponse(OrcamentoRequisitoFuncionalidadeEntity entity);

    default String setTarefaNome(OrcamentoRequisitoFuncionalidadeEntity entity){
        return (entity.getTarefa() == null || entity.getTarefa().getNome() == null) ? null : entity.getTarefa().getNome();
    }

    default String setOrcamentoRequisitoNome(OrcamentoRequisitoFuncionalidadeEntity entity){
        return (entity.getOrcamentoRequisito() == null || entity.getOrcamentoRequisito().getRequisito() == null) ? null : entity.getOrcamentoRequisito().getRequisito();
    }

    default Long setTarefaId(OrcamentoRequisitoFuncionalidadeEntity entity){
        return (entity.getTarefa() == null || entity.getTarefa().getId() == null) ? null : entity.getTarefa().getId();
    }

    default Long setOrcamentoRequisitoId(OrcamentoRequisitoFuncionalidadeEntity entity){
        return (entity.getOrcamentoRequisito() == null || entity.getOrcamentoRequisito().getId() == null) ? null : entity.getOrcamentoRequisito().getId();
    }

    default TarefaEntity setTarefa(OrcamentoRequisitoFuncionalidadeRequest request){
        if(request == null || request.tarefaId() == null)
            return null;

        return TarefaEntity.builder().id(request.tarefaId()).build();
    }

    default OrcamentoRequisitoEntity setOrcamentoRequisito(OrcamentoRequisitoFuncionalidadeRequest request){
        if(request == null || request.orcamentoRequisitoId() == null)
            return null;

        return OrcamentoRequisitoEntity.builder().id(request.orcamentoRequisitoId()).build();
    }

    default StatusEnum setStatus(OrcamentoRequisitoFuncionalidadeRequest request){
        if(request == null || request.status() == null)
            return null;

        return request.status();
    }

    default StatusEnum setStatus(OrcamentoRequisitoFuncionalidadeEntity entity){
        if(entity == null || entity.getStatus() == null)
            return null;

        return entity.getStatus();
    }
}
