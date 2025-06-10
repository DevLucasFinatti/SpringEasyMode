package observer;

/**
 * Observador concreto que reage às mudanças do sujeito.
 */
public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu mensagem: " + message);
    }
}
