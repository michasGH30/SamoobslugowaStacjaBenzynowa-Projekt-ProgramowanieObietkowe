import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChangeFuelPriceDialogActionListener implements ActionListener {

    private ChangeFuelPriceDialog changeFuelPriceDialog;
    private MainFrame mainFrame;
    private JTextField enterNewPriceTextField;
    private CustomLabel fuelPriceLabel;

    public ChangeFuelPriceDialogActionListener(ChangeFuelPriceDialog changeFuelPriceDialog, MainFrame mainFrame,
            JTextField enterNewPriceTextField, CustomLabel fuelPriceLabel) {
        this.changeFuelPriceDialog = changeFuelPriceDialog;
        this.mainFrame = mainFrame;
        this.enterNewPriceTextField = enterNewPriceTextField;
        this.fuelPriceLabel = fuelPriceLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            float newPrice = Float.parseFloat(enterNewPriceTextField.getText());
            mainFrame.getPerson().getCurentDispenser().setPricePerLitr(newPrice);
            fuelPriceLabel.setText("Cena za litr: " + newPrice + " zł");
            changeFuelPriceDialog.setVisible(false);
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(changeFuelPriceDialog,
                    "Podałeś złą wartość kwoty za paliwo(zły format liczby)",
                    "Błędna wartość",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(changeFuelPriceDialog, "Nie podałeś żadnej wartości", "Błędna wartość",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
