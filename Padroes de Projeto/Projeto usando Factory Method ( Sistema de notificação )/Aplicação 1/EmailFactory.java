public class EmailFactory extends NotificationFactory {

    public Notification createNotification() {
        return new EmailNotification();
    }

}