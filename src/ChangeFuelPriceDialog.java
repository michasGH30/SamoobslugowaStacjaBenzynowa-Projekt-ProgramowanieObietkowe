import java.awt.GridLayout;

import javax.swing.JDialog;

import javax.swing.JTextField;

public class ChangeFuelPriceDialog extends JDialog {
    private CustomLabel enterNewPriceLabel;
    private CustomLabel oldPriceLabel;
    private JTextField enterNewPriceTextField;
    private CustomButton enterNewPriceButton;

    public ChangeFuelPriceDialog(MainFrame mainFrame, CustomLabel fuelPriceLabel) {
        super(mainFrame, "Modyfikuj cenę paliwa");
        setLayout(new GridLayout(4, 1, 5, 5));
        setLocationRelativeTo(mainFrame);
        setUI(mainFrame);
        addActionListeners(mainFrame, fuelPriceLabel);
        setSize(300, 300);
        setVisible(true);
    }

    private void setUI(MainFrame mainFrame) {
        oldPriceLabel = new CustomLabel(
                "Stara cena: " + mainFrame.getPerson().getCurentDispenser().getPricePerLitr() + " zł");
        enterNewPriceLabel = new CustomLabel("Podaj nową cenę:");
        enterNewPriceTextField = new JTextField();
        enterNewPriceTextField.setFont(FontSingleton.getInstance().getFont());
        enterNewPriceButton = new CustomButton("Zmień cenę");
        add(oldPriceLabel);
        add(enterNewPriceLabel);
        add(enterNewPriceTextField);
        add(enterNewPriceButton);
    }

    private void addActionListeners(MainFrame mainFrame, CustomLabel fuelPriceLabel) {
        enterNewPriceButton.addActionListener(
                new ChangeFuelPriceDialogActionListener(this, mainFrame, enterNewPriceTextField, fuelPriceLabel));
    }
}
