package abstract_factory_example.alerts;

/**
 * Produto concreto da família Alert para a plataforma iOS.
 */
public class IosAlert implements Alert {
    @Override
    public void show() {
        System.out.println("You have created an iOS-style Alert.");
    }
}
