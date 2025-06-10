package notifications;

/**
 * Produto concreto.
 * Implementa a notificação via SMS.
 */
public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}
