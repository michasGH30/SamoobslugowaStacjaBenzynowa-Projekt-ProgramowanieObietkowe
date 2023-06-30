import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class ReceiptDialog extends JDialog {
    private CustomLabel nameLabelDescription;
    private CustomLabel nameLabel;

    private CustomLabel surnameLabelDescription;
    private CustomLabel surnameLabel;

    private CustomLabel typeOfFuelDescription;
    private CustomLabel typeOfFuel;

    private CustomLabel amountOfFuelDescription;
    private CustomLabel amountOfFuel;

    private CustomLabel amountToPayDescription;
    private CustomLabel amountToPay;

    private CustomLabel enterAmountToPayDescription;
    private CustomLabel enterAmountToPay;

    private CustomLabel restLabelDescription;
    private CustomLabel restLabel;

    public ReceiptDialog(MainFrame mainFrame, TankFuelDialog owner, String name, String surname, String typeOfFuelVal,
            float amountToPayVal,
            float enterAmountToPay, float rest, float amountOfFuelVal, CustomButton tankFuelButton) {
        super(owner, "Paragon");
        setLayout(new GridLayout(7, 2, 10, 10));
        setLocationRelativeTo(mainFrame);
        setUI(name, surname, typeOfFuelVal, amountToPayVal, enterAmountToPay, rest, amountOfFuelVal);
        addActionListeners(mainFrame, tankFuelButton);
        pack();
        setVisible(true);
    }

    private void setUI(String name, String surname, String typeOfFuelVal, float amountToPayVal,
            float enterAmountToPayVal, float rest, float amountOfFuelVal) {

        nameLabelDescription = new CustomLabel("Imie:", ColorSingleton.getInstance().getRed());

        nameLabel = new CustomLabel(name);

        surnameLabelDescription = new CustomLabel("Nazwisko", ColorSingleton.getInstance().getRed());

        surnameLabel = new CustomLabel(surname);

        typeOfFuelDescription = new CustomLabel("Typ paliwa:", ColorSingleton.getInstance().getRed());

        typeOfFuel = new CustomLabel(typeOfFuelVal);

        amountOfFuelDescription = new CustomLabel("Zatankowano:", ColorSingleton.getInstance().getRed());

        amountOfFuel = new CustomLabel(amountOfFuelVal + " l");

        amountToPayDescription = new CustomLabel("Do zapłaty:", ColorSingleton.getInstance().getRed());

        amountToPay = new CustomLabel(amountToPayVal + "zł");

        enterAmountToPayDescription = new CustomLabel("Zapłacono:", ColorSingleton.getInstance().getRed());

        enterAmountToPay = new CustomLabel(enterAmountToPayVal + "zł");

        restLabelDescription = new CustomLabel("Reszta:", ColorSingleton.getInstance().getRed());

        restLabel = new CustomLabel(rest + "zł");

        add(nameLabelDescription);
        add(nameLabel);
        add(surnameLabelDescription);
        add(surnameLabel);
        add(typeOfFuelDescription);
        add(typeOfFuel);
        add(amountOfFuelDescription);
        add(amountOfFuel);
        add(amountToPayDescription);
        add(amountToPay);
        add(enterAmountToPayDescription);
        add(enterAmountToPay);
        add(restLabelDescription);
        add(restLabel);
    }

    private void addActionListeners(MainFrame mainFrame, CustomButton tankFuelButton) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.debugSout("Tu jest obsługa zamykania okienka w ReciptDialog");
                mainFrame.debugSout("Lock Buttons:");
                mainFrame.getDispensersPanel().lockButtons(true);
                mainFrame.debugSout("Ustawiam przycisk na true");
                tankFuelButton.setEnabled(true);
                mainFrame.debugSout("Sprawdzam przyciski po tankowaniu");
                mainFrame.getDispensersPanel().afterTankFuelCheck();
                mainFrame.pack();
            }
        });
    }
}
