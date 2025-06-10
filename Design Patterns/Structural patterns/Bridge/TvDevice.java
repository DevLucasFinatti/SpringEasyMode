package bridge;

/**
 * Implementação concreta da interface Device para TV.
 */
public class TvDevice implements Device {
    private boolean on = false;
    private int volume = 30;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("TV ligada");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("TV desligada");
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("Volume da TV ajustado para " + volume + "%");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}
