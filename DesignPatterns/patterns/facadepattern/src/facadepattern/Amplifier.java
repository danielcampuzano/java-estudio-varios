package facadepattern;

public class Amplifier {

	private Tuner tuner;
	private DvdPlayer dvdPlayer;
	private CdPlayer cdPlayer;
	
	public void on() {
		System.out.println("Amp on");
	}
	
	public void off() {
		System.out.println("Amp off");
	}

	public void setTuner(Tuner tuner) {
		this.tuner = tuner;
	}

	public void setDvdPlayer(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
	}

	public void setCdPlayer(CdPlayer cdPlayer) {
		this.cdPlayer = cdPlayer;
	}
	
	public void setVolume(int volume) {
		System.out.println("Volume of "+volume);
	}
	
}
