package abstract_factory_example.toasts;

/**
 * Produto concreto da família Toast para a plataforma iOS.
 */
public class IosToast implements Toast {
    @Override
    public void display() {
        System.out.println("You have displayed an iOS-style Toast.");
    }
}
