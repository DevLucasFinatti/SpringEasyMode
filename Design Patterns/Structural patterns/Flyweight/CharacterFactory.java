package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Gerencia objetos compartilhados para reutilização.
 */
public class CharacterFactory {
    private Map<Character, ConcreteCharacter> characters = new HashMap<>();

    public Character getCharacter(char symbol) {
        ConcreteCharacter character = characters.get(symbol);
        if (character == null) {
            character = new ConcreteCharacter(symbol);
            characters.put(symbol, character);
            System.out.println("Criando novo objeto para caractere: '" + symbol + "'");
        }
        return character;
    }
}
