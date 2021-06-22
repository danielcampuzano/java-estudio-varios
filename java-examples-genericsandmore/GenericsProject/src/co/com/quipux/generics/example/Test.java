package co.com.quipux.generics.example;

public class Test<T> {
	// An object of type T is declared
	T obj;
	
	//Constructor
	Test(T obj) {
		this.obj = obj;
	}
	
	public T getObject() {
		return this.obj;
	}
	
	
	//PRUEBAS
	
	public static void main(String[] args) {
		Test<Integer> testInt = new Test<Integer>(15);
		System.out.println(testInt.getObject());
		
		Test<String> testString = new Test<String>("Welcome to Globant Daniel");
		System.out.println(testString.getObject());
	}
	
}
