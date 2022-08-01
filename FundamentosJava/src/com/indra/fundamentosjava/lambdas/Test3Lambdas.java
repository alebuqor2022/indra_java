package com.indra.fundamentosjava.lambdas;

interface Calc{
	Integer op(Integer a, Integer b);
}
public class Test3Lambdas {
	
	public static void main(String[] args) {
		System.out.println("operaciones con lambdas");
		Calc sum=(Integer x, Integer y) -> {return x+y;};
		Calc mult=(Integer x, Integer y) -> {return x*y;};
		Calc resta=(Integer x, Integer y) -> {return x-y;};
		System.out.println("suma: " + sum.op(6, 4));
		System.out.println("multiplicacion: " + mult.op(6, 4));
		System.out.println("resta: " + resta.op(6, 4));

	}

}
