package abstractproduct;

import java.util.ArrayList;

import abstractfactory.abstractproduct.Cheese;
import abstractfactory.abstractproduct.Clams;
import abstractfactory.abstractproduct.Dough;
import abstractfactory.abstractproduct.Sauce;

public abstract class Pizza {

	public String name;
	public Dough dough;
	public Sauce sauce;
	public Cheese cheese;
	public Clams clams;
	public ArrayList toppings = new ArrayList();

	//We’ve now made the prepare method abstract. This is where we are going to collect the ingredients needed for the pizza, which of 
	//course will come from the ingredient factory.
	public abstract void prepare();
	
	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
