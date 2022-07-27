package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Empleado;
import utils.JpaUtils;

public class DaoEmpleado {

	public static Empleado find(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Empleado empleado=null;
		try {
			empleado=em.find(Empleado.class, id);
		}catch(Exception ex) {
			System.out.println("ups !!! ocurrio un error buscando al Empleado");
			ex.printStackTrace();
		}
		
		return empleado;
	}
	
	public static void create(Empleado empleado) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin(); // es como abrir un canal de comunicacion con la BD
		try {
			em.persist(empleado); // esta haciendo un INSERT
			em.getTransaction().commit();			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("ups !!! ocurrio un error creando al Empleado");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void update(Empleado empleado) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			em.merge(empleado);// esta haciendo un UPDATE
			tx.commit();
			System.out.println("actualizacion exitosa!!");
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("ups !!! ocurrio un error actualizando al Empleado");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void delete(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin();
		try {
			Empleado p=DaoEmpleado.find(id);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Empleado borrada!!");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
}
