import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ShowDispenserPaymentsButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private boolean fromDispenser;

    public ShowDispenserPaymentsButtonActionListener(MainFrame mainFrame, boolean fromDispenser) {
        this.mainFrame = mainFrame;
        this.fromDispenser = fromDispenser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (fromDispenser) {
            if (mainFrame.getPerson().getCurentDispenser().getPayments().size() == 0) {
                JOptionPane.showMessageDialog(mainFrame, "Lista płaności danego dystrybutora jest pusta",
                        "Lista płatności",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                new PaymentsDialog(mainFrame, fromDispenser);
            }
        } else {
            if (PaymentsSingleton.getInstance().getPayments().size() == 0) {
                JOptionPane.showMessageDialog(mainFrame, "Lista płaności jest pusta",
                        "Lista płatności",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                new PaymentsDialog(mainFrame, fromDispenser);
            }
        }

    }

}
