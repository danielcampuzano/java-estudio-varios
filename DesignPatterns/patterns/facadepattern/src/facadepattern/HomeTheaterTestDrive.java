package facadepattern;

public class HomeTheaterTestDrive {

	public static void main(String[] args) {

		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner(amp);
		DvdPlayer dvd = new DvdPlayer(amp);
		CdPlayer cd = new CdPlayer(amp);
		Projector projector = new Projector(dvd);
		Screen screen = new Screen();
		TheaterLights lights = new TheaterLights();
		PopcornPopper popper = new PopcornPopper();

		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
		homeTheater.watchMovie("Raiders of the Lost Ark");

	}

}
