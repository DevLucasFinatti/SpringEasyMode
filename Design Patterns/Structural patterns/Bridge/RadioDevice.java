package bridge;

/**
 * Implementação concreta da interface Device para Rádio.
 */
public class RadioDevice implements Device {
    private boolean on = false;
    private int volume = 50;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Rádio ligado");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Rádio desligado");
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("Volume do Rádio ajustado para " + volume + "%");
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
