package mediator;

/**
 * Usuário concreto que envia e recebe mensagens via mediador.
 */
public class ConcreteUser extends User {

    public ConcreteUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " envia: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " recebeu: " + message);
    }
}
