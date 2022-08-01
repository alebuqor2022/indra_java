package com.indra.fundamentosjava.exceptions;

public class ServerTimeOutException extends Exception{
private int puerto;
	
	public ServerTimeOutException(String mensaje, int puerto) {
		super(mensaje);
		this.puerto=puerto;
	}
	
	public int getPuerto() {
	return puerto;
}
}
