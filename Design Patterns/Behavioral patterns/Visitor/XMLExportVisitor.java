package visitor;

/**
 * Implementação concreta de Visitor que exporta os objetos para XML.
 */
public class XMLExportVisitor implements Visitor {

    @Override
    public void visitDot(Dot dot) {
        System.out.println("<dot x=\"" + dot.x + "\" y=\"" + dot.y + "\" />");
    }

    @Override
    public void visitCircle(Circle circle) {
        System.out.println("<circle x=\"" + circle.x + "\" y=\"" + circle.y + "\" radius=\"" + circle.radius + "\" />");
    }
}
