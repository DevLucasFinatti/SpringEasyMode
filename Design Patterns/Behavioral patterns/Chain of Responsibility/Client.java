package chain_of_responsibility;

/**
 * Cliente que cria a cadeia de handlers e envia pedidos.
 */
public class Client {
    public static void main(String[] args) {
        Handler manager = new ManagerHandler();
        Handler director = new DirectorHandler();
        Handler vicePresident = new VicePresidentHandler();

        // Monta a cadeia: Manager -> Director -> VicePresident
        manager.setNext(director);
        director.setNext(vicePresident);

        int[] pedidos = {500, 2500, 7000, 15000};

        for (int pedido : pedidos) {
            manager.handleRequest(pedido);
        }
    }
}
