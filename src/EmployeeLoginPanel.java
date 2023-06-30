import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import javax.swing.JPasswordField;

public class EmployeeLoginPanel extends JDialog {
    private CustomLabel enterPassword;
    private CustomButton loginButton;
    private CustomButton backButton;
    private JPasswordField passwordField;

    public EmployeeLoginPanel(MainFrame mainFrame) {
        super(mainFrame, "Panel logowania pracownika.");

        setLayout(new GridLayout(2, 2, 5, 5));

        enterPassword = new CustomLabel("Podaj hasło:");
        loginButton = new CustomButton("Zaloguj");
        backButton = new CustomButton("Powrót");
        passwordField = new JPasswordField(20);

        passwordField.setFont(FontSingleton.getInstance().getFont());

        setSize(500, 150);
        setLocationRelativeTo(mainFrame);

        addActionListeners(mainFrame);

        add(enterPassword);
        add(passwordField);
        add(backButton);
        add(loginButton);

    }

    public CustomLabel getEnterPassword() {
        return enterPassword;
    }

    public CustomButton getLoginButton() {
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
