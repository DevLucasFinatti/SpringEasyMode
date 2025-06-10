package iterator;

/**
 * Interface Iterator define métodos para navegar na coleção.
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
