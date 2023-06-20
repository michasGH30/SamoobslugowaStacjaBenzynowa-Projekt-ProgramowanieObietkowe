import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TankFuelDialogCalculateAmountToPayButtonActionListener implements ActionListener {

    private JLabel amountToPayLabel;
    private JButton payForFuelButton;
    private JTextField fuelAmountTextField;
    private TankFuelDialog tankFuelDialog;
    private JTextField amountToPayTextField;
    private MainFrame mainFrame;

    public TankFuelDialogCalculateAmountToPayButtonActionListener(JLabel amountToPayLabel, JButton payForFuelButton,
            JTextField fuelAmountTextField, TankFuelDialog tankFuelDialog, JTextField amountToPayTextField,
            MainFrame mainFrame) {
        this.amountToPayLabel = amountToPayLabel;
        this.payForFuelButton = payForFuelButton;
        this.fuelAmountTextField = fuelAmountTextField;
        this.tankFuelDialog = tankFuelDialog;
        this.amountToPayTextField = amountToPayTextField;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            float enterAmountOfFuel = Float.parseFloat(fuelAmountTextField.getText());
            try {
                float amountToPay = mainFrame.getPerson().getCurentDispenser().getAmountToPay(enterAmountOfFuel);
                amountToPay = Utils.roundToTwoDigits(amountToPay);
                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().setAmountToPay(amountToPay);
                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().setAmountOfFuel(enterAmountOfFuel);
                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter()
                        .setTypeOfFuel(mainFrame.getPerson().getCurentDispenser().getType());

                amountToPayLabel.setText("Kwota do zapłaty: " + amountToPay + " zł");
                payForFuelButton.setEnabled(true);
                amountToPayTextField.setEnabled(true);
            } catch (NotEnoughFuelException exc) {
                JOptionPane.showMessageDialog(tankFuelDialog, exc.getMessage(), "Zła ilość paliwa",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(tankFuelDialog,
                    "Podałeś złą wartość paliwa(zły typ liczby zmiennoprzecinkowej)", "Błędna wartość",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(tankFuelDialog, "Nie podałeś żadnej wartości", "Błędna wartość",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
