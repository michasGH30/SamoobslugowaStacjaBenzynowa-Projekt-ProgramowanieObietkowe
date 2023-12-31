import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TankFuelDialogPayForFuelButtonActionListener implements ActionListener {

    private JTextField amountToPayTextField;
    private TankFuelDialog tankFuelDialog;
    private MainFrame mainFrame;
    private CustomLabel currentFuelLabel;
    private CustomLabel destroyMessageLabel;
    private CustomButton tankFuelButton;
    private int dispenserID;

    public TankFuelDialogPayForFuelButtonActionListener(JTextField amountToPayTextField, TankFuelDialog tankFuelDialog,
            MainFrame mainFrame, CustomLabel currentFuelLabel, CustomLabel destroyMessageLabel,
            CustomButton tankFuelButton, int dispenserID) {
        this.amountToPayTextField = amountToPayTextField;
        this.tankFuelDialog = tankFuelDialog;
        this.mainFrame = mainFrame;
        this.currentFuelLabel = currentFuelLabel;
        this.destroyMessageLabel = destroyMessageLabel;
        this.tankFuelButton = tankFuelButton;
        this.dispenserID = dispenserID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            float enterAmountToPay = Float.parseFloat(amountToPayTextField.getText());
            mainFrame.debugSout("Podana wartość: " + enterAmountToPay);
            try {
                float amountToPay = mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().getAmountToPay();
                mainFrame.getPerson().getCurentDispenser().getCashRegister().payForFuel(amountToPay, enterAmountToPay);

                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().setName(mainFrame.getPerson().getName());

                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter()
                        .setSurname(mainFrame.getPerson().getSurname());

                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().setEnterAmountToPay(enterAmountToPay);

                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter()
                        .setRest(Utils.roundToTwoDigits(enterAmountToPay - amountToPay));

                ((Client) mainFrame.getPerson())
                        .tank(mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().getAmountOfFuel());
                currentFuelLabel
                        .setText("Ilość paliwa: " + mainFrame.getPerson().getCurentDispenser().getCurrentFuel() + " l");
                mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().printReceipt();
                tankFuelDialog.setVisible(false);

                try {
                    mainFrame.getPerson().getCurentDispenser().checkActive();
                } catch (InActiveDispenserException e1) {
                    destroyMessageLabel.setVisible(true);
                    destroyMessageLabel.setText(e1.getMessage());
                } catch (InActiveCashRegisterException e1) {
                    destroyMessageLabel.setVisible(true);
                    destroyMessageLabel.setText(e1.getMessage());
                } catch (InActiveReciptPrinterException e1) {
                    destroyMessageLabel.setVisible(true);
                    destroyMessageLabel.setText(e1.getMessage());
                }
                Payment payment = new Payment(mainFrame.getPerson().getName(),
                        mainFrame.getPerson().getSurname(),
                        mainFrame.getPerson().getCurentDispenser().getType(),
                        amountToPay, enterAmountToPay, Utils.roundToTwoDigits(enterAmountToPay - amountToPay),
                        mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().getAmountOfFuel(),
                        dispenserID);
                PaymentsSingleton.getInstance().addPayment(payment);
                mainFrame.getPerson().getCurentDispenser().addPayment(payment);

                new ReceiptDialog(mainFrame, tankFuelDialog, mainFrame.getPerson().getName(),
                        mainFrame.getPerson().getSurname(),
                        mainFrame.getPerson().getCurentDispenser().getType(),
                        amountToPay, enterAmountToPay, Utils.roundToTwoDigits(enterAmountToPay - amountToPay),
                        mainFrame.getPerson().getCurentDispenser().getReceiptPrinter().getAmountOfFuel(),
                        tankFuelButton);

            } catch (PaymentFailedException exc) {
                JOptionPane.showMessageDialog(tankFuelDialog, exc.getMessage(),
                        "Płatność się nie udała",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(tankFuelDialog,
                    "Podałeś złą wartość kwoty(zły format liczby)", "Błędna wartość",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(tankFuelDialog, "Nie podałeś żadnej kwoty",
                    "Błędna wartość",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
