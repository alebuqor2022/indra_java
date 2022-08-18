package com.indra.abm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.abm.model.Persona;
import com.indra.abm.repository.PersonaRepositorio;

@Service
public class PersonaServiceImpl implements PersonaService{
@Autowired
private PersonaRepositorio repositorio;

@Override
public List<Persona> listar() {
	return repositorio.findAll();
}

@Override
public Persona listarId(int id) {
	return repositorio.findById(id);
}

@Override
public Persona add(Persona p) {
	return repositorio.save(p);
}

@Override
public Persona edit(Persona p) {
	return repositorio.save(p);
}

@Override
public void delete(int id) {
	Persona p= repositorio.findById(id);
	if(p!=null) {
		repositorio.delete(p);
	}
	
}


}
