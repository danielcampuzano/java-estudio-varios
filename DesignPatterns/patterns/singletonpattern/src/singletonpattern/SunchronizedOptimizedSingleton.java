package singletonpattern;

public class SunchronizedOptimizedSingleton {

	
	//The volatile keyword ensures that multiple threads handle the uniqueInstance variable correctly when it 
	//is being initialized to the Singleton instance.
	private volatile static SunchronizedOptimizedSingleton uniqueInstance;

	private SunchronizedOptimizedSingleton() {
	}

	public static SunchronizedOptimizedSingleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (SunchronizedOptimizedSingleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SunchronizedOptimizedSingleton();
				}
			}
		}
		return uniqueInstance;
	}

}
