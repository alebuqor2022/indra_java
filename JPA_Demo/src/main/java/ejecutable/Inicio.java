package ejecutable;

import dao.DaoPersona;
import model.Persona;

public class Inicio {

	public static void main(String[] args) {
		Persona p=DaoPersona.find(3L);
		System.out.println("---- PERSONA de base de datos -----------");
		System.out.println(p);
		System.out.println(p.getNombre());
		
		p.setNombre("Marcela"); 
		p.setApellido("Garcia");
		
		DaoPersona.update(p);
		System.out.println("---- PERSONA MODIFICADA de base de datos -----------");
		System.out.println(p);
		System.out.println(p.getNombre());

	}

}
