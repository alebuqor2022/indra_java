package com.indra.spring.beans;

public class Persona {
private int id;
private String nombre;
private String apodo;
private Pais mipais;

public Persona() {}

public Persona(int id, String nombre, String apodo) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apodo = apodo;
}

public Persona(int id) {
	this.id = id;
}
public Persona(String apodo) {
	this.apodo = apodo;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApodo() {
	return apodo;
}

public void setApodo(String apodo) {
	this.apodo = apodo;
}

public Pais getMipais() {
	return mipais;
}

public void setMipais(Pais mipais) {
	this.mipais = mipais;
}
}
