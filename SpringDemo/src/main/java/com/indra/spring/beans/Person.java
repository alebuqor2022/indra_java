package com.indra.spring.beans;

public class Person {
	private int id;
	private String nombre;
	private String apodo;
	private Country country;
	
	public Person() {}
	public Person(int id, String nombre, String apodo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
	}
		
	public Person(Country country) {
		this.country = country;
	}
	public Person(int id) {
		super();
		this.id = id;
	}


	public Person(String apodo) {
		super();
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
