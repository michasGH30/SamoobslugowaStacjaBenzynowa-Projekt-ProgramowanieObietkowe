import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ResetMoneyActionListener implements ActionListener {

    private MainFrame mainFrame;
    private CurrentMoneyStatusDialog currentMoneyStatusDialog;

    public ResetMoneyActionListener(MainFrame mainFrame, CurrentMoneyStatusDialog currentMoneyStatusDialog) {
        this.mainFrame = mainFrame;
        this.currentMoneyStatusDialog = currentMoneyStatusDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getPerson().getCurentDispenser().getCashRegister().setMoney();
        Component temp = mainFrame;
        if (currentMoneyStatusDialog != null) {
            temp = currentMoneyStatusDialog;
            currentMoneyStatusDialog.resetLabels(mainFrame);
        }
        JOptionPane.showMessageDialog(temp, "Pomyślnie uzupełniono kasę fiskalną", "Uzupełnienie Kasy Fiskalnej",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
