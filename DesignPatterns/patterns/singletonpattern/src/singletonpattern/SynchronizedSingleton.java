package singletonpattern;

public class SynchronizedSingleton {

	private static SynchronizedSingleton uniqueInstance;

	// other useful instance variables here
	private SynchronizedSingleton() {
	}

	public static synchronized SynchronizedSingleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SynchronizedSingleton();
		}
		return uniqueInstance;
	}
	// other useful methods here

}
