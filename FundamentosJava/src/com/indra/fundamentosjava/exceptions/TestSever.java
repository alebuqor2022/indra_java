package com.indra.fundamentosjava.exceptions;

public class TestSever {

	public static void main(String[] args) {
		
		Conexion con=new Conexion();
		
		try {
			con.conectar("Tomcat");
			System.out.println("EXITO, me conecte");
		} catch (ServerTimeOutException e) {
			e.printStackTrace();
			System.out.println("desde el try/catch" + e.getMessage());
			
		}

	}

}
