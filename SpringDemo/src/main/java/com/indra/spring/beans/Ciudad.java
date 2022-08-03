package com.indra.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Ciudad {
private String nombre;

@PostConstruct
private void init() {
	System.out.println("Antes de iniciar el bean");
}
@PreDestroy
private void destroy() {
	System.out.println("Apunto de destruir el bean");
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}


}
