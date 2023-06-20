import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EmployeeLoginPanelLoginActionListener implements ActionListener {

    private EmployeeLoginPanel employeeLoginPanel;
    private MainFrame mainFrame;

    public EmployeeLoginPanelLoginActionListener(EmployeeLoginPanel employeeLoginPanel, MainFrame mainFrame) {
        this.employeeLoginPanel = employeeLoginPanel;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.setPerson(new Employee());
        String enteredPassword = new String(employeeLoginPanel.getPasswordField().getPassword());
        String correctPassword = "employee";
        mainFrame.debugSout("enter: " + enteredPassword);
        mainFrame.debugSout("correct: " + correctPassword);
        if (correctPassword.equals(enteredPassword)) {
            mainFrame.debugSout("Poprawne hasło.");

            for (DispenserPanel dispenserPanel : mainFrame.getDispensersPanel().getDispenserPanels()) {
                dispenserPanel.resetButtons();
                dispenserPanel.setClientButtonsVisibility(false);
                dispenserPanel.setEmployeeButtonsVisibility(true);
            }
            mainFrame.getDispensersPanel().resetButtons();
            mainFrame.getDispensersPanel().setDisableButtons(-1, -1);
            mainFrame.setMainFrameVisibility(false);
            mainFrame.setEmployeeLoginPanelVisibility(false);
            mainFrame.setStartMenuVisibility(false);
            new NameSurnameDialog(mainFrame);
        } else {
            mainFrame.debugSout("Niepoprawne hasło.");
            JOptionPane.showMessageDialog(employeeLoginPanel, "Podałeś złe hasło", "Złe hasło",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
