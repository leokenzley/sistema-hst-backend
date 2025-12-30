package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TarefaService {

    TarefaResponse created(TarefaRequest request);

    TarefaResponse update(Long id, TarefaRequest request);

    void deleteById(Long id);

    TarefaResponse findById(Long id);

    Page<TarefaResponse> getPaginated(Pageable pageable, StatusEnum status, DisciplinaTipoFuncaoEnum tpFuncao);

    List<TarefaResponse> getListed(StatusEnum status, DisciplinaTipoFuncaoEnum tpFuncao);
}
