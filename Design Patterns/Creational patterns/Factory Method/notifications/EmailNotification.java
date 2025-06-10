package notifications;

/**
 * Produto concreto.
 * Implementa a notificação via e-mail.
 */
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}
