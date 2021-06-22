package co.com.multithreading.java8;

public class MultithreadJavaEight {
	
	public static void main(String[] args) {
		
		//First way
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		
		task.run();
		
		Thread threadExample = new Thread(task);
		
		threadExample.start();
		
		//Another way
		Thread threadEx = new Thread( () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello with lambda from " + threadName);
		} );
		
		threadEx.start();
		
	}
	
}
