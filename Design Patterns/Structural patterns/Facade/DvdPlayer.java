package facade;

/**
 * Subsistema: DVD Player.
 */
public class DvdPlayer {
    public void on() {
        System.out.println("DVD Player ligado.");
    }
    public void play(String movie) {
        System.out.println("DVD Player reproduzindo: " + movie);
    }
    public void stop() {
        System.out.println("DVD Player parado.");
    }
    public void off() {
        System.out.println("DVD Player desligado.");
    }
}
