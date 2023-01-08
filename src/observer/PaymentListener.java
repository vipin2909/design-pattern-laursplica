package observer;

@FunctionalInterface
public interface PaymentListener {
   public void paymentMade(PaymentEvent e);
}
