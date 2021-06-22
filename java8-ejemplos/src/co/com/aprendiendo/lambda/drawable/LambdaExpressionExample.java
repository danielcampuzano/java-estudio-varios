package co.com.aprendiendo.lambda.drawable;

public class LambdaExpressionExample {
	public static void main(String[] args) {

        int width=10;         
        //with lambda 
        Drawable withLambda=()->{  
            System.out.println("Drawing "+width);  
        };  
        withLambda.draw();  
		
	}
}
