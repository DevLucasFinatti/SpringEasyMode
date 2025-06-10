package state;

/**
 * Estado concreto A: implementa um comportamento associado a um estado do Context.
 */
public class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Estado A está lidando com a solicitação.");
        context.setState(new ConcreteStateB()); // troca para o próximo estado
    }
}
