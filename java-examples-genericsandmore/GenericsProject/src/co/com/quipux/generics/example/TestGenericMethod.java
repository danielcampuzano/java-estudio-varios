package co.com.quipux.generics.example;

public class TestGenericMethod {
	// A Generic method example
	static <T> void genericDisplay(T element) {
		System.out.println(element.getClass().getName() + 
                " = " + element); 
	}
	
	// Generic method printArray
	static <T> void genericPrintArray(T[] inputArray) {
		for(T element : inputArray) {
			System.out.println(element);
		}
	}
	
	public static void main(String[] args) {
		
        // Calling generic method with Integer argument 
       genericDisplay(11); 
  
       // Calling generic method with String argument 
       genericDisplay("GeeksForGeeks"); 
  
       // Calling generic method with double argument 
       genericDisplay(1.0); 
       
       //************************************************
       Integer[] intArray = {4, 8, 15, 18, 1, 5};
       String[] stringArray = {"hola", "hello", "Olá"};
       Double[] doubleArray = {2.0, 5.3, 8.4, 1.3, 9.4};
       
       genericPrintArray(intArray);
       genericPrintArray(doubleArray);
       genericPrintArray(stringArray);
       
	}
}
