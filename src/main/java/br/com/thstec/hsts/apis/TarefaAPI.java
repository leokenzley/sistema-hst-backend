package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.enumerations.DisciplinaTipoFuncaoEnum;
import br.com.thstec.hsts.model.tarefa.request.TarefaRequest;
import br.com.thstec.hsts.model.tarefa.response.TarefaResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "API Tarefas")
@RequestMapping("/v1/tarefas")
public interface TarefaAPI {
    @PostMapping
    TarefaResponse created(@RequestBody TarefaRequest request);

    @PutMapping("/{id}")
    TarefaResponse update(
            @PathVariable Long id,
            @RequestBody TarefaRequest request
    );

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @GetMapping("/{id}")
    TarefaResponse findById(@PathVariable Long id);

    @GetMapping
    Page<TarefaResponse> getPaginated(
            Pageable pageable,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "tpFuncao", required = false) DisciplinaTipoFuncaoEnum tpFuncao);

    @GetMapping("/list")
    List<TarefaResponse> getListed(
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "tpFuncao", required = false) DisciplinaTipoFuncaoEnum tpFuncao
            );

}
