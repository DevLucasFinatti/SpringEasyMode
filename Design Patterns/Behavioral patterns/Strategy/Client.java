package strategy;

/**
 * Exemplo de uso do padrão Strategy.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.performStrategy();  // Usa a estratégia A

        context.setStrategy(new ConcreteStrategyB());
        context.performStrategy();  // Agora usa a estratégia B
    }
}
