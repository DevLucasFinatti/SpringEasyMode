package chain_of_responsibility;

/**
 * Handler concreto para o gerente.
 * Pode aprovar pedidos até 1000.
 */
public class ManagerHandler extends Handler {

    @Override
    public void handleRequest(int amount) {
        if (amount <= 1000) {
            System.out.println("Gerente aprovou pedido de R$" + amount);
        } else if (next != null) {
            next.handleRequest(amount);
        } else {
            System.out.println("Pedido não pode ser aprovado");
        }
    }
}
