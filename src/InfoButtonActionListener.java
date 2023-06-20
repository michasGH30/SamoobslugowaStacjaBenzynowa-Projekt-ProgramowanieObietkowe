import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoButtonActionListener implements ActionListener {

    private MainFrame mainFrame;

    public InfoButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new InfoDialog(mainFrame);
    }

}
