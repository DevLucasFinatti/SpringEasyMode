package strategy;

/**
 * Estratégia concreta A: uma forma específica de executar a lógica.
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executando a estratégia A (ex: ordenação rápida).");
    }
}
