package mediator;

/**
 * Interface Mediator que define como os objetos se comunicam via mediador.
 */
public interface Mediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
