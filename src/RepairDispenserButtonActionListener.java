import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RepairDispenserButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private CustomLabel destroyMessageLabel;

    public RepairDispenserButtonActionListener(MainFrame mainFrame, CustomLabel destroyMessageLabel) {
        this.mainFrame = mainFrame;
        this.destroyMessageLabel = destroyMessageLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean destroyed = mainFrame.getPerson().getCurentDispenser().isActive();
        ((Employee) mainFrame.getPerson()).repair(mainFrame.getPerson().getCurentDispenser());
        if (!destroyed) {
            JOptionPane.showMessageDialog(mainFrame, "Pomyślnie naprawiono dystrybutor", "Naprawa dystrybutora",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Nie ma potrzeby naprawiania dystrybutora. Jest on sprawny",
                    "Naprawa dystrybutora",
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
