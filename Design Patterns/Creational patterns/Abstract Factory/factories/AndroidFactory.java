package abstract_factory.factory;

import abstract_factory.alert.Alert;
import abstract_factory.alert.AndroidAlert;
import abstract_factory.toast.Toast;
import abstract_factory.toast.AndroidToast;

/**
 * Fábrica concreta que cria objetos Android (Alert e Toast).
 */
public class AndroidFactory implements NotificationFactory {
    @Override
    public Alert createAlert() {
        return new AndroidAlert();
    }

    @Override
    public Toast createToast() {
        return new AndroidToast();
    }
}
