package observer;

import java.util.List;

/**
 * Interface do sujeito observado.
 */
public interface Subject {
    void attach(Observer o);     // Adiciona observador
    void detach(Observer o);     // Remove observador
    void notifyObservers();      // Notifica todos os observadores
}
