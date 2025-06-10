package abstract_factory_example.toasts;

/**
 * Produto concreto da família Toast para a plataforma Android.
 */
public class AndroidToast implements Toast {
    @Override
    public void display() {
        System.out.println("You have displayed an Android-style Toast.");
    }
}
