import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
    private JButton infoButton;
    private JLabel descriptionLabel;
    private JButton backButton;

    public BottomPanel(MainFrame mainFrame) {
        super();
        setLayout(new FlowLayout());
        setUI();
        addActionListeners(mainFrame);
    }

    private void setUI() {
        infoButton = new JButton("Info");
        infoButton.setFont(FontSingleton.getInstance().getSmallerFont());
        infoButton.setCursor(CursorSingleton.getInstance().getHandCursor());
        descriptionLabel = new JLabel("Wykonał Michał Żuk");
        descriptionLabel.setFont(FontSingleton.getInstance().getBolderFont());
        backButton = new JButton("Powrót");
        backButton.setFont(FontSingleton.getInstance().getSmallerFont());
        backButton.setCursor(CursorSingleton.getInstance().getHandCursor());
        add(infoButton);
        add(descriptionLabel);
        add(backButton);
    }

    private void addActionListeners(MainFrame mainFrame) {
        backButton.addActionListener(new BackButtonActionListener(mainFrame));
        infoButton.addActionListener(new InfoButtonActionListener(mainFrame));
    }
}
