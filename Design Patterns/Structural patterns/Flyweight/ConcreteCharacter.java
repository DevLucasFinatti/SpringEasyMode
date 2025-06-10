package flyweight;

/**
 * Flyweight concreto.
 * Estado intrínseco: símbolo (letra)
 * Estado extrínseco: posição na tela
 */
public class ConcreteCharacter implements Character {
    private final char symbol; // estado intrínseco compartilhado

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int positionX, int positionY) {
        System.out.println("Renderizando '" + symbol + "' em (" + positionX + ", " + positionY + ")");
    }
}
