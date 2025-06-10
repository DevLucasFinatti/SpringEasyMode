package observer;

/**
 * Exemplo de uso do padrão Observer.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer obs1 = new ConcreteObserver("Observer 1");
        Observer obs2 = new ConcreteObserver("Observer 2");

        subject.attach(obs1);
        subject.attach(obs2);

        subject.setMessage("Primeira Notificação");

        subject.detach(obs1);

        subject.setMessage("Segunda Notificação");
    }
}
