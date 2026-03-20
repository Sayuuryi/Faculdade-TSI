public class SMSFactory extends NotificationFactory {
    
    public Notification createNotification() {
        return new SMSNotification();
    }
}
