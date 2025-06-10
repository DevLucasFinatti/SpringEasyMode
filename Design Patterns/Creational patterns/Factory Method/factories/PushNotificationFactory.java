package factories;

import notifications.Notification;
import notifications.PushNotification;


  Fábrica concreta.
  Cria instâncias de PushNotification.
 
public class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
