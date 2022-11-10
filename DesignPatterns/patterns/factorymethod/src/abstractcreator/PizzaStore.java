package abstractcreator;

import abstractproduct.Pizza;

public abstract class PizzaStore {
	
	public Pizza orderPizza(String type) {
		
		Pizza pizza;
		
		//pizza = factory.createPizza(type);
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
		
	}
	
	//Factory method
	protected abstract Pizza createPizza(String item);

}
