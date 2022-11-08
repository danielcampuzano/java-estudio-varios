package abstractdecorator;

import abstractcomponent.Beverage;

public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}
