package factories;

import notifications.Notification;

/**
 * Criador abstrato (Factory).
 * Define o método-fábrica abstrato que deve ser implementado pelas subclasses.
 * Pode conter lógica comum que depende do produto criado.
 */
public abstract class NotificationFactory {
    public void sendNotification() {
        Notification notification = createNotification();
        notification.notifyUser();
    }

    public abstract Notification createNotification();
}
