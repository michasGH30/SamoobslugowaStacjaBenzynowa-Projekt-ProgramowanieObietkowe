
import javax.swing.JDialog;

import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFuelDialog extends JDialog {
    private CustomLabel pricePerLitrLabel;
    private JTextField fuelAmountTextField;
    private CustomLabel typeOfFuelLabel;
    private CustomLabel amountToPayLabel;
    private CustomLabel currentFuelLabel;
    private JTextField amountToPayTextField;
    private CustomButton calculateAmountToPayButton;
    private CustomButton payForFuelButton;
    private CustomLabel enterAmountOfFuelLabel;
    private CustomLabel enterAmountOfPayLabel;

    public TankFuelDialog(MainFrame mainFrame, CustomLabel currentFuelLabel, CustomLabel destroyMessageLabel,
            CustomButton tankFuelButton, int dispenserID) {
        super(mainFrame, "Zatankuj i zapłać za paliwo");
        mainFrame.getDispensersPanel().lockButtons(false);
        setLayout(new GridLayout(13, 1, 10, 10));
        setLocationRelativeTo(mainFrame);
        setUI(mainFrame);
        addActionListeners(mainFrame, currentFuelLabel, destroyMessageLabel, tankFuelButton, dispenserID);
        setVisible(true);
        pack();
    }

    private void setUI(MainFrame mainFrame) {

        typeOfFuelLabel = new CustomLabel(mainFrame.getPerson().getCurentDispenser().getType());
        pricePerLitrLabel = new CustomLabel(
                "Cena za litr: " + mainFrame.getPerson().getCurentDispenser().getPricePerLitr() + " zł");
        currentFuelLabel = new CustomLabel(
                "Ilość paliwa w dystrybutorze: " + mainFrame.getPerson().getCurentDispenser().getCurrentFuel()
                        + " litrów");
        enterAmountOfFuelLabel = new CustomLabel("Wprowadź ilość paliwa:");
        fuelAmountTextField = new JTextField();
        fuelAmountTextField.setFont(FontSingleton.getInstance().getFont());
        calculateAmountToPayButton = new CustomButton("Oblicz koszt paliwa");
        amountToPayLabel = new CustomLabel("Kwota do zapłaty: 0.0 zł");
        enterAmountOfPayLabel = new CustomLabel("Wprowadź ilość pieniędzy.");
        amountToPayTextField = new JTextField();
        amountToPayTextField.setFont(FontSingleton.getInstance().getFont());
        payForFuelButton = new CustomButton("Zapłać");
        add(typeOfFuelLabel);
        add(pricePerLitrLabel);
        add(currentFuelLabel);
        add(enterAmountOfFuelLabel);
        add(fuelAmountTextField);
        add(calculateAmountToPayButton);
        add(amountToPayLabel);
        add(enterAmountOfPayLabel);
        add(amountToPayTextField);
        add(payForFuelButton);

        amountToPayTextField.setEnabled(false);
        payForFuelButton.setEnabled(false);
    }

    private void addActionListeners(MainFrame mainFrame, CustomLabel currentFuelLabel, CustomLabel destroyMessageLabel,
            CustomButton tankFuelButton, int dispenserID) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.debugSout("Tu jest obsługa zamykania okienka w TankFuelDialog");
                mainFrame.debugSout("Lock Buttons:");
                mainFrame.getDispensersPanel().lockButtons(true);
                mainFrame.debugSout("Ustawiam przycisk na true");
                tankFuelButton.setEnabled(true);
                mainFrame.debugSout("Sprawdzam przyciski po tankowaniu");
                mainFrame.getDispensersPanel().afterTankFuelCheck();
                mainFrame.pack();
            }
        });

        calculateAmountToPayButton
                .addActionListener(
                        new TankFuelDialogCalculateAmountToPayButtonActionListener(amountToPayLabel, payForFuelButton,
                                fuelAmountTextField, this, amountToPayTextField,
                                mainFrame));
        payForFuelButton.addActionListener(
                new TankFuelDialogPayForFuelButtonActionListener(amountToPayTextField, this, mainFrame,
                        currentFuelLabel, destroyMessageLabel, tankFuelButton, dispenserID));
    }
}
