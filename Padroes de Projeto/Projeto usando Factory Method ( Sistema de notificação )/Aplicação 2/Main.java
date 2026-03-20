public class Main {
    
    public static void main(String[] args) {
        
        NotificationFactory factory;

        factory = new EmailFactory();
        Notification n1 = factory.createNotification();
        n1.send("Bem vindo!");

        factory = new SMSFactory();
        Notification n2 = factory.createNotification();
        n2.send("Seu código SMS chegou.");

        factory = new PushFactory();
        Notification n3 = factory.createNotification();
        n3.send("Nova notificação! ");
        
        factory = new WhatsAppFactory();
        Notification n4 = factory.createNotification();
        n4.send("Mensagem enviada via WhatsApp");
    }
}
