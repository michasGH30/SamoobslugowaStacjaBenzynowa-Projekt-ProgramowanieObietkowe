import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonActionListener implements ActionListener {

    private MainFrame mainFrame;

    public BackButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.debugSout("Back Panel Logowania");
        mainFrame.setMainFrameVisibility(false);
        mainFrame.setEmployeeLoginPanelVisibility(false);
        mainFrame.setStartMenuVisibility(true);
    }

}
