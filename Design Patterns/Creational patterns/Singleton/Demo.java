package singleton;

/**
 * Classe cliente.
 * Demonstra o uso do Singleton.
 */
public class Demo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Primeira mensagem");

        Logger logger2 = Logger.getInstance();
        logger2.log("Segunda mensagem");

        // Confirma que ambas as instâncias são a mesma
        System.out.println("Mesma instância? " + (logger1 == logger2));
    }
}
