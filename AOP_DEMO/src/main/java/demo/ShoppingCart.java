package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	public int quantity() {
		return 2;
	}
	
	public void checkout2(String status) {
		System.out.println("estoy en el checkout2 del Carro");
	}
	public void checkout() {
		System.out.println("estoy en el checkout del Carro");
	}
}
