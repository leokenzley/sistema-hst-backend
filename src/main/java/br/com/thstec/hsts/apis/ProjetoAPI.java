package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.projeto.request.ProjetoRequest;
import br.com.thstec.hsts.model.projeto.response.ProjetoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API de Projetos")
@RequestMapping("/v1/projetos")
public interface ProjetoAPI {

    @Operation(summary = "Criar projeto")
    @PostMapping
    ResponseEntity<ProjetoResponse> created(@RequestBody ProjetoRequest request);

    @Operation(summary = "Atualizar projeto")
    @PutMapping("/{id}")
    ResponseEntity<ProjetoResponse> update(@PathVariable Long id,
                                           @RequestBody ProjetoRequest request);

    @Operation(summary = "Excluir projeto (delete lógico)")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);

    @Operation(summary = "Buscar projeto por ID")
    @GetMapping("/{id}")
    ResponseEntity<ProjetoResponse> findById(@PathVariable Long id);

    @Operation(summary = "Listar projetos ativos paginados")
    @GetMapping
    ResponseEntity<Page<ProjetoResponse>> getPaginated(Pageable pageable);
}
