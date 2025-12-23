package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.sprint.request.SprintRequest;
import br.com.thstec.hsts.model.sprint.response.SprintResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SprintService {

    SprintResponse create(SprintRequest request);

    SprintResponse update(Long id, SprintRequest request);

    void deleteById(Long id);

    SprintResponse findById(Long id);

    Page<SprintResponse> getByProjectPaginated(Long projectId, Pageable pageable);

    List<SprintResponse> getByProjetoList(Long projetoId);
}
