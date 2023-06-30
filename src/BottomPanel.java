import java.awt.FlowLayout;

import javax.swing.JPanel;

public class BottomPanel extends JPanel {
    private CustomButton infoButton;
    private CustomLabel descriptionLabel;
    private CustomButton backButton;
    private CustomButton allPaymentsButton;

    public BottomPanel(MainFrame mainFrame) {
        super();
        setLayout(new FlowLayout());
        setUI();
        addActionListeners(mainFrame);
    }

    private void setUI() {
        infoButton = new CustomButton("Info", FontSingleton.getInstance().getSmallerFont());
        descriptionLabel = new CustomLabel("Wykonał Michał Żuk", FontSingleton.getInstance().getBolderFont());
        backButton = new CustomButton("Powrót");
        allPaymentsButton = new CustomButton("Pokaż wszystkie płatności");
        add(infoButton);
        add(descriptionLabel);
        add(backButton);
        add(allPaymentsButton);
    }

    private void addActionListeners(MainFrame mainFrame) {
        backButton.addActionListener(new BackButtonActionListener(mainFrame));
        infoButton.addActionListener(new InfoButtonActionListener(mainFrame));
        allPaymentsButton.addActionListener(new ShowDispenserPaymentsButtonActionListener(mainFrame, false));
    }

    public void setAllPaymentsButtonVisibility(boolean visible) {
        allPaymentsButton.setVisible(visible);
    }
}
