package com.indra.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

public Persona(Pais mipais) {
	super();
	this.mipais = mipais;
}
@PostConstruct
private void init() {
	System.out.println("Antes de iniciar el Bean");
}
@PreDestroy
private void destroy() {
	System.out.println("Apunto de destruir el Bean");
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
