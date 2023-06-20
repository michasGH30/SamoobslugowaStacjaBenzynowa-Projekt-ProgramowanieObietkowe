import javax.swing.JTabbedPane;

public class DispensersPanel extends JTabbedPane {
    private DispenserPanel[] dispenserPanels;

    public DispensersPanel(MainFrame mainFrame) {
        super();
        dispenserPanels = new DispenserPanel[6];
        for (int i = 0; i < dispenserPanels.length; i++) {
            dispenserPanels[i] = new DispenserPanel(mainFrame, i);
            addTab("Dystrybutor " + (i + 1), dispenserPanels[i]);
        }
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
