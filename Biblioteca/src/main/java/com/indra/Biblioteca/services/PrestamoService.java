package com.indra.Biblioteca.services;

import com.indra.Biblioteca.model.Prestamo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> getAllPrestamos();

    void savePrestamo(Prestamo prestamo);

    Prestamo getPrestamoById(long id);

    void deletePrestamoById(long id);

    Page<Prestamo> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
