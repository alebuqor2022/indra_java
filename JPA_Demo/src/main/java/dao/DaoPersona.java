package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Persona;
import utils.JpaUtils;

public class DaoPersona {

	public static Persona find(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Persona persona=null;
		try {
			persona=em.find(Persona.class, id);
		}catch(Exception ex) {
			System.out.println("ups !!! ocurrio un error buscando a la persona");
			ex.printStackTrace();
		}
		
		return persona;
	}
	
	public static void create(Persona persona) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin(); // es como abrir un canal de comunicacion con la BD
		try {
			em.persist(persona); // esta haciendo un INSERT
			em.getTransaction().commit();			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("ups !!! ocurrio un error creando a la persona");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void update(Persona persona) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			em.merge(persona);// esta haciendo un UPDATE
			tx.commit();
			System.out.println("actualizacion exitosa!!");
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("ups !!! ocurrio un error actualizando a la persona");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void delete(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin();
		try {
			Persona p=DaoPersona.find(id);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("persona borrada!!");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
}
