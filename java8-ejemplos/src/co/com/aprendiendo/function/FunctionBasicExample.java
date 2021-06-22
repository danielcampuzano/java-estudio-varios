package co.com.aprendiendo.function;

import java.util.function.Function;

public class FunctionBasicExample {

	public static void main(String[] args) {
		
		Function<Integer, Double> half = number -> number / 2.0;
		
		Double result = half.apply(7);
		
		System.out.println("The result is: " + result);
		
	}
	
}
