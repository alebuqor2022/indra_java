package com.indra.fundamentosjava.exceptions;

public class Conexion {

	public void conectar(String nombreServer) throws ServerTimeOutException{
		boolean exito;
		int puertoAconectar=80;
		
		exito=abrir(nombreServer,puertoAconectar);
		
		if (!exito) {
			throw new ServerTimeOutException("No me puedo conectar al puerto ",puertoAconectar);
		}
	}
	
	public boolean abrir(String nombreServer, int puertoAConectar) {
			System.out.println("Estoy en el metodo abrir");
		return false;
	}
	
}
