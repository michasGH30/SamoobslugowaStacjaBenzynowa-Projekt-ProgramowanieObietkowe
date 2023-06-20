import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class EmployeeLoginPanel extends JDialog {
    private JLabel enterPassword;
    private JButton loginButton;
    private JButton backButton;
    private JPasswordField passwordField;

    public EmployeeLoginPanel(MainFrame mainFrame) {
        super(mainFrame, "Panel logowania pracownika.");

        setLayout(new FlowLayout(FlowLayout.CENTER));

        enterPassword = new JLabel("Podaj hasło:");
        loginButton = new JButton("Zaloguj");
        backButton = new JButton("Powrót");
        passwordField = new JPasswordField(20);

        enterPassword.setFont(FontSingleton.getInstance().getFont());
        loginButton.setFont(FontSingleton.getInstance().getFont());
        backButton.setFont(FontSingleton.getInstance().getFont());
        passwordField.setFont(FontSingleton.getInstance().getFont());

        setSize(500, 300);
        setLocationRelativeTo(null);

        addActionListeners(mainFrame);

        add(enterPassword);
        add(passwordField);
        add(loginButton);
        add(backButton);

    }

    public JLabel getEnterPassword() {
        return enterPassword;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    private void addActionListeners(MainFrame mainFrame) {
        loginButton
                .addActionListener(new EmployeeLoginPanelLoginActionListener(this, mainFrame));

        backButton.addActionListener(new BackButtonActionListener(mainFrame));

        passwordField
                .addActionListener(new EmployeeLoginPanelLoginActionListener(this, mainFrame));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.exitProgram();
            }
        });
    }

}
