import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePriceFuelActionListener implements ActionListener {

    private CustomLabel fuelPriceLabel;
    private MainFrame mainFrame;

    public ChangePriceFuelActionListener(MainFrame mainFrame, CustomLabel fuelPriceLabel) {
        this.mainFrame = mainFrame;
        this.fuelPriceLabel = fuelPriceLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ChangeFuelPriceDialog(mainFrame, fuelPriceLabel);
    }

}
