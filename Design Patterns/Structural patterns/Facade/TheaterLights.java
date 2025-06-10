package facade;

/**
 * Subsistema: Luzes do teatro.
 */
public class TheaterLights {
    public void dim(int level) {
        System.out.println("Luzes diminuídas para " + level + "%.");
    }
    public void on() {
        System.out.println("Luzes ligadas.");
    }
}
