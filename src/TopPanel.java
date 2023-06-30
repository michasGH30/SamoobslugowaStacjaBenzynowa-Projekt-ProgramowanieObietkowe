import java.awt.FlowLayout;

import javax.swing.JPanel;

public class TopPanel extends JPanel {
    private CustomLabel titleLabel;

    public TopPanel(MainFrame mainFrame) {
        super();
        setLayout(new FlowLayout());
        titleLabel = new CustomLabel("Samoobsługowa Stacja Benzynowa Pod Michałem",
                FontSingleton.getInstance().getBolderFont());
        add(titleLabel);
    }
}
