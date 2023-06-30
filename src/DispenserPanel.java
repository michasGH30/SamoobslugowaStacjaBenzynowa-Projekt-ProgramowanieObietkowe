import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class DispenserPanel extends JPanel {
    private Dispenser[] dispensers;

    private CustomLabel[] typeOfDistributorLabels;
    private CustomLabel[] pricesLabels;
    private CustomLabel[] currentFuelLabels;
    private CustomLabel[] destroyMessageLabels;
    private CustomButton[] tankFuelButtons;
    private CustomButton[] chooseDispenserButtons;
    private CustomButton[] repairDispenserButtons;
    private CustomButton[] refuelDispenserButtons;
    private CustomButton[] repairReciptPrinterButtons;
    private CustomButton[] repairCashRegisterButtons;
    private CustomButton[] changeFuelPriceButtons;
    private CustomButton[] resetMoneyButtons;
    private CustomButton[] showCurrentMoneyStatusButtons;
    private CustomButton[] showPaymentsButton;
    private int ID;

    public DispenserPanel(MainFrame mainFrame, int ID) {
        super();
        this.ID = ID;
        setLayout(new GridLayout(14, 3, 5, 5));
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

        typeOfDistributorLabels = new CustomLabel[3];
        pricesLabels = new CustomLabel[3];
        currentFuelLabels = new CustomLabel[3];
        destroyMessageLabels = new CustomLabel[3];
        tankFuelButtons = new CustomButton[3];
        chooseDispenserButtons = new CustomButton[3];
        repairDispenserButtons = new CustomButton[3];
        refuelDispenserButtons = new CustomButton[3];
        repairReciptPrinterButtons = new CustomButton[3];
        repairCashRegisterButtons = new CustomButton[3];
        changeFuelPriceButtons = new CustomButton[3];
        showCurrentMoneyStatusButtons = new CustomButton[3];
        resetMoneyButtons = new CustomButton[3];
        showPaymentsButton = new CustomButton[3];
        for (int i = 0; i < 3; i++) {
            typeOfDistributorLabels[i] = new CustomLabel(dispensers[i].getType());
            add(typeOfDistributorLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            pricesLabels[i] = new CustomLabel("Cena za litr: " + dispensers[i].getPricePerLitr() + " zł");
            add(pricesLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            currentFuelLabels[i] = new CustomLabel("Ilość paliwa: " + dispensers[i].getCurrentFuel() + " l");
            add(currentFuelLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            destroyMessageLabels[i] = new CustomLabel(ColorSingleton.getInstance().getRed());
            add(destroyMessageLabels[i]);
        }
        for (int i = 0; i < 3; i++) {
            chooseDispenserButtons[i] = new CustomButton("Wybierz dystrybutor");
            add(chooseDispenserButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            tankFuelButtons[i] = new CustomButton("Zatankuj paliwo");
            add(tankFuelButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            changeFuelPriceButtons[i] = new CustomButton("Zmień cenę paliwa");
            add(changeFuelPriceButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            refuelDispenserButtons[i] = new CustomButton("Napełnij dystrybutor do pełna");
            add(refuelDispenserButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            repairDispenserButtons[i] = new CustomButton("Napraw dystrybutor");
            add(repairDispenserButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            repairCashRegisterButtons[i] = new CustomButton("Napraw kasę fiskalną");
            add(repairCashRegisterButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            repairReciptPrinterButtons[i] = new CustomButton("Napraw drukarkę paragonów");
            add(repairReciptPrinterButtons[i]);
        }

        for (int i = 0; i < 3; i++) {
            showCurrentMoneyStatusButtons[i] = new CustomButton("Pokaż status kasy fiskalnej");
            add(showCurrentMoneyStatusButtons[i]);
        }

        for (int i = 0; i < 3; i++) {
            resetMoneyButtons[i] = new CustomButton("Napełnij kasę fiskalną");
            add(resetMoneyButtons[i]);
        }
        for (int i = 0; i < 3; i++) {
            showPaymentsButton[i] = new CustomButton("Pokaż płatności");
            add(showPaymentsButton[i]);
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
            showPaymentsButton[i].setVisible(visibility);
        }
    }

    private void addActionListeners(MainFrame mainFrame) {
        for (int i = 0; i < 3; i++) {
            chooseDispenserButtons[i]
                    .addActionListener(new ChooseDispenserActionListener(mainFrame, i, this, dispensers[i]));
            tankFuelButtons[i].addActionListener(
                    new TankFuelButtonActionListener(mainFrame, currentFuelLabels[i], destroyMessageLabels[i],
                            tankFuelButtons[i], i));
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
                    .addActionListener(new ShowCashRegisterMoneyStatusButtonActionListener(mainFrame));
            resetMoneyButtons[i].addActionListener(new ResetMoneyActionListener(mainFrame, null));
            showPaymentsButton[i].addActionListener(new ShowDispenserPaymentsButtonActionListener(mainFrame, true));
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
            showPaymentsButton[i].setEnabled(true);
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
                showPaymentsButton[i].setEnabled(false);
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
            showPaymentsButton[i].setEnabled(true);
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

    public CustomButton[] getChooseDispenserButtons() {
        return chooseDispenserButtons;
    }

    public int getID() {
        return ID;
    }
}
