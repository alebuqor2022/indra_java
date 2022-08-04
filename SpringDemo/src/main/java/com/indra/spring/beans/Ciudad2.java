package com.indra.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Ciudad2 implements InitializingBean, DisposableBean{
private String nombre;


public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public void destroy() throws Exception {
	System.out.println("estoy en el destroy de Ciudad2");
	
}

@Override
public void afterPropertiesSet() throws Exception {
	System.out.println("estoy en el init de Ciudad2");
	
}


}
