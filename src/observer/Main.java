package observer;

import java.net.NoRouteToHostException;


// javafx swing, awt are relies on eventListener which uses Observer pattern
public class Main {
    public static void main(String[] args) {
        PaymentManager paymentManager = new PaymentManager();

//        we can also use these declarations as well
//        paymentManager.registerListener(new NotificationManager());
//        paymentManager.registerListener(NotificationManager::new);

//        paymentManager.registerListener(e -> {
//            System.out.print(":)");
//            e.getPaymentSubject().unregisterListener(this);
//        });
        paymentManager.registerListener(new NotificationManager());
        paymentManager.registerListener(new PaymentEventLogger("abcd"));

//        paymentManager.pay();
        paymentManager.pay();



    }
}
