package visitor;

/**
 * Interface para elementos que aceitam um visitante.
 */
public interface Shape {
    void accept(Visitor visitor);
}
