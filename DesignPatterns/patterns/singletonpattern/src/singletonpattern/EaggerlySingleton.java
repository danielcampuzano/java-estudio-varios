package singletonpattern;

public class EaggerlySingleton {

	private static EaggerlySingleton uniqueInstance = new EaggerlySingleton();

	private EaggerlySingleton() {
	}

	public static EaggerlySingleton getInstance() {
		return uniqueInstance;
	}

}
