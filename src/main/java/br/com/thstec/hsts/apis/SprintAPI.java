package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.sprint.request.SprintRequest;
import br.com.thstec.hsts.model.sprint.response.SprintResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "API de Sprints")
@RequestMapping("/v1/sprints")
public interface SprintAPI {

    @PostMapping
    ResponseEntity<SprintResponse> create(@RequestBody SprintRequest request);

    @PutMapping("/{id}")
    ResponseEntity<SprintResponse> update(@PathVariable Long id,
                                          @RequestBody SprintRequest request);
    @GetMapping("/{id}")
    ResponseEntity<SprintResponse> findById(@PathVariable Long id);

    @GetMapping("/projeto/{projetoId}/paginated")
    ResponseEntity<Page<SprintResponse>> getByProjetoPaginated(@PathVariable("projetoId") Long projetoId, Pageable pageable);

    @GetMapping("/projeto/{projetoId}")
    ResponseEntity<List<SprintResponse>> getByProjetoList(@PathVariable("projetoId") Long projetoId);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
