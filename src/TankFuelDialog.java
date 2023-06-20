import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFuelDialog extends JDialog {
    private JLabel pricePerLitrLabel;
    private JTextField fuelAmountTextField;
    private JLabel typeOfFuelLabel;
    private JLabel amountToPayLabel;
    private JLabel currentFuelLabel;
    private JTextField amountToPayTextField;
    private JButton calculateAmountToPayButton;
    private JButton payForFuelButton;
    private JLabel enterAmountOfFuelLabel;
    private JLabel enterAmountOfPayLabel;

    public TankFuelDialog(MainFrame mainFrame, JLabel currentFuelLabel, JLabel destroyMessageLabel,
            JButton tankFuelButton) {
        super(mainFrame, "Zatankuj i zapłać za paliwo");
        mainFrame.getDispensersPanel().lockButtons(false);
        setLayout(new GridLayout(13, 1, 10, 10));
        setLocationRelativeTo(null);
        setUI(mainFrame);
        addActionListeners(mainFrame, currentFuelLabel, destroyMessageLabel, tankFuelButton);
        setVisible(true);
        pack();
    }

    private void setUI(MainFrame mainFrame) {

        typeOfFuelLabel = new JLabel(mainFrame.getPerson().getCurentDispenser().getType());
        typeOfFuelLabel.setFont(FontSingleton.getInstance().getFont());
        pricePerLitrLabel = new JLabel(
                "Cena za litr: " + mainFrame.getPerson().getCurentDispenser().getPricePerLitr() + " zł");
        pricePerLitrLabel.setFont(FontSingleton.getInstance().getFont());
        currentFuelLabel = new JLabel(
                "Ilość paliwa w dystrybutorze: " + mainFrame.getPerson().getCurentDispenser().getCurrentFuel()
                        + " litrów");
        currentFuelLabel.setFont(FontSingleton.getInstance().getFont());
        enterAmountOfFuelLabel = new JLabel("Wprowadź ilość paliwa:");
        enterAmountOfFuelLabel.setFont(FontSingleton.getInstance().getFont());
        fuelAmountTextField = new JTextField();
        fuelAmountTextField.setFont(FontSingleton.getInstance().getFont());
        calculateAmountToPayButton = new JButton("Oblicz koszt paliwa");
        calculateAmountToPayButton.setFont(FontSingleton.getInstance().getSmallerFont());
        amountToPayLabel = new JLabel("Kwota do zapłaty: 0.0 zł");
        amountToPayLabel.setFont(FontSingleton.getInstance().getFont());
        enterAmountOfPayLabel = new JLabel("Wprowadź ilość pieniędzy.");
        enterAmountOfPayLabel.setFont(FontSingleton.getInstance().getFont());
        amountToPayTextField = new JTextField();
        amountToPayTextField.setFont(FontSingleton.getInstance().getFont());
        payForFuelButton = new JButton("Zapłać");
        payForFuelButton.setFont(FontSingleton.getInstance().getSmallerFont());
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

    private void addActionListeners(MainFrame mainFrame, JLabel currentFuelLabel, JLabel destroyMessageLabel,
            JButton tankFuelButton) {
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
                        currentFuelLabel, destroyMessageLabel, tankFuelButton));
    }
}
