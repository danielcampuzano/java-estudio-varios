package client;

import abstractcomponent.Beverage;
import concretecomponent.Espresso;
import concretecomponent.HouseBlend;
import concretedecorators.Mocha;
import concretedecorators.Soy;

public class StarbuzzCoffee {
	
	
	public static void main(String[] args) {
		
		//Order an espresso with no condiments
		Beverage beverage = new Espresso();
		System.out.println( beverage.getDescription() + " $" + beverage.cost() );
		
		//House blend with Soy and Mocha
		Beverage beverage2 = new HouseBlend();
		beverage2 = new Soy(beverage2);
		beverage2 = new Mocha(beverage2);
		System.out.println( beverage2.getDescription() + " $" + beverage2.cost() );
		
	}

}
