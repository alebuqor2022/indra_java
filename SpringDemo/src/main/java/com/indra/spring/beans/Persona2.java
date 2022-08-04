package com.indra.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Persona2 implements InitializingBean, DisposableBean{
private int id;
private String nombre;
private String apodo;
private Pais2 mipais;

public Persona2() {}
public Persona2(int id, String nombre, String apodo) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apodo = apodo;
}
public Persona2(int id) {
	this.id = id;
}
public Persona2(String apodo) {
	this.apodo = apodo;
}

public Persona2(Pais2 mipais) {
	super();
	this.mipais = mipais;
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

public Pais2 getMipais() {
	return mipais;
}

public void setMipais(Pais2 mipais) {
	this.mipais = mipais;
}
@Override
public void afterPropertiesSet() throws Exception {
	System.out.println("estoy en el init de Persona2");
	
}
@Override
public void destroy() throws Exception {
	System.out.println("estoy en el destroy de Persona2");
	
}
}
