package builder;

/**
 * Interface do Builder.
 * Define os passos para construir os componentes do produto.
 */
public interface Builder {
    void buildEngine();
    void buildWheels();
    void paint();

    Car getResult();
}
