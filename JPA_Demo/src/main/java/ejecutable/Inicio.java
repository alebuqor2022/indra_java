package ejecutable;

import java.util.List;

import dao.DaoCiudad;
import dao.DaoEmpleado;
import dao.DaoPais;
import dao.DaoPersona;
import model.Ciudad;
import model.Empleado;
import model.Pais;
import model.Persona;

public class Inicio {

	public static void main(String[] args) {
		testPersona();
		testEmpleado();
		testPaisCdad();
	}

	public static void testPersona() {
		Persona p = DaoPersona.find(3L);
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

	public static void testEmpleado() {
		Empleado e = DaoEmpleado.find(2L);
		System.out.println("---- EMPLEADO de base de datos -----------");
		System.out.println(e.getUsuario());
		System.out.println(e.getPerson().getNombre());

	}

	public static void testPaisCdad() {
		Pais p=DaoPais.find(2L);
		System.out.println("---- PAIS de base de datos -----------");
		System.out.println(p);
		System.out.println(p.getNombre());
		
		System.out.println("---- CIUDADES -------");
		List<Ciudad> ciudades=DaoCiudad.findAllCiudades(2);
		for(int i =0; i<ciudades.size();i++) {
			System.out.println(ciudades.get(i));
		}
		
	}
}
