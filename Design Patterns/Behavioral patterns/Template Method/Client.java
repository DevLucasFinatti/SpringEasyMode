package template;

/**
 * Exemplo de uso do padrão Template Method.
 */
public class Client {
    public static void main(String[] args) {
        Game game = new Chess();
        game.play();

        System.out.println("-------------");

        game = new Football();
        game.play();
    }
}
