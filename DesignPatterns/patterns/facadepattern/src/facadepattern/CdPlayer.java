package facadepattern;

public class CdPlayer {

	private Amplifier amplifier;

	public CdPlayer(Amplifier amplifier) {
		super();
		this.amplifier = amplifier;
	}
	
	public void on() {
		System.out.println("Cd player on");
	}
	
	public void off() {
		System.out.println("Cd player off");
	}
	
	public void eject() {
		System.out.println("Cd player ejecting");
	}
	
	public void pause() {
		System.out.println("Cd player paused");
	}
	
	public void play() {
		System.out.println("Cd player playing");
	}
	
	public void stop() {
		System.out.println("Cd player stopped");
	}
}
