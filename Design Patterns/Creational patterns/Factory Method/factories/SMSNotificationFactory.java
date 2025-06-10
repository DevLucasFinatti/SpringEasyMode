package factories;

import notifications.Notification;
import notifications.SMSNotification;

/**
 * Fábrica concreta.
 * Cria instâncias de SMSNotification.
 */
public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
