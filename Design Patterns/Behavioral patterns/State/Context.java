package state;

/**
 * Mantém uma instância de um objeto State que define o estado atual.
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        System.out.println("Mudando estado para: " + state.getClass().getSimpleName());
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}
