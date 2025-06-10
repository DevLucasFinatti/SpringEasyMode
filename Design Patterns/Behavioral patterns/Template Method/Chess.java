package template;

/**
 * Subclasse concreta que implementa o jogo de xadrez.
 */
public class Chess extends Game {

    @Override
    protected void initialize() {
        System.out.println("Xadrez iniciado. Preparando tabuleiro...");
    }

    @Override
    protected void startPlay() {
        System.out.println("Partida de xadrez em andamento.");
    }

    @Override
    protected void endPlay() {
        System.out.println("Xadrez terminado.");
    }
}
