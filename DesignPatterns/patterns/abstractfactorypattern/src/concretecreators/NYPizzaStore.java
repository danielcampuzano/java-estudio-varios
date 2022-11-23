package concretecreators;

import abstractcreator.PizzaStore;
import abstractfactory.factory.NYPizzaIngredientFactory;
import abstractfactory.factory.PizzaIngredientFactory;
import abstractproduct.Pizza;
import concreteproducts.CheesePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String item) {

		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");

		}
		return pizza;

	}

}
