package notifications;

/**
 * Produto concreto.
 * Implementa a notificação via push (notificação por aplicativo).
 */
public class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}
