package co.com.refelections.learning;

public class Test {

    // creating a private field 
    private String text; 
  
    // creating a public constructor 
    public Test()  {  this.text = "GeeksforGeeks"; } 
	
    // Creating a public method with no arguments 
    public void getText()  { 
        System.out.println("The string is " + this.text); 
    }
    
    // Creating a public method with int as argument 
    public void printNumber(int n)  { 
        System.out.println("The number is " + n); 
    } 
    
    // creating a private method 
    private void printPrivado() { 
        System.out.println("Private method invoked"); 
    } 
}
