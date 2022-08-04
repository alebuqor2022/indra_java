package com.indra.spring.beans;

import org.springframework.stereotype.Component;

import com.indra.spring.interfaces.IEquipo;

@Component("equipo")
public class Barcelona implements IEquipo {
String nombre;
	@Override
	public String mostrar() {
		return "Barcelona Team";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
