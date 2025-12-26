package br.com.thstec.hsts.apis;

import br.com.thstec.hsts.model.disciplina.request.DisciplinaRequest;
import br.com.thstec.hsts.model.disciplina.response.DisciplinaResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API de Disciplinas")
@RequestMapping("/v1/disciplinas")
public interface DisciplinaAPI {

    @PostMapping
    ResponseEntity<DisciplinaResponse> create(@RequestBody DisciplinaRequest request);

    @PutMapping("/{id}")
    ResponseEntity<DisciplinaResponse> update(
            @PathVariable Long id,
            @RequestBody DisciplinaRequest request
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<DisciplinaResponse> findById(@PathVariable Long id);

    @GetMapping("/paginated")
    ResponseEntity<Page<DisciplinaResponse>> getPaginated(Pageable pageable);
}
