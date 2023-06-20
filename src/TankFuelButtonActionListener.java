import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TankFuelButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private JLabel currentFuelLabel;
    private JLabel destroyMessageLabel;
    private JButton tankFuelButton;

    public TankFuelButtonActionListener(MainFrame mainFrame, JLabel currentFuelLabel, JLabel destroyMessageLabel,
            JButton tankFuelButton) {
        this.mainFrame = mainFrame;
        this.currentFuelLabel = currentFuelLabel;
        this.destroyMessageLabel = destroyMessageLabel;
        this.tankFuelButton = tankFuelButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tankFuelButton.setEnabled(false);
        new TankFuelDialog(mainFrame, currentFuelLabel, destroyMessageLabel, tankFuelButton);
    }

}
