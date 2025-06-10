package builder;

/**
 * Builder concreto.
 * Implementa os passos definidos pela interface Builder para criar um carro.
 */
public class CarBuilder implements Builder {
    private Car car = new Car();

    @Override
    public void buildEngine() {
        car.setEngine("V8 engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void paint() {
        car.setColor("Red");
    }

    @Override
    public Car getResult() {
        return car;
    }
}
