package state;

/**
 * Estado concreto B: implementa outro comportamento associado a um estado do Context.
 */
public class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Estado B está lidando com a solicitação.");
        context.setState(new ConcreteStateA()); // troca de volta para o estado anterior
    }
}
