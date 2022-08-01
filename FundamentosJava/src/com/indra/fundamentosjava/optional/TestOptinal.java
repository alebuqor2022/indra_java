package com.indra.fundamentosjava.optional;

import java.util.*;
import java.util.stream.Stream;

public class TestOptinal {

	public static void main(String[] args) {
		//ejemplo1();
		//ejemplo2();
		//ejemplo3();
		ejemplo4();

	}

	public static void ejemplo1() {
		// sin Optional
		List<Nota> notas=new ArrayList<Nota>();
		notas.add(new Nota("matematicas", 3));
		//notas.add(new Nota("lengua", 10));
		notas.add(new Nota("ingles", 5));
		notas.add(new Nota("fisica", 7));
		
		Nota nota=buscarNotaSobresaliente(notas);
		System.out.println("ejemplo1: " + nota.getValor() + " en " + nota.getAsignatura());
	}
	
	public static Nota buscarNotaSobresaliente(List<Nota> notas) {
		Nota nota=null;
		for (Nota unaNota: notas) {
			if(unaNota.getValor()>=9) {
				nota=unaNota;
			}
		}		
		return nota;
	}
	public static void ejemplo2() {
		// sin Optional
		 // no da error al no tener una nota con 10
		  // pero tampoco imprime nada
		List<Nota> notas=new ArrayList<Nota>();
		notas.add(new Nota("matematicas", 3));
		//notas.add(new Nota("lengua", 10));
		notas.add(new Nota("ingles", 5));
		notas.add(new Nota("fisica", 7));
		
		Nota nota=buscarNotaSobresaliente(notas);
		// lo solucionamos de forma simple
		if(nota!=null) {
			System.out.println("ejemplo2: " + nota.getValor() + " en " + nota.getAsignatura());
		}
	}

	public static void ejemplo3() {
		// usamos OPTIONAL
		List<Nota> notas=new ArrayList<Nota>();
		notas.add(new Nota("matematicas", 3));
		//notas.add(new Nota("lengua", 10));
		notas.add(new Nota("ingles", 5));
		notas.add(new Nota("fisica", 7));
		
		Optional<Nota> oNota=buscarNotaSobresaliente1(notas);
		if(oNota.isPresent()) {
			Nota nota=oNota.get();
			System.out.println("ejemplo3: " + nota.getValor() + " en " + nota.getAsignatura());
		}
		
	}
	
	public static Optional<Nota> buscarNotaSobresaliente1(List<Nota> notas){
		for (Nota unaNota: notas) {
			if (unaNota.getValor()>=9) {
				return Optional.of(unaNota);
			}
		}
		
		return Optional.empty();
	}

	public static void ejemplo4() {
		List<String> qList=Arrays.asList("Arriba", "Quilmes");
		Stream<String> qStream=qList.stream();
		
		List<String> cerveceros=Arrays.asList("Arriba", "Cerveceros");
		
		Optional<String> conQ=qStream.filter(s-> s.startsWith("Q")).findFirst();
		System.out.println(qList.stream().reduce("", String::concat)+" tiene una Q " +conQ);
		
		Optional<String> conQ1=cerveceros.stream().filter(s-> s.startsWith("Q")).findFirst();
		System.out.println(cerveceros.stream().reduce("", String::concat)+" tiene una Q " +conQ1);

		
	}
}
