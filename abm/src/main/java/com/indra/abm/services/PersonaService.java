package com.indra.abm.services;

import java.util.List;

import com.indra.abm.model.Persona;

public interface PersonaService {
// esta interface dialoga hacia el FrontEnd .... x ejemplo Angular
	List<Persona> listar();
	Persona listarId(int id);
	Persona add(Persona p);
	Persona edit(Persona p);
	void delete (int id);
}
