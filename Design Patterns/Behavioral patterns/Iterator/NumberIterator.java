package iterator;

import java.util.List;

/**
 * Iterator concreto para navegar pela lista de números.
 */
public class NumberIterator implements Iterator<Integer> {
    private List<Integer> numbers;
    private int position = 0;

    public NumberIterator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        return position < numbers.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("Não há mais elementos");
        }
        return numbers.get(position++);
    }
}
