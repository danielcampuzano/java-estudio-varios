package facadepattern;

public class Projector {

	DvdPlayer dvdPlayer;

	public Projector(DvdPlayer dvdPlayer) {
		super();
		this.dvdPlayer = dvdPlayer;
	}
	
	public void on() {
		System.out.println("Projector player on");
	}
	
	public void off() {
		System.out.println("Projector player off");
	}
	
	public void tvMode() {
		System.out.println("Projector tv mode");
	}
	
	public void wideScreenMode() {
		System.out.println("Projector wide screen mode");
	}
	
}
