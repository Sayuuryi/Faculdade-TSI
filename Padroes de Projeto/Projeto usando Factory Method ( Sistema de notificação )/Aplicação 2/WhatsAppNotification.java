public class WhatsAppNotification implements Notification {

    public void send(String message) {
        System.out.println("Enviando mensagem utilizando WhatsApp: " + message);
    }

}