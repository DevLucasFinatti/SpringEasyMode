package visitor;

/**
 * Exemplo de uso do padrão Visitor.
 */
public class Client {
    public static void main(String[] args) {
        Shape dot = new Dot();
        Shape circle = new Circle();

        Visitor xmlExporter = new XMLExportVisitor();

        dot.accept(xmlExporter);
        circle.accept(xmlExporter);
    }
}
