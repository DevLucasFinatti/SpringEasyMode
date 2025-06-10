package strategy;

/**
 * O contexto mantém uma referência para uma Strategy e pode mudar em tempo de execução.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performStrategy() {
        strategy.execute();
    }
}
