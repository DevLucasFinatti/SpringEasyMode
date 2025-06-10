package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeito concreto que mantém o estado e notifica os observadores quando muda.
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void setMessage(String message) {
        this.message = message;
        notifyObservers(); // Notifica todos ao mudar o estado
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
