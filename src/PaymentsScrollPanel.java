import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class PaymentsScrollPanel extends JScrollPane {

    private JList<String> payments;

    public PaymentsScrollPanel(MainFrame mainFrame, boolean fromDispenser) {
        super(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setListContent(fromDispenser, mainFrame);
    }

    private void setListContent(boolean fromDispenser, MainFrame mainFrame) {
        ArrayList<Payment> paymentsList;
        int i = 0;
        if (fromDispenser) {
            paymentsList = mainFrame.getPerson().getCurentDispenser().getPayments();

        } else {
            paymentsList = PaymentsSingleton.getInstance().getPayments();
        }
        String[] paymentsStringArray = new String[paymentsList.size()];
        for (Payment payment : paymentsList) {
            paymentsStringArray[i] = payment.toString();
            i++;
        }
        payments = new JList<String>(paymentsStringArray);
        payments.setFont(FontSingleton.getInstance().getSmallerFont());
        setViewportView(payments);
    }
}
