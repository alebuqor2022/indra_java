package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Pais;
import utils.JpaUtils;

public class DaoPais {
	public static Pais find(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Pais empleado=null;
		try {
			empleado=em.find(Pais.class, id);
		}catch(Exception ex) {
			System.out.println("ups !!! ocurrio un error buscando al Pais");
			ex.printStackTrace();
		}
		
		return empleado;
	}
	
	public static void create(Pais pais) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin(); // es como abrir un canal de comunicacion con la BD
		try {
			em.persist(pais); // esta haciendo un INSERT
			em.getTransaction().commit();			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("ups !!! ocurrio un error creando al Pais");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void update(Pais pais) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			em.merge(pais);// esta haciendo un UPDATE
			tx.commit();
			System.out.println("actualizacion exitosa!!");
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("ups !!! ocurrio un error actualizando al Pais");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void delete(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin();
		try {
			Pais p=DaoPais.find(id);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Pais borrado!!");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
}
