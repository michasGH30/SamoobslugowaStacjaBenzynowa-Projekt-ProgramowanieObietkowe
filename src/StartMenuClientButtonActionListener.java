import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuClientButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private DispensersPanel dispensersPanel;

    public StartMenuClientButtonActionListener(MainFrame mainFrame, DispensersPanel dispensersPanel) {
        this.mainFrame = mainFrame;
        this.dispensersPanel = dispensersPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.debugSout("Klient");
        mainFrame.setPerson(new Client());
        mainFrame.setMainFrameVisibility(false);
        for (DispenserPanel dispenserPanel : dispensersPanel.getDispenserPanels()) {
            dispenserPanel.resetButtons();
            dispenserPanel.setClientButtonsVisibility(true);
            dispenserPanel.setEmployeeButtonsVisibility(false);
        }
        mainFrame.getBottomPanel().setAllPaymentsButtonVisibility(false);
        dispensersPanel.resetButtons();
        dispensersPanel.setDisableButtons(-1, -1);
        dispensersPanel.afterTankFuelCheck();
        mainFrame.setStartMenuVisibility(false);
        mainFrame.setEmployeeLoginPanelVisibility(false);
        new NameSurnameDialog(mainFrame);
    }

}
