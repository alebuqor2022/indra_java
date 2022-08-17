package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		 ApplicationContext context=
				 new AnnotationConfigApplicationContext(BeanConfig.class);
		 
		 ShoppingCart cart=context.getBean(ShoppingCart.class);
		// cart.checkout();
		 cart.checkout2("cancel");
		 System.out.println(cart.quantity());
		 System.out.println("fin");
		 ((ConfigurableApplicationContext)context).close();
	}

}
