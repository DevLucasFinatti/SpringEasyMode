package visitor;

/**
 * Interface de visitante com métodos para cada tipo de elemento visitável.
 */
public interface Visitor {
    void visitDot(Dot dot);
    void visitCircle(Circle circle);
}
