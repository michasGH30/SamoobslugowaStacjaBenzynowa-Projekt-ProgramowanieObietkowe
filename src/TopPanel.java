import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
    private JLabel titleLabel;

    public TopPanel(MainFrame mainFrame) {
        super();
        setLayout(new FlowLayout());
        titleLabel = new JLabel("Samoobsługowa Stacja Benzynowa Pod Michałem");
        titleLabel.setFont(FontSingleton.getInstance().getBolderFont());
        add(titleLabel);
    }
}
