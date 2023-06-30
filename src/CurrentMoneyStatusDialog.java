import java.awt.GridLayout;

import javax.swing.JDialog;

public class CurrentMoneyStatusDialog extends JDialog {
    private CustomLabel cashRegisterStatusLabel;
    private CustomLabel[] priceLabels;
    private CustomButton resetMoneyButton;

    public CurrentMoneyStatusDialog(MainFrame mainFrame) {
        super(mainFrame, "Informacje o kasie fiskalnej");
        setLocationRelativeTo(mainFrame);
        setLayout(new GridLayout(15, 1, 5, 5));
        setUI(mainFrame);
        addActionListeners(mainFrame);
        pack();
        setVisible(true);
    }

    private void setUI(MainFrame mainFrame) {
        cashRegisterStatusLabel = new CustomLabel(ColorSingleton.getInstance().getRed());
        if (mainFrame.getPerson().getCurentDispenser().getCashRegister().isActive()) {
            cashRegisterStatusLabel.setText("Kasa fiskalna działa");
        } else {
            cashRegisterStatusLabel.setText("Kasa fiskalna nie działa");
        }
        add(cashRegisterStatusLabel);
        priceLabels = new CustomLabel[13];
        int i = 0;
        for (String info : mainFrame.getPerson().getCurentDispenser().getCashRegister().getCurrentMoneyStatus()) {
            priceLabels[i] = new CustomLabel(info);
            add(priceLabels[i]);
            i++;
        }
        resetMoneyButton = new CustomButton("Napełnij kasę fiskalną");
        add(resetMoneyButton);
    }

    private void addActionListeners(MainFrame mainFrame) {
        resetMoneyButton.addActionListener(new ResetMoneyActionListener(mainFrame, this));
    }

    public void resetLabels(MainFrame mainFrame) {
        int i = 0;
        for (String info : mainFrame.getPerson().getCurentDispenser().getCashRegister().getCurrentMoneyStatus()) {
            priceLabels[i].setText(info);
            i++;
        }
    }
}
