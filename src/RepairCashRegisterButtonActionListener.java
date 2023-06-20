import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RepairCashRegisterButtonActionListener implements ActionListener {

    private MainFrame mainFrame;

    private JLabel destroyMessageLabel;

    public RepairCashRegisterButtonActionListener(MainFrame mainFrame, JLabel destroyMessageLabel) {
        this.mainFrame = mainFrame;
        this.destroyMessageLabel = destroyMessageLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean destroyed = mainFrame.getPerson().getCurentDispenser().getCashRegister().isActive();
        ((Employee) mainFrame.getPerson()).repair(mainFrame.getPerson().getCurentDispenser().getCashRegister());
        if (!destroyed) {
            JOptionPane.showMessageDialog(mainFrame, "Pomyślnie naprawiono kasę fiskalną", "Naprawa kasy fiskalnej",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Nie ma potrzeby naprawiania kasy fiskalnej. Jest ona sprawna",
                    "Naprawa kasy fiskalnej",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            mainFrame.getPerson().getCurentDispenser().checkActive();
            destroyMessageLabel.setText("");
            mainFrame.pack();
        } catch (InActiveDispenserException e1) {
            destroyMessageLabel.setText("Dystrybutor nie działa");
            mainFrame.pack();
        } catch (InActiveCashRegisterException e1) {
            destroyMessageLabel.setText("Kasa fiskalna nie działa");
            mainFrame.pack();
        } catch (InActiveReciptPrinterException e1) {
            destroyMessageLabel.setText("Drukarka paragonów nie działa");
            mainFrame.pack();
        }

    }

}
