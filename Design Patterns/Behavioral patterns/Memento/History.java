package memento;

import java.util.Stack;

/**
 * Caretaker que mantém o histórico de estados (mementos).
 */
public class History {
    private Stack<Memento> history = new Stack<>();

    public void push(Memento memento) {
        history.push(memento);
    }

    public Memento pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
