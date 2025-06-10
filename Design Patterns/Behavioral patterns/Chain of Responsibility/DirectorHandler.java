package chain_of_responsibility;

/**
 * Handler concreto para o diretor.
 * Pode aprovar pedidos até 5000.
 */
public class DirectorHandler extends Handler {

    @Override
    public void handleRequest(int amount) {
        if (amount <= 5000) {
            System.out.println("Diretor aprovou pedido de R$" + amount);
        } else if (next != null) {
            next.handleRequest(amount);
        } else {
            System.out.println("Pedido não pode ser aprovado");
        }
    }
}
