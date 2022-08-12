package com.indra.Biblioteca.services;

import com.indra.Biblioteca.model.Lector;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LectorService {
    List<Lector> getAllLectores();

    void saveLector(Lector lector);

    Lector getLectorById(long id);

    void deleteLectorById(long id);

    Page<Lector> findPaginated(int pageNum, int pageSize,
                              String sortField,
                              String sortDirection);
}
