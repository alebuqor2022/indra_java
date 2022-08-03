package com.indra.spring.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.spring.beans.AppConfig;
import com.indra.spring.beans.Ciudad;
import com.indra.spring.beans.HolaMundo;
import com.indra.spring.beans.Person;
import com.indra.spring.beans.Persona;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args ) {
		ApplicationContext appContext=
	    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans.xml");
	    	
	    	Persona p=(Persona)appContext.getBean("persona"); // por id
	    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
	    	System.out.println(p.getMipais().getNombre());
	    	System.out.println(p.getMipais().getMiciudad().getNombre());

	
	((ConfigurableApplicationContext)appContext).close();
}
	
	public static void main9(String[] args ) {
		ApplicationContext appContext=
	    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans7.xml");
	    	
	    	Persona p=(Persona)appContext.getBean("persona"); // por id
	    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
	    	System.out.println(p.getMipais().getNombre());
	    	System.out.println(p.getMipais().getMiciudad().getNombre());

	
	((ConfigurableApplicationContext)appContext).close();
}
	
	public static void main8( String[] args ) {
		ApplicationContext appContext=
	    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans6.xml");
	    	
	    	Person p=(Person)appContext.getBean("person"); // por id
	    	Person p1=(Person)appContext.getBean("person"); // por id
	    	System.out.println(p);
	    	System.out.println(p1);
	    	
	    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
	    	System.out.println(p.getCountry().getNombre());
	    	
	    	System.out.println(p1.getId()+", "+ p1.getNombre() + ", " + p1.getApodo());
	    	System.out.println(p1.getCountry().getNombre());
	
	((ConfigurableApplicationContext)appContext).close();
}
	
	public static void main7( String[] args ) {
		ApplicationContext appContext=
	    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans5.xml");
	    	
	    	Person p=(Person)appContext.getBean("person"); // por id
	    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
	    	System.out.println(p.getCountry().getNombre());
	
	((ConfigurableApplicationContext)appContext).close();
}
	
	public static void main6( String[] args ) {
		// distintas formas de referenciar un Bean
		ApplicationContext appContext=
		    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans4.xml");
		    	
		    	Persona p=(Persona)appContext.getBean("persona"); // por id
		        String nombreCiudades="";
		        for(Ciudad ciu: p.getMipais().getCiudades()) {
		        	nombreCiudades += ciu.getNombre() + ", ";
		        }
		    	
		    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
		    	System.out.println(p.getMipais().getNombre());
		    	System.out.println(nombreCiudades);

		
		((ConfigurableApplicationContext)appContext).close();
	}
	
	public static void main5( String[] args ) {
		// distintas formas de referenciar un Bean
		ApplicationContext appContext=
		    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans3.xml");
		    	
		    	Persona p=(Persona)appContext.getBean("persona"); // por id
		    	Persona p1=(Persona)appContext.getBean(Persona.class); // por clase
		    	Persona p2=(Persona)appContext.getBean("personaAlias"); // por alias
		    	Persona p3=(Persona)appContext.getBean("personaName"); // por name
		    	
		    	System.out.println(p3.getId()+", "+ p3.getNombre() + ", " + p3.getApodo());
		    	System.out.println(p3.getMipais().getNombre()+", "+p3.getMipais().getMiciudad().getNombre());

		
		((ConfigurableApplicationContext)appContext).close();
	}
	
	public static void main4( String[] args ) {
			ApplicationContext appContext=
		    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans2.xml");
		    	
		    	Persona p=(Persona)appContext.getBean("persona2"); // por id
		    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
		    	System.out.println(p.getMipais().getNombre()+", "+p.getMipais().getMiciudad().getNombre());

		
		((ConfigurableApplicationContext)appContext).close();
	}
	
	public static void main3( String[] args ) {
		ApplicationContext appContext=
		    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans1.xml");
		    	
		    	Persona p=(Persona)appContext.getBean("persona"); // por id
		    	System.out.println(p.getId()+", "+ p.getNombre() + ", " + p.getApodo());
		    	
		    	Persona p1=(Persona)appContext.getBean("persona1"); // por id
		    	System.out.println(p1.getId()+", "+ p1.getNombre() + ", " + p1.getApodo());
		
		((ConfigurableApplicationContext)appContext).close();
	}
	
    public static void main2( String[] args )
    {
    	ApplicationContext appContext=
    			new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	HolaMundo hola=(HolaMundo)appContext.getBean("mundo"); // id, en este caso es el metodo declarado en el AppConfig
    	System.out.println(hola.getSaludo());
    	
    	HolaMundo hola2=(HolaMundo)appContext.getBean("marte");
    	System.out.println(hola2.getSaludo());
    	
    	((ConfigurableApplicationContext)appContext).close();
    }
    
    public static void main1( String[] args ) {
// System.out.println( "Hello World!" );    	
    	ApplicationContext appContext=
    			new ClassPathXmlApplicationContext("com/indra/spring/xmls/beans1.xml");
    	
    	HolaMundo hola=(HolaMundo)appContext.getBean(HolaMundo.class);
    	//hola.setSaludo("hola Gente"); // uso el value del beans.xml seteado en la property
    	System.out.println(hola.getSaludo());
    	
    	HolaMundo hola2=(HolaMundo)appContext.getBean("mundo");  // el id declarado en el beans.xml
    	System.out.println(hola2.getSaludo());
    }
}
