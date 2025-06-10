package abstract_factory_example.factories;

import abstract_factory_example.alerts.Alert;
import abstract_factory_example.toasts.Toast;

/**
 * Fábrica abstrata que declara os métodos para criação de objetos das famílias Alert e Toast.
 */
public interface NotificationFactory {
    Alert createAlert();
    Toast createToast();
}
