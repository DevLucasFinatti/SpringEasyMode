package bridge;

/**
 * Interface para implementação (Implementor).
 * Representa dispositivos eletrônicos que podem ser controlados.
 */
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
    int getVolume();
    boolean isEnabled();
}
