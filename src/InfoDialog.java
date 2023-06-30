import java.awt.GridLayout;

import javax.swing.JDialog;

public class InfoDialog extends JDialog {

    private CustomLabel typeDescriptionLabel;
    private CustomLabel nameDescriptionLabel;
    private CustomLabel surnameDescriptionLabel;

    private CustomLabel typeLabel;
    private CustomLabel nameLabel;
    private CustomLabel surnameLabel;

    public InfoDialog(MainFrame mainFrame) {
        super(mainFrame, "Informacje o aktualnym użytkowniku");
        setLocationRelativeTo(mainFrame);
        setLayout(new GridLayout(3, 2, 5, 5));
        setUI(mainFrame);
        setSize(300, 150);
        setVisible(true);
    }

    private void setUI(MainFrame mainFrame) {
        mainFrame.debugSout("Tu są tworzone obiekty UI, dane:, typ: " + mainFrame.getPerson().getType() + ", imie: "
                + mainFrame.getPerson().getName() + ", nazwisko: " + mainFrame.getPerson().getSurname());
        typeDescriptionLabel = new CustomLabel("Rola:", ColorSingleton.getInstance().getRed());

        typeLabel = new CustomLabel(mainFrame.getPerson().getType());

        nameDescriptionLabel = new CustomLabel("Imię:", ColorSingleton.getInstance().getRed());

        nameLabel = new CustomLabel(mainFrame.getPerson().getName());

        surnameDescriptionLabel = new CustomLabel("Nazwisko:", ColorSingleton.getInstance().getRed());

        surnameLabel = new CustomLabel(mainFrame.getPerson().getSurname());

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
