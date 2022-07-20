package client;

import context.Duck;
import context.MallardDuck;
import context.ModelDuck;
import flystrategies.FlyRocketPowered;

public class MiniDuckSimulator {
	
	public static void main(String[] args) {
		
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		
	}

}
