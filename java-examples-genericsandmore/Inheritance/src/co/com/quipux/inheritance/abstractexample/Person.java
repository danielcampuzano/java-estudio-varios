package co.com.quipux.inheritance.abstractexample;

public abstract class Person {
   
    protected int age = 0;
    protected String firstname = "firstname";
    protected String lastname = "lastname";
    protected String gender = "MALE";
    protected int progress = 0;
    public Person() {
    }
	
    public void move() {
        this.progress++;
    }
    public abstract void talk();
}
