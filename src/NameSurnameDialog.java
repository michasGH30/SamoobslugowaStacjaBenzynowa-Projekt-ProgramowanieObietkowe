import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import javax.swing.JTextField;

public class NameSurnameDialog extends JDialog {

    private CustomLabel nameLabel;
    private JTextField nameTextField;
    private CustomLabel surnameLabel;
    private JTextField surnameTextField;
    private CustomButton button;

    public NameSurnameDialog(MainFrame mainFrame) {
        super(mainFrame, "Okno dialogowe danych osobowych");
        setLocationRelativeTo(mainFrame);
        setLayout(new GridLayout(5, 1, 5, 5));
        setUI();
        addActionListeners(mainFrame);
        setSize(300, 300);
        setVisible(true);
    }

    private void setUI() {
        nameLabel = new CustomLabel("Podaj swoje imie:");
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(FontSingleton.getInstance().getFont());
        add(nameTextField);

        surnameLabel = new CustomLabel("Podaj swoje nazwisko:");
        add(surnameLabel);

        surnameTextField = new JTextField();
        surnameTextField.setFont(FontSingleton.getInstance().getFont());
        add(surnameTextField);

        button = new CustomButton("Dalej");
        add(button);

    }

    private void addActionListeners(MainFrame mainFrame) {
        mainFrame.debugSout(
                "Tu jest przypisanie działania, jest takie same dla przycisku i drugiego pola, dane z pól, imie: "
                        + nameTextField.getText() + ", nazwisko: " + surnameTextField.getText());
        button.addActionListener(
                new NameSurnameButtonActionListener(mainFrame, nameTextField, surnameTextField, this));
        surnameTextField.addActionListener(
                new NameSurnameButtonActionListener(mainFrame, nameTextField, surnameTextField, this));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.exitProgram();
            }
        });
    }
}
