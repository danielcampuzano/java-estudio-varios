package facadepattern;

public class DvdPlayer {

	Amplifier amplifier;

	public DvdPlayer(Amplifier amplifier) {
		super();
		this.amplifier = amplifier;
	}
	
	public void on() {
		System.out.println("Dvd player on");
	}
	
	public void off() {
		System.out.println("Dvd player off");
	}
	
	public void eject() {
		System.out.println("Dvd player ejecting");
	}
	
	public void pause() {
		System.out.println("Dvd player paused");
	}
	
	public void play(String movie) {
		System.out.println("Dvd player playing "+movie);
	}
	
	public void stop() {
		System.out.println("Dvd player stopped");
	}
}
