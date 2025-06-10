package abstract_factory.factory;

import abstract_factory.alert.Alert;
import abstract_factory.alert.IosAlert;
import abstract_factory.toast.Toast;
import abstract_factory.toast.IosToast;

/**
 * Fábrica concreta que cria objetos iOS (Alert e Toast).
 */
public class IosFactory implements NotificationFactory {
    @Override
    public Alert createAlert() {
        return new IosAlert();
    }

    @Override
    public Toast createToast() {
        return new IosToast();
    }
}
