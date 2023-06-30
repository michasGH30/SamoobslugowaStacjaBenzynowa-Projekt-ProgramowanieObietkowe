import java.util.ArrayList;

public class PaymentsSingleton {
    private static PaymentsSingleton instance;
    private ArrayList<Payment> payments;

    private PaymentsSingleton() {
        payments = new ArrayList<Payment>();
    }

    public static PaymentsSingleton getInstance() {
        if (instance == null) {
            synchronized (PaymentsSingleton.class) {
                if (instance == null) {
                    instance = new PaymentsSingleton();
                }
            }
        }
        return instance;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
}
