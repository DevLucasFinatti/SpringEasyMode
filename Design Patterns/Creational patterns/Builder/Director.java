package builder;

/**
 * Diretor.
 * Define a ordem de construção e usa o Builder para construir o produto.
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildEngine();
        builder.buildWheels();
        builder.paint();
    }
}
