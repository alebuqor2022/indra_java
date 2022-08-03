package com.indra.spring.beans;

import java.util.List;

public class Pais {
private String nombre;
private Ciudad miciudad;
private List<Ciudad> ciudades;


public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Ciudad getMiciudad() {
	return miciudad;
}

public void setMiciudad(Ciudad miciudad) {
	this.miciudad = miciudad;
}

public List<Ciudad> getCiudades() {
	return ciudades;
}

public void setCiudades(List<Ciudad> ciudades) {
	this.ciudades = ciudades;
}

}
