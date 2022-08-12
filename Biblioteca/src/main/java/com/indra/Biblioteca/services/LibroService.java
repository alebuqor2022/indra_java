package com.indra.Biblioteca.services;

import com.indra.Biblioteca.model.Libro;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LibroService {
    List<Libro> getAllLibros();

    void saveLibro(Libro libro);

    Libro getLibroById(long id);

    void deleteLibroById(long id);

    Page<Libro> findPaginated(int pageNum, int pageSize,
                              String sortField,
                              String sortDirection);
}
