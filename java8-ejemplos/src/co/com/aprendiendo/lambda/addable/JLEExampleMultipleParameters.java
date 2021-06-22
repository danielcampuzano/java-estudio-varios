package co.com.aprendiendo.lambda.addable;

/**
 * In Java lambda expression, if there is only one statement, you may or may 
 * not use return keyword. You must use return keyword when lambda expression 
 * contains multiple statements.
 * @author RAMESH
 *
 */
public class JLEExampleMultipleParameters {
	public static void main(String[] args) {
		Addable addableWithLambda = (a, b) -> (a+b);
		System.out.println(addableWithLambda.add(5, 15));
		
		Addable addableWithReturn = (a, b) -> {
			return a + b;
		};
		System.out.println(addableWithReturn.add(5, 18));
	}
}
