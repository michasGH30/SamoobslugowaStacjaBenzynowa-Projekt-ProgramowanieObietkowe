import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TankFuelButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private CustomLabel currentFuelLabel;
    private CustomLabel destroyMessageLabel;
    private CustomButton tankFuelButton;
    private int dispenserID;

    public TankFuelButtonActionListener(MainFrame mainFrame, CustomLabel currentFuelLabel,
            CustomLabel destroyMessageLabel,
            CustomButton tankFuelButton, int dispenserID) {
        this.mainFrame = mainFrame;
        this.currentFuelLabel = currentFuelLabel;
        this.destroyMessageLabel = destroyMessageLabel;
        this.tankFuelButton = tankFuelButton;
        this.dispenserID = dispenserID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tankFuelButton.setEnabled(false);
        new TankFuelDialog(mainFrame, currentFuelLabel, destroyMessageLabel, tankFuelButton, dispenserID);
    }

}
