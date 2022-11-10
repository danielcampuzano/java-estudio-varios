package concretecreators;

import abstractcreator.PizzaStore;
import abstractproduct.Pizza;
import concreteproducts.NYStyleCheesePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String item) {

		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else {
			return null;
		}

	}

}
