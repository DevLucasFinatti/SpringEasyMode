package flyweight;

/**
 * Cliente.
 * Demonstra a reutilização dos objetos Flyweight.
 */
public class Client {
    public static void main(String[] args) {
        String document = "HELLO FLYWEIGHT";

        CharacterFactory factory = new CharacterFactory();

        int positionX = 0;
        int positionY = 0;

        for (char c : document.toCharArray()) {
            Character character = factory.getCharacter(c);
            character.display(positionX, positionY);
            positionX += 10; // exemplo de mudança no estado extrínseco
        }
    }
}
