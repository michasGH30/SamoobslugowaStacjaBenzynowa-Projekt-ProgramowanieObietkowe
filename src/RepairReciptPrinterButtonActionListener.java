import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RepairReciptPrinterButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private CustomLabel destroyMessageLabel;

    public RepairReciptPrinterButtonActionListener(MainFrame mainFrame, CustomLabel destroyMessageLabel) {
        this.mainFrame = mainFrame;
        this.destroyMessageLabel = destroyMessageLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean destroyed = mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().isActive();
        ((Employee) mainFrame.getPerson()).repair(mainFrame.getPerson().getCurentDispenser().getReceiptPrinter());
        if (!destroyed) {
            JOptionPane.showMessageDialog(mainFrame, "Pomyślnie naprawiono drukarkę paragonów",
                    "Naprawa drukarki paragonów",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Nie ma potrzeby naprawiania drukarki paragonów. Jest ona sprawna",
                    "Naprawa drukarki paragonów",
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
