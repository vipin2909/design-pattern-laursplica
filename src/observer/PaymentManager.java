package observer;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager implements PaymentSubject {

    private final List<PaymentListener> paymentListeners = new ArrayList<>();
//    private final NotificationManager notificationManager = new NotificationManager();
//    private final PaymentEventLogger paymentEventLogger = new PaymentEventLogger();

    // this means payment manager object is highly coupled with both notification manager and PaymentEventLogger

    // but in real world examples we only need only logEvent() or in some cases only need sendNotification()
//    public void pay() { // -> Notify some payment listeners
//        notificationManager.sendNotification();
//        paymentEventLogger.logEvent();
//    }


    public void pay() {
        PaymentEvent e = new PaymentEvent(this);
        paymentListeners.forEach(p -> p.paymentMade(e)); // PaymentListener::paymentMade -> when there is no method argument
    }


    public void registerListener(PaymentListener p) {
        paymentListeners.add(p);
    }


    @Override
    public void unregisterListener(PaymentListener p) {
        paymentListeners.remove(p);
    }
}

// java jdk has its own observable and observer design pattern
// but since observer pattern is more customizable that why events differ all the time
// and many times we want clean Code names of functions methods and classes
// due to this we have to made our own customer Observable and observer
