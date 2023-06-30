import java.awt.BorderLayout;

import javax.swing.JDialog;

public class PaymentsDialog extends JDialog {

    private PaymentsScrollPanel paymentsScrollPanel;

    public PaymentsDialog(MainFrame mainFrame, boolean fromDispenser) {
        super(mainFrame, "Płatności");
        setLocationRelativeTo(mainFrame);
        paymentsScrollPanel = new PaymentsScrollPanel(mainFrame, fromDispenser);
        add(paymentsScrollPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}
