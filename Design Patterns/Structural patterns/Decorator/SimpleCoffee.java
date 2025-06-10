package decorator;

/**
 * Componente concreto.
 * Um café simples sem adicionais.
 */
public class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Café simples";
    }
}
