import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ReceiptDialog extends JDialog {
    private JLabel nameLabelDescription;
    private JLabel nameLabel;

    private JLabel surnameLabelDescription;
    private JLabel surnameLabel;

    private JLabel typeOfFuelDescription;
    private JLabel typeOfFuel;

    private JLabel amountOfFuelDescription;
    private JLabel amountOfFuel;

    private JLabel amountToPayDescription;
    private JLabel amountToPay;

    private JLabel enterAmountToPayDescription;
    private JLabel enterAmountToPay;

    private JLabel restLabelDescription;
    private JLabel restLabel;

    public ReceiptDialog(MainFrame mainFrame, TankFuelDialog owner, String name, String surname, String typeOfFuelVal,
            float amountToPayVal,
            float enterAmountToPay, float rest, float amountOfFuelVal, JButton tankFuelButton) {
        super(owner, "Paragon");
        setLayout(new GridLayout(7, 2, 10, 10));
        setLocationRelativeTo(null);
        setUI(name, surname, typeOfFuelVal, amountToPayVal, enterAmountToPay, rest, amountOfFuelVal);
        addActionListeners(mainFrame, tankFuelButton);
        pack();
        setVisible(true);
    }

    private void setUI(String name, String surname, String typeOfFuelVal, float amountToPayVal,
            float enterAmountToPayVal, float rest, float amountOfFuelVal) {

        nameLabelDescription = new JLabel("Imie:");
        nameLabelDescription.setFont(FontSingleton.getInstance().getFont());
        nameLabelDescription.setForeground(ColorSingleton.getInstance().getRed());

        nameLabel = new JLabel(name);
        nameLabel.setFont(FontSingleton.getInstance().getFont());

        surnameLabelDescription = new JLabel("Nazwisko");
        surnameLabelDescription.setFont(FontSingleton.getInstance().getFont());
        surnameLabelDescription.setForeground(ColorSingleton.getInstance().getRed());

        surnameLabel = new JLabel(surname);
        surnameLabel.setFont(FontSingleton.getInstance().getFont());

        typeOfFuelDescription = new JLabel("Typ paliwa:");
        typeOfFuelDescription.setFont(FontSingleton.getInstance().getFont());
        typeOfFuelDescription.setForeground(ColorSingleton.getInstance().getRed());

        typeOfFuel = new JLabel(typeOfFuelVal);
        typeOfFuel.setFont(FontSingleton.getInstance().getFont());

        amountOfFuelDescription = new JLabel("Zatankowano:");
        amountOfFuelDescription.setFont(FontSingleton.getInstance().getFont());
        amountOfFuelDescription.setForeground(ColorSingleton.getInstance().getRed());

        amountOfFuel = new JLabel(amountOfFuelVal + " l");
        amountOfFuel.setFont(FontSingleton.getInstance().getFont());

        amountToPayDescription = new JLabel("Do zapłaty:");
        amountToPayDescription.setFont(FontSingleton.getInstance().getFont());
        amountToPayDescription.setForeground(ColorSingleton.getInstance().getRed());

        amountToPay = new JLabel(amountToPayVal + "zł");
        amountToPay.setFont(FontSingleton.getInstance().getFont());

        enterAmountToPayDescription = new JLabel("Zapłacono:");
        enterAmountToPayDescription.setFont(FontSingleton.getInstance().getFont());
        enterAmountToPayDescription.setForeground(ColorSingleton.getInstance().getRed());

        enterAmountToPay = new JLabel(enterAmountToPayVal + "zł");
        enterAmountToPay.setFont(FontSingleton.getInstance().getFont());

        restLabelDescription = new JLabel("Reszta:");
        restLabelDescription.setFont(FontSingleton.getInstance().getFont());
        restLabelDescription.setForeground(ColorSingleton.getInstance().getRed());

        restLabel = new JLabel(rest + "zł");
        restLabel.setFont(FontSingleton.getInstance().getFont());

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

    private void addActionListeners(MainFrame mainFrame, JButton tankFuelButton) {
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
