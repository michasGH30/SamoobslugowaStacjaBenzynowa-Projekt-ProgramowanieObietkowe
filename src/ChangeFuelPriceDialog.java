import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeFuelPriceDialog extends JDialog {
    private JLabel enterNewPriceLabel;
    private JLabel oldPriceLabel;
    private JTextField enterNewPriceTextField;
    private JButton enterNewPriceButton;

    public ChangeFuelPriceDialog(MainFrame mainFrame, JLabel fuelPriceLabel) {
        super(mainFrame, "Modyfikuj cenę paliwa");
        setLayout(new GridLayout(4, 1, 5, 5));
        setLocationRelativeTo(null);
        setUI(mainFrame);
        addActionListeners(mainFrame, fuelPriceLabel);
        setSize(300, 300);
        setVisible(true);
    }

    private void setUI(MainFrame mainFrame) {
        oldPriceLabel = new JLabel(
                "Stara cena: " + mainFrame.getPerson().getCurentDispenser().getPricePerLitr() + " zł");
        oldPriceLabel.setFont(FontSingleton.getInstance().getFont());
        enterNewPriceLabel = new JLabel("Podaj nową cenę:");
        enterNewPriceLabel.setFont(FontSingleton.getInstance().getFont());
        enterNewPriceTextField = new JTextField();
        enterNewPriceTextField.setFont(FontSingleton.getInstance().getFont());
        enterNewPriceButton = new JButton("Zmień cenę");
        enterNewPriceButton.setFont(FontSingleton.getInstance().getSmallerFont());
        add(oldPriceLabel);
        add(enterNewPriceLabel);
        add(enterNewPriceTextField);
        add(enterNewPriceButton);
    }

    private void addActionListeners(MainFrame mainFrame, JLabel fuelPriceLabel) {
        enterNewPriceButton.addActionListener(
                new ChangeFuelPriceDialogActionListener(this, mainFrame, enterNewPriceTextField, fuelPriceLabel));
    }
}
