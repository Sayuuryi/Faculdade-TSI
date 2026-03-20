public class WhatsAppFactory extends NotificationFactory {

    public Notification createNotification() {
        return new WhatsAppNotification();
    }
    
}