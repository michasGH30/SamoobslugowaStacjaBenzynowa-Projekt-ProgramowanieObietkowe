import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class RefuelDispenserButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private JLabel currentFuelLabel;

    public RefuelDispenserButtonActionListener(MainFrame mainFrame, JLabel currentFuelLabel) {
        this.mainFrame = mainFrame;
        this.currentFuelLabel = currentFuelLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getPerson().getCurentDispenser().refuel();
        currentFuelLabel.setText("Ilość paliwa: " + Dispenser.maxFuel + " l");
    }

}
