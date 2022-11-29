package singletonpattern;

public class ClassicSingleton {

	private static ClassicSingleton uniqueInstance;

	// other useful instance variables here
	private ClassicSingleton() {
	}

	public static ClassicSingleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ClassicSingleton();
		}
		return uniqueInstance;
	}
	// other useful methods here

}
