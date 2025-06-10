package singleton;

/**
 * Singleton.
 * Garante que apenas uma instância de Logger exista no sistema.
 */
public class Logger {
    // Instância única (eager initialization)
    private static final Logger instance = new Logger();

    // Construtor privado impede criação de novas instâncias
    private Logger() {
        System.out.println("Logger iniciado.");
    }

    // Método público para acessar a única instância
    public static Logger getInstance() {
        return instance;
    }

    // Método de exemplo
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
