import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class InfoDialog extends JDialog {

    private JLabel typeDescriptionLabel;
    private JLabel nameDescriptionLabel;
    private JLabel surnameDescriptionLabel;

    private JLabel typeLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;

    public InfoDialog(MainFrame mainFrame) {
        super(mainFrame, "Informacje o aktualnym użytkowniku");
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));
        setUI(mainFrame);
        pack();
        setVisible(true);
    }

    private void setUI(MainFrame mainFrame) {
        mainFrame.debugSout("Tu są tworzone obiekty UI, dane:, typ: " + mainFrame.getPerson().getType() + ", imie: "
                + mainFrame.getPerson().getName() + ", nazwisko: " + mainFrame.getPerson().getSurname());
        typeDescriptionLabel = new JLabel("Rola:");
        typeDescriptionLabel.setFont(FontSingleton.getInstance().getFont());
        typeDescriptionLabel.setForeground(ColorSingleton.getInstance().getRed());

        typeLabel = new JLabel(mainFrame.getPerson().getType());
        typeLabel.setFont(FontSingleton.getInstance().getFont());

        nameDescriptionLabel = new JLabel("Imię:");
        nameDescriptionLabel.setFont(FontSingleton.getInstance().getFont());
        nameDescriptionLabel.setForeground(ColorSingleton.getInstance().getRed());

        nameLabel = new JLabel(mainFrame.getPerson().getName());
        nameLabel.setFont(FontSingleton.getInstance().getFont());

        surnameDescriptionLabel = new JLabel("Nazwisko:");
        surnameDescriptionLabel.setFont(FontSingleton.getInstance().getFont());
        surnameDescriptionLabel.setForeground(ColorSingleton.getInstance().getRed());

        surnameLabel = new JLabel(mainFrame.getPerson().getSurname());
        surnameLabel.setFont(FontSingleton.getInstance().getFont());

        mainFrame.debugSout("Tu są stworzone obiekty UI, dane:, typ: " + typeLabel.getText() + ", imie: "
                + nameLabel.getText() + ", nazwisko: " + surnameLabel.getText());

        add(typeDescriptionLabel);
        add(typeLabel);

        add(nameDescriptionLabel);
        add(nameLabel);

        add(surnameDescriptionLabel);
        add(surnameLabel);
    }
}
