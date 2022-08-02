package com.indra.spring.beans;

import org.springframework.beans.factory.annotation.Value;

public class HolaMundo {
	
@Value("hola gente madrugadora de Indra")
String saludo;

public String getSaludo() {
	return saludo;
}

public void setSaludo(String saludo) {
	this.saludo = saludo;
}

}
