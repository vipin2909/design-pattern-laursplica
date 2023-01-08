package observer;

import java.util.Objects;

public class PaymentEventLogger implements PaymentListener {

    private final String id;
    public PaymentEventLogger(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        PaymentEventLogger that = (PaymentEventLogger) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public void paymentMade(PaymentEvent e) {
        logEvent();
    }

    public void logEvent() {
        System.out.println("Payment Received!!");
    }
}
