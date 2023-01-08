package observer;

public class NotificationManager implements PaymentListener {

    @Override
    public void paymentMade(PaymentEvent e) {
        sendNotification();
    }
    private void sendNotification() {
        System.out.println("Notification Sent");
    }
}
