package co.com.refelections.learning;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		// Creating object whose property is to be checked 
        Test obj = new Test();
        
        // Creating class object from the object using 
        // getclass method 
        Class cls = obj.getClass();
        System.out.println("The name of class is " + 
                            cls.getName());
        
        // Getting the constructor of the class through the 
        // object of the class 
        Constructor cons = obj.getClass().getConstructor();
        System.out.println("The constructor is " + cons.getName());
        
        System.out.println("The public methods of class are : "); 
        
        // Getting methods of the class through the object 
        // of the class by using getMethods 
        Method[] methods = obj.getClass().getMethods();
        
        for(Method method : methods) {
        	System.out.println(method.getName());
        }
        
        //Invoke methods
        Method method1 = obj.getClass().getMethod("printNumber", int.class);
        method1.invoke(obj, 9);
        
	}
	
}
