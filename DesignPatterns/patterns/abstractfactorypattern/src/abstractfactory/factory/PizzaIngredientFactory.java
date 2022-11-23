package abstractfactory.factory;

import abstractfactory.abstractproduct.Cheese;
import abstractfactory.abstractproduct.Clams;
import abstractfactory.abstractproduct.Dough;
import abstractfactory.abstractproduct.Sauce;

public interface PizzaIngredientFactory {
	
	//For each ingredient we define a create method in our interface. 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Clams createClam();

}
