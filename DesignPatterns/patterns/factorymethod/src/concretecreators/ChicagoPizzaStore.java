package concretecreators;

import abstractcreator.PizzaStore;
import abstractproduct.Pizza;
import concreteproducts.ChicagoStyleCheesePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String item) {
		
		if(item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else {
			return null;
		}
		
	}

}
