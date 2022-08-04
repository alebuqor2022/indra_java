package com.indra.spring.beans;

import java.util.List;

public class Pais2 {
private String nombre;
private Ciudad2 miciudad;
private List<Ciudad2> ciudades;


public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Ciudad2 getMiciudad() {
	return miciudad;
}

public void setMiciudad(Ciudad2 miciudad) {
	this.miciudad = miciudad;
}

public List<Ciudad2> getCiudades() {
	return ciudades;
}

public void setCiudades(List<Ciudad2> ciudades) {
	this.ciudades = ciudades;
}

}
