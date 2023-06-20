import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ChangePriceFuelActionListener implements ActionListener {

    private JLabel fuelPriceLabel;
    private MainFrame mainFrame;

    public ChangePriceFuelActionListener(MainFrame mainFrame, JLabel fuelPriceLabel) {
        this.mainFrame = mainFrame;
        this.fuelPriceLabel = fuelPriceLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ChangeFuelPriceDialog(mainFrame, fuelPriceLabel);
    }

}
