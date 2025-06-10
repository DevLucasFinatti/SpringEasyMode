package builder;

/**
 * Produto final.
 * Representa o objeto complexo que está sendo construído.
 */
public class Car {
    private String engine;
    private int wheels;
    private String color;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void specifications() {
        System.out.println("Engine: " + engine);
        System.out.println("Wheels: " + wheels);
        System.out.println("Color: " + color);
    }
}
