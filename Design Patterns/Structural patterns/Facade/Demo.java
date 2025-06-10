package facade;

/**
 * Cliente.
 * Demonstra o uso do Facade para controlar o home theater.
 */
public class Demo {
    public static void main(String[] args) {
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, lights);

        homeTheater.watchMovie("Matrix");
        System.out.println();
        homeTheater.endMovie();
    }
}
