import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseDispenserActionListener implements ActionListener {

    private MainFrame mainFrame;
    private int count;
    private DispenserPanel dispenserPanel;
    private Dispenser dispenser;

    public ChooseDispenserActionListener(MainFrame mainFrame, int count, DispenserPanel dispenserPanel,
            Dispenser dispenser) {
        this.mainFrame = mainFrame;
        this.count = count;
        this.dispenserPanel = dispenserPanel;
        this.dispenser = dispenser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.debugSout("Wybrano: " + count + ", z dystrybutora: " + dispenserPanel.getID());
        mainFrame.getDispensersPanel().setDisableButtons(dispenserPanel.getID(), count);
        mainFrame.getPerson().setCurentDispenser(dispenser);
    }

}
