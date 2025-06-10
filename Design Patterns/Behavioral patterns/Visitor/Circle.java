package visitor;

/**
 * Outro tipo concreto de Shape: Círculo.
 */
public class Circle implements Shape {
    public int x = 15;
    public int y = 20;
    public int radius = 30;

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }
}
