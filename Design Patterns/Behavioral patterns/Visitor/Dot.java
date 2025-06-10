package visitor;

/**
 * Um tipo concreto de Shape: Ponto.
 */
public class Dot implements Shape {
    public int x = 5;
    public int y = 10;

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDot(this);
    }
}
