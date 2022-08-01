package com.indra.fundamentosjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		//ejemplo1();
		ejemplo2();
	}
	
	public static void ejemplo1() {
		Stream.iterate(0, n-> n+10).limit(15).forEach(Stream_examples::imp);
	}
	
	public static void ejemplo2() {
		//uno
		List<Integer> li=Arrays.asList(5,7,10,25,74);
		int suma=li.stream()
				.mapToInt(x->x.intValue())
				.sum();
		System.out.println("Suma de la lista= "+ suma);
		//dos
		long pares=li.stream()
				   .filter(x->x%2 == 0)
				   .count();
		System.out.println("Cantidad de nros pares= "+ pares);
		//tres
		Object[] arrInt=Stream.of(23,45,67,88,2,27)
				        .filter(x->x%2 == 0)
				        .toArray();
		for(Object elemento: arrInt) {
			System.out.println("Nros pares " + elemento);
		}
	}

}
