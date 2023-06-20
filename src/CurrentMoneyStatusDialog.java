import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class CurrentMoneyStatusDialog extends JDialog {
    private JLabel cashRegisterStatusLabel;
    private JLabel[] priceLabels;
    private JButton resetMoneyButton;

    public CurrentMoneyStatusDialog(MainFrame mainFrame) {
        super(mainFrame, "Informacje o kasie fiskalnej");
        setLocationRelativeTo(null);
        setLayout(new GridLayout(15, 1, 5, 5));
        setUI(mainFrame);
        addActionListeners(mainFrame);
        pack();
        setVisible(true);
    }

    private void setUI(MainFrame mainFrame) {
        cashRegisterStatusLabel = new JLabel();
        cashRegisterStatusLabel.setFont(FontSingleton.getInstance().getFont());
        if (mainFrame.getPerson().getCurentDispenser().getCashRegister().isActive()) {
            cashRegisterStatusLabel.setText("Kasa fiskalna działa");
        } else {
            cashRegisterStatusLabel.setText("Kasa fiskalna nie działa");
            cashRegisterStatusLabel.setForeground(ColorSingleton.getInstance().getRed());
        }
        add(cashRegisterStatusLabel);
        priceLabels = new JLabel[13];
        int i = 0;
        for (String info : mainFrame.getPerson().getCurentDispenser().getCashRegister().getCurrentMoneyStatus()) {
            priceLabels[i] = new JLabel(info);
            priceLabels[i].setFont(FontSingleton.getInstance().getFont());
            add(priceLabels[i]);
            i++;
        }
        resetMoneyButton = new JButton("Napełnij kasę fiskalną");
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
