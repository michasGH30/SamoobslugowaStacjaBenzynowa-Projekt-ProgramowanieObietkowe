import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DispenserPanel extends JPanel {
    private Dispenser[] dispensers;

    private JLabel[] typeOfDistributorLabels;
    private JLabel[] pricesLabels;
    private JLabel[] currentFuelLabels;
    private JLabel[] destroyMessageLabels;
    private JButton[] tankFuelButtons;
    private JButton[] chooseDispenserButtons;
    private JButton[] repairDispenserButtons;
    private JButton[] refuelDispenserButtons;
    private JButton[] repairReciptPrinterButtons;
    private JButton[] repairCashRegisterButtons;
    private JButton[] changeFuelPriceButtons;
    private JButton[] resetMoneyButtons;
    private JButton[] showCurrentMoneyStatusButtons;
    private int ID;

    public DispenserPanel(MainFrame mainFrame, int ID) {
        super();
        this.ID = ID;
        setLayout(new GridLayout(13, 3, 5, 5));
        setDispensers();
        setUI();
        addActionListeners(mainFrame);
    }

    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += 100;
        return size;
    }

    private void setDispensers() {
        dispensers = new Dispenser[3];
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    dispensers[i] = new DieselDispenser();
                    break;
                case 1:
                    dispensers[i] = new PetrolDispenser();
                    break;
                case 2:
                    dispensers[i] = new GasDispenser();
                    break;
            }
        }
    }

    private void setUI() {

        typeOfDistributorLabels = new JLabel[3];
        pricesLabels = new JLabel[3];
        currentFuelLabels = new JLabel[3];
        destroyMessageLabels = new JLabel[3];
        tankFuelButtons = new JButton[3];
        chooseDispenserButtons = new JButton[3];
        repairDispenserButtons = new JButton[3];
        refuelDispenserButtons = new JButton[3];
        repairReciptPrinterButtons = new JButton[3];
        repairCashRegisterButtons = new JButton[3];
        changeFuelPriceButtons = new JButton[3];
        showCurrentMoneyStatusButtons = new JButton[3];
        resetMoneyButtons = new JButton[3];
        for (int i = 0; i < 3; i++) {
            typeOfDistributorLabels[i] = new JLabel(dispensers[i].getType());
            typeOfDistributorLabels[i].setFont(FontSingleton.getInstance().getFont());
            add(typeOfDistributorLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            pricesLabels[i] = new JLabel("Cena za litr: " + dispensers[i].getPricePerLitr() + " zł");
            pricesLabels[i].setFont(FontSingleton.getInstance().getFont());
            add(pricesLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            currentFuelLabels[i] = new JLabel("Ilość paliwa: " + dispensers[i].getCurrentFuel() + " l");
            currentFuelLabels[i].setFont(FontSingleton.getInstance().getFont());
            add(currentFuelLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            destroyMessageLabels[i] = new JLabel();
            destroyMessageLabels[i].setFont(FontSingleton.getInstance().getFont());
            destroyMessageLabels[i].setForeground(ColorSingleton.getInstance().getRed());
            add(destroyMessageLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            chooseDispenserButtons[i] = new JButton("Wybierz dystrybutor");
            chooseDispenserButtons[i].setMargin(new Insets(15, 25, 15, 25));
            chooseDispenserButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            chooseDispenserButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(chooseDispenserButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            tankFuelButtons[i] = new JButton("Zatankuj paliwo");
            tankFuelButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            tankFuelButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(tankFuelButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            changeFuelPriceButtons[i] = new JButton("Zmień cenę paliwa");
            changeFuelPriceButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            changeFuelPriceButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(changeFuelPriceButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            refuelDispenserButtons[i] = new JButton("Napełnij dystrybutor do pełna");
            refuelDispenserButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            refuelDispenserButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(refuelDispenserButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            repairDispenserButtons[i] = new JButton("Napraw dystrybutor");
            repairDispenserButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            repairDispenserButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(repairDispenserButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            repairCashRegisterButtons[i] = new JButton("Napraw kasę fiskalną");
            repairCashRegisterButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            repairCashRegisterButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(repairCashRegisterButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            repairReciptPrinterButtons[i] = new JButton("Napraw drukarkę paragonów");
            repairReciptPrinterButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            repairReciptPrinterButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(repairReciptPrinterButtons[i]);
        }

        for (int i = 0; i < 3; i++) {
            showCurrentMoneyStatusButtons[i] = new JButton("Pokaż status kasy fiskalnej");
            showCurrentMoneyStatusButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            showCurrentMoneyStatusButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(showCurrentMoneyStatusButtons[i]);
        }

        for (int i = 0; i < 3; i++) {
            resetMoneyButtons[i] = new JButton("Napełnij kasę fiskalną");
            resetMoneyButtons[i].setCursor(CursorSingleton.getInstance().getHandCursor());
            resetMoneyButtons[i].setFont(FontSingleton.getInstance().getSmallerFont());
            add(resetMoneyButtons[i]);
        }

    }

    public void setClientButtonsVisibility(boolean visbility) {
        for (int i = 0; i < 3; i++) {
            tankFuelButtons[i].setVisible(visbility);
        }
    }

    public void setEmployeeButtonsVisibility(boolean visibility) {
        for (int i = 0; i < 3; i++) {
            refuelDispenserButtons[i].setVisible(visibility);
            repairDispenserButtons[i].setVisible(visibility);
            repairReciptPrinterButtons[i].setVisible(visibility);
            repairCashRegisterButtons[i].setVisible(visibility);
            changeFuelPriceButtons[i].setVisible(visibility);
            showCurrentMoneyStatusButtons[i].setVisible(visibility);
            resetMoneyButtons[i].setVisible(visibility);
        }
    }

    private void addActionListeners(MainFrame mainFrame) {
        for (int i = 0; i < 3; i++) {
            chooseDispenserButtons[i]
                    .addActionListener(new ChooseDispenserActionListener(mainFrame, i, this, dispensers[i]));
            tankFuelButtons[i].addActionListener(
                    new TankFuelButtonActionListener(mainFrame, currentFuelLabels[i], destroyMessageLabels[i],
                            tankFuelButtons[i]));
            refuelDispenserButtons[i]
                    .addActionListener(new RefuelDispenserButtonActionListener(mainFrame, currentFuelLabels[i]));
            changeFuelPriceButtons[i]
                    .addActionListener(new ChangePriceFuelActionListener(mainFrame, pricesLabels[i]));
            repairDispenserButtons[i]
                    .addActionListener(new RepairDispenserButtonActionListener(mainFrame, destroyMessageLabels[i]));
            repairCashRegisterButtons[i]
                    .addActionListener(new RepairCashRegisterButtonActionListener(mainFrame, destroyMessageLabels[i]));
            repairReciptPrinterButtons[i]
                    .addActionListener(new RepairReciptPrinterButtonActionListener(mainFrame, destroyMessageLabels[i]));
            showCurrentMoneyStatusButtons[i]
                    .addActionListener(new ShowCashRegisterMoneyStatusActionListener(mainFrame));
            resetMoneyButtons[i].addActionListener(new ResetMoneyActionListener(mainFrame, null));
        }
    }

    public void setButtonsDisable(int ID, int count) {
        for (int i = 0; i < 3; i++) {
            tankFuelButtons[i].setEnabled(true);
            repairDispenserButtons[i].setEnabled(true);
            refuelDispenserButtons[i].setEnabled(true);
            repairReciptPrinterButtons[i].setEnabled(true);
            repairCashRegisterButtons[i].setEnabled(true);
            changeFuelPriceButtons[i].setEnabled(true);
            showCurrentMoneyStatusButtons[i].setEnabled(true);
            resetMoneyButtons[i].setEnabled(true);
        }
        for (int i = 0; i < 3; i++) {
            if (!(this.ID == ID && count == i)) {
                tankFuelButtons[i].setEnabled(false);
                repairDispenserButtons[i].setEnabled(false);
                refuelDispenserButtons[i].setEnabled(false);
                repairReciptPrinterButtons[i].setEnabled(false);
                repairCashRegisterButtons[i].setEnabled(false);
                changeFuelPriceButtons[i].setEnabled(false);
                showCurrentMoneyStatusButtons[i].setEnabled(false);
                resetMoneyButtons[i].setEnabled(false);
            }
        }

    }

    public void resetButtons() {
        for (int i = 0; i < 3; i++) {
            chooseDispenserButtons[i].setEnabled(true);
            tankFuelButtons[i].setEnabled(true);
            repairDispenserButtons[i].setEnabled(true);
            refuelDispenserButtons[i].setEnabled(true);
            repairReciptPrinterButtons[i].setEnabled(true);
            repairCashRegisterButtons[i].setEnabled(true);
            changeFuelPriceButtons[i].setEnabled(true);
            showCurrentMoneyStatusButtons[i].setEnabled(true);
            resetMoneyButtons[i].setEnabled(true);
        }
    }

    public void lockButtons(boolean lock) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Dla " + getID() + ", panelu ustawiam wybieranie dystrybutora " + i + " na: " + lock);
            chooseDispenserButtons[i].setEnabled(lock);
        }
    }

    public void afterTankFuelCheck() {
        for (int i = 0; i < 3; i++) {
            if (!isDispenserActive(i)) {
                System.out.println("W " + getID() + ", panelu dystrybutor " + i
                        + " nie działa, ustawiam wybieranie i tankowanie na false");
                chooseDispenserButtons[i].setEnabled(false);
                tankFuelButtons[i].setEnabled(false);
            }
        }

    }

    public boolean isDispenserActive(int i) {

        if (!dispensers[i].isActive() || !dispensers[i].getCashRegister().isActive()
                || !dispensers[i].getReceiptPrinter().isActive()) {
            return false;
        }
        return true;

    }

    public JButton[] getChooseDispenserButtons() {
        return chooseDispenserButtons;
    }

    public int getID() {
        return ID;
    }
}
