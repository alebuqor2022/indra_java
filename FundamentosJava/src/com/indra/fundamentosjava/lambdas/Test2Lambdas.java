package com.indra.fundamentosjava.lambdas;

interface StringFunction{
	String run(String str);
}

public class Test2Lambdas {

	public static void main(String[] args) {
		StringFunction exclamar=(s)-> s + "!";
		StringFunction preguntar=(s)-> s + "?";
		printFormat("Hola", exclamar);
		printFormat("Chau", preguntar);

	}

	// metodo que tome la expresion lambda como parametro
	public static void printFormat(String str, StringFunction format) {
		String resultado=format.run(str);
		System.out.println(resultado);
	}
}
