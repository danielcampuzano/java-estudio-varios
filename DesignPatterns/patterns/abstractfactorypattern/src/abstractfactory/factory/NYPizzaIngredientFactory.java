package abstractfactory.factory;

import abstractfactory.abstractproduct.Cheese;
import abstractfactory.abstractproduct.Clams;
import abstractfactory.abstractproduct.Dough;
import abstractfactory.abstractproduct.Sauce;
import abstractfactory.concreteproducts.cheese.RaggianoCheese;
import abstractfactory.concreteproducts.clams.FreshClams;
import abstractfactory.concreteproducts.dough.ThinCrustDough;
import abstractfactory.concreteproducts.sauce.MarinaraSauce;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new RaggianoCheese();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
