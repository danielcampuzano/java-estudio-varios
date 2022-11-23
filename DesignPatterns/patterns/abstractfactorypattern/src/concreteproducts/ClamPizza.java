package concreteproducts;

import abstractfactory.factory.PizzaIngredientFactory;
import abstractproduct.Pizza;

public class ClamPizza extends Pizza {
	
	PizzaIngredientFactory ingredientFactory;
	
	

	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		super();
		this.ingredientFactory = ingredientFactory;
	}



	@Override
	public void prepare() {		
		System.out.println("Preparing" + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clams = ingredientFactory.createClam();
	}



}
