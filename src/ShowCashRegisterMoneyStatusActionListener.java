import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCashRegisterMoneyStatusActionListener implements ActionListener {

    private MainFrame mainFrame;

    public ShowCashRegisterMoneyStatusActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new CurrentMoneyStatusDialog(mainFrame);
    }

}
