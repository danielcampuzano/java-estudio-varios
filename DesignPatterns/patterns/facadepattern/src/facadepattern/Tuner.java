package facadepattern;

public class Tuner {

	Amplifier amplifier;

	public Tuner(Amplifier amplifier) {
		super();
		this.amplifier = amplifier;
	}
	
	public void on() {
		System.out.println("Tuner player on");
	}
	
	public void off() {
		System.out.println("Tuner player off");
	}
	
	public void setAm() {
		System.out.println("Tuner setting Am");
	}
	
	public void setFm() {
		System.out.println("Tuner setting Fm");
	}
	
	public void setFrequency() {
		System.out.println("Tuner setting frequency");
	}
}
