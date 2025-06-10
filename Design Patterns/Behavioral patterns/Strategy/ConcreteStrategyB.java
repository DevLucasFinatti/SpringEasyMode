package strategy;

/**
 * Estratégia concreta B: outra forma de executar a lógica.
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executando a estratégia B (ex: ordenação por bolha).");
    }
}
