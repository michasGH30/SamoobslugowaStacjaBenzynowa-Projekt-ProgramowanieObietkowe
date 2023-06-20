import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuEmployeeButtonActionListener implements ActionListener {

    private MainFrame mainFrame;

    public StartMenuEmployeeButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.debugSout("Pracownik");
        mainFrame.setMainFrameVisibility(false);
        mainFrame.setStartMenuVisibility(false);
        mainFrame.setEmployeeLoginPanelVisibility(true);
    }

}
