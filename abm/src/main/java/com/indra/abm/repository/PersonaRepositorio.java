package com.indra.abm.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.indra.abm.model.Persona;

public interface PersonaRepositorio extends Repository<Persona, Integer>{
// esta interface dialoga hacia el motor de MySQL
// CRUD ... ABM
	List<Persona> findAll();
	Persona findById(int id);
	Persona save(Persona p);
	void delete(Persona p);
}
