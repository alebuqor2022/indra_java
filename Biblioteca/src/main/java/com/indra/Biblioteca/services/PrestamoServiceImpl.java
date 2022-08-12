package com.indra.Biblioteca.services;


import com.indra.Biblioteca.model.Libro;
import com.indra.Biblioteca.model.Prestamo;
import com.indra.Biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public void savePrestamo(Prestamo prestamo) {
        this.prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo getPrestamoById(long id) {
        Optional<Prestamo> optionalPrestamo = prestamoRepository.findById(id);
        Prestamo prestamo = null;
        if (optionalPrestamo.isPresent()) {
            prestamo = optionalPrestamo.get();
        } else {
            throw new RuntimeException("Prestamo not found for id : " + id);
        }
        return prestamo;
    }

    @Override
    public void deletePrestamoById(long id) {
        this.prestamoRepository.deleteById(id);
    }

    @Override
    public Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return this.prestamoRepository.findAll(pageable);
    }
}
