import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCashRegisterMoneyStatusButtonActionListener implements ActionListener {

    private MainFrame mainFrame;

    public ShowCashRegisterMoneyStatusButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new CurrentMoneyStatusDialog(mainFrame);
    }

}
