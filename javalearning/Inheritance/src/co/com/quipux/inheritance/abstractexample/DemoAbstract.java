package co.com.quipux.inheritance.abstractexample;

public class DemoAbstract {

		public static void main(String[] args) {
			Adult adult = new Adult();
			adult.move();
			System.out.println("Adult progress "+ adult.progress);
			
			adult.talk();
		}
}
