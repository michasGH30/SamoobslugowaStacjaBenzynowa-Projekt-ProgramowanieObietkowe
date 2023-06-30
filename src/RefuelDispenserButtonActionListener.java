import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefuelDispenserButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private CustomLabel currentFuelLabel;

    public RefuelDispenserButtonActionListener(MainFrame mainFrame, CustomLabel currentFuelLabel) {
        this.mainFrame = mainFrame;
        this.currentFuelLabel = currentFuelLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getPerson().getCurentDispenser().refuel();
        currentFuelLabel.setText("Ilość paliwa: " + Dispenser.maxFuel + " l");
    }

}
