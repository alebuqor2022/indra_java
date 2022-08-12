package com.indra.Biblioteca.repository;

import com.indra.Biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
