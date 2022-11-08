package concretedecorators;

import abstractcomponent.Beverage;
import abstractdecorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	//The beverage we are wrapping
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return 0.20 + beverage.cost();
	}

}
