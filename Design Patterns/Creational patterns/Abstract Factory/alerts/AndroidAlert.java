package abstract_factory_example.alerts;

/**
 * Produto concreto da família Alert para a plataforma Android.
 */
public class AndroidAlert implements Alert {
    @Override
    public void show() {
        System.out.println("You have created an Android-style Alert.");
    }
}
