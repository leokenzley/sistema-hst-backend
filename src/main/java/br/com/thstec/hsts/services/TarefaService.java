package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TarefaService {

    TarefaResponse created(TarefaRequest request);

    TarefaResponse update(Long id, TarefaRequest request);

    void deleteById(Long id);

    TarefaResponse findById(Long id);

    Page<TarefaResponse> getPaginated(Pageable pageable);
}
