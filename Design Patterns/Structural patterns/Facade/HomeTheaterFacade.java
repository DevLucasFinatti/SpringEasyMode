package facade;

/**
 * Facade.
 * Interface simplificada para controlar todo o sistema.
 */
public class HomeTheaterFacade {
    private DvdPlayer dvd;
    private Projector projector;
    private TheaterLights lights;

    public HomeTheaterFacade(DvdPlayer dvd, Projector projector, TheaterLights lights) {
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparando para assistir o filme...");
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Desligando o sistema de filme...");
        dvd.stop();
        dvd.off();
        projector.off();
        lights.on();
    }
}
