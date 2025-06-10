package chain_of_responsibility;

/**
 * Handler concreto para o vice-presidente.
 * Pode aprovar pedidos até 10000.
 */
public class VicePresidentHandler extends Handler {

    @Override
    public void handleRequest(int amount) {
        if (amount <= 10000) {
            System.out.println("Vice-presidente aprovou pedido de R$" + amount);
        } else if (next != null) {
            next.handleRequest(amount);
        } else {
            System.out.println("Pedido muito alto para aprovar");
        }
    }
}
