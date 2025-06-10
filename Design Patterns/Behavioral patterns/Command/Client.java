package command;

/**
 * Cliente que configura os comandos e invoca a execução.
 */
public class Client {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Luz ligada

        remote.setCommand(lightOff);
        remote.pressButton(); // Luz desligada
    }
}
