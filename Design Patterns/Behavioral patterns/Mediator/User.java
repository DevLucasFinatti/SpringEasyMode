package mediator;

/**
 * Usuário abstrato que usa o mediador para enviar e receber mensagens.
 */
public abstract class User {
    protected Mediator mediator;
    protected String name;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
