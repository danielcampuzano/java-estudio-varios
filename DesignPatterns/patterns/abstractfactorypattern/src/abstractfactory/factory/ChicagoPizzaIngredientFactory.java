package abstractfactory.factory;

import abstractfactory.abstractproduct.Cheese;
import abstractfactory.abstractproduct.Clams;
import abstractfactory.abstractproduct.Dough;
import abstractfactory.abstractproduct.Sauce;
import abstractfactory.concreteproducts.cheese.MozzarellaCheese;
import abstractfactory.concreteproducts.cheese.RaggianoCheese;
import abstractfactory.concreteproducts.clams.FreshClams;
import abstractfactory.concreteproducts.clams.FrozenClams;
import abstractfactory.concreteproducts.dough.ThickCrustDough;
import abstractfactory.concreteproducts.dough.ThinCrustDough;
import abstractfactory.concreteproducts.sauce.MarinaraSauce;
import abstractfactory.concreteproducts.sauce.PlumTomatoSauce;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}

}
