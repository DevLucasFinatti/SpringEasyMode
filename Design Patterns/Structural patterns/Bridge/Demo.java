package bridge;

/**
 * Cliente que usa a abstração e a implementação desacopladas.
 */
public class Demo {
    public static void main(String[] args) {
        Device tv = new TvDevice();
        RemoteControl remote = new RemoteControl(tv);

        remote.togglePower();
        remote.volumeUp();

        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(tv);
        advancedRemote.mute();

        Device radio = new RadioDevice();
        RemoteControl radioRemote = new RemoteControl(radio);
        radioRemote.togglePower();
        radioRemote.volumeDown();
    }
}
