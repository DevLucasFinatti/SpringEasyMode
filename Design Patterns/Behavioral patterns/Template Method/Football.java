package template;

/**
 * Subclasse concreta que implementa o jogo de futebol.
 */
public class Football extends Game {

    @Override
    protected void initialize() {
        System.out.println("Futebol iniciado. Jogadores prontos.");
    }

    @Override
    protected void startPlay() {
        System.out.println("Partida de futebol em andamento.");
    }

    @Override
    protected void endPlay() {
        System.out.println("Futebol terminado.");
    }
}
