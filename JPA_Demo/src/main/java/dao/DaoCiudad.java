package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Ciudad;
import utils.JpaUtils;

public class DaoCiudad {
	public static List<Ciudad> findAllCiudades(int fk){
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Query cdades=em.createNativeQuery("SELECT nombre FROM indra2022.ciudades where fk_pais=" + fk);
		List<Ciudad>ciudades=cdades.getResultList();
		return ciudades;
	}
	
	public static Ciudad find(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Ciudad empleado=null;
		try {
			empleado=em.find(Ciudad.class, id);
		}catch(Exception ex) {
			System.out.println("ups !!! ocurrio un error buscando al Ciudad");
			ex.printStackTrace();
		}
		
		return empleado;
	}
	
	public static void create(Ciudad ciudad) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin(); // es como abrir un canal de comunicacion con la BD
		try {
			em.persist(ciudad); // esta haciendo un INSERT
			em.getTransaction().commit();			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("ups !!! ocurrio un error creando al Ciudad");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void update(Ciudad ciudad) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			em.merge(ciudad);// esta haciendo un UPDATE
			tx.commit();
			System.out.println("actualizacion exitosa!!");
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("ups !!! ocurrio un error actualizando al Ciudad");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void delete(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin();
		try {
			Ciudad p=DaoCiudad.find(id);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Ciudad borrada!!");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
}
