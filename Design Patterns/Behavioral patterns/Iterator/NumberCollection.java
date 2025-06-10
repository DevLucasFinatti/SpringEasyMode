package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção de números que cria um iterator para navegar pelos seus elementos.
 */
public class NumberCollection {
    private List<Integer> numbers = new ArrayList<>();

    public void add(int number) {
        numbers.add(number);
    }

    public Iterator<Integer> iterator() {
        return new NumberIterator(numbers);
    }
}
