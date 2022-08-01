package com.indra.fundamentosjava.lambdas;

import java.util.*;
import java.util.function.Consumer;

public class TestLambas {

	public static void main(String[] args) {
		ejemplo1();
		System.out.println("**********************");
		ejemplo2();
		System.out.println("**********************");
		ejemplo3();

	}
	
	public static void ejemplo1() {
		Pais pais1=new Pais("Argentina");
		Pais pais2=new Pais("España");
		Pais pais3=new Pais("Inglaterra");
		Pais pais4=new Pais("Brasil");
		Pais pais5=new Pais("Francia");
		
		List<Pais> paises= new ArrayList<Pais>();
		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		paises.add(pais4);
		paises.add(pais5);
		
		paises.forEach((p) -> {System.out.println(p.nombre);});
		
	}

	public static void sinLambdasSort(List<Pais> list) {
		// ordenar sin lambdas
		Collections.sort(list, new Comparator<Pais>() {
			@Override
			public int compare(Pais p1, Pais p2) {
				return p1.nombre.compareTo(p2.nombre);
			}
		});
		
	}
	
	public static void lambdasSort(List<Pais> list) {
		Collections.sort(list, 
				(p1,p2) -> {return  p1.nombre.compareTo(p2.nombre);}
				);
	
	}
	 
	public static void ejemplo2() {
		Pais pais1=new Pais("Argentina");
		Pais pais2=new Pais("España");
		Pais pais3=new Pais("Inglaterra");
		Pais pais4=new Pais("Brasil");
		Pais pais5=new Pais("Francia");
		
		List<Pais> paises= new ArrayList<Pais>();
		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		paises.add(pais4);
		paises.add(pais5);
		
		sinLambdasSort(paises);
		paises.forEach((p) -> {System.out.println(p.nombre);});
		
		lambdasSort(paises);
		paises.forEach((p) -> {System.out.println(p.nombre);});
	}

	public static void ejemplo3() {
		// usar la interfaz de Java Consumer para almacenar 
		// una expresion lambda en una variable
		
		ArrayList<Integer> nros=new ArrayList<Integer>();
		nros.add(5);
		nros.add(9);
		nros.add(8);
		nros.add(1);
		
		Consumer<Integer> valor=(n) -> {System.out.println(n);};
		nros.forEach(valor);
		System.out.println("**********************");
		nros.forEach((n) -> {System.out.println(n);});
		System.out.println("**********************");
		Arrays.asList(1,2,3,4,5,6,7,8,9,10).forEach(System.out::println);
		
	}
}
 