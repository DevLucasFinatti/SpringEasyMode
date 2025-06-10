package template;

/**
 * Classe abstrata que define o template method.
 */
public abstract class Game {

    // Template Method (método final que define o algoritmo)
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void endPlay();
}
