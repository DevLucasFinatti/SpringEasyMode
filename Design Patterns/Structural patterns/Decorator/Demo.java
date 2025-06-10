package decorator;

/**
 * Cliente.
 * Demonstra como decorar um café com complementos.
 */
public class Demo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " custa $" + coffee.getCost());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.getDescription() + " custa $" + milkCoffee.getCost());

        Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println(milkSugarCoffee.getDescription() + " custa $" + milkSugarCoffee.getCost());
    }
}
