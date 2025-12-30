package br.com.thstec.hsts.services;

import br.com.thstec.hsts.model.disciplina.request.DisciplinaRequest;
import br.com.thstec.hsts.model.disciplina.response.DisciplinaResponse;
import br.com.thstec.hsts.model.enumerations.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DisciplinaService {

    DisciplinaResponse created(DisciplinaRequest request);

    DisciplinaResponse update(Long id, DisciplinaRequest request);

    void deleteById(Long id);

    DisciplinaResponse findById(Long id);

    Page<DisciplinaResponse> getPaginated(StatusEnum status, Pageable pageable);
}

