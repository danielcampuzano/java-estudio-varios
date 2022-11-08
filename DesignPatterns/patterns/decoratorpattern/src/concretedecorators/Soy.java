package concretedecorators;

import abstractcomponent.Beverage;
import abstractdecorator.CondimentDecorator;

public class Soy extends CondimentDecorator {
	
	//The beverage we are wrapping
	Beverage beverage;
	

	public Soy(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return 0.35 + beverage.cost();
	}

}
