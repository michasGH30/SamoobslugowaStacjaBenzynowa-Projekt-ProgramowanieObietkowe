import java.awt.FlowLayout;

import javax.swing.JPanel;

public class DispensersPanel extends JPanel {
    private DispenserPanel[] dispenserPanels;

    public DispensersPanel(MainFrame mainFrame) {
        super();
        setLayout(new FlowLayout());
        dispenserPanels = new DispenserPanel[2];
        dispenserPanels[0] = new DispenserPanel(mainFrame, 0);
        dispenserPanels[1] = new DispenserPanel(mainFrame, 1);
        add(dispenserPanels[0]);
        add(dispenserPanels[1]);
    }

    public DispenserPanel[] getDispenserPanels() {
        return dispenserPanels;
    }

    public void setDisableButtons(int ID, int count) {
        for (DispenserPanel dispenserPanel : dispenserPanels) {
            dispenserPanel.setButtonsDisable(ID, count);
        }
    }

    public void resetButtons() {
        for (DispenserPanel dispenserPanel : dispenserPanels) {
            dispenserPanel.resetButtons();
        }
    }

    public void lockButtons(boolean lock) {
        for (DispenserPanel dispenserPanel : dispenserPanels) {
            dispenserPanel.lockButtons(lock);
        }
    }

    public void afterTankFuelCheck() {
        for (DispenserPanel dispenserPanel : dispenserPanels) {
            dispenserPanel.afterTankFuelCheck();
        }
    }
}
