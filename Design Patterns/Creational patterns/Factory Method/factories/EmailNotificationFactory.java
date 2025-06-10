package factories;

import notifications.EmailNotification;
import notifications.Notification;

/**
 * Fábrica concreta.
 * Cria instâncias de EmailNotification.
 */
public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
