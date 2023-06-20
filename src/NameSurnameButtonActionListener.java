import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class NameSurnameButtonActionListener implements ActionListener {

    private MainFrame mainFrame;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private NameSurnameDialog nameSurnameDialog;

    public NameSurnameButtonActionListener(MainFrame mainFrame, JTextField nameTextField, JTextField surnameTextField,
            NameSurnameDialog nameSurnameDialog) {
        this.mainFrame = mainFrame;
        this.nameTextField = nameTextField;
        this.surnameTextField = surnameTextField;
        this.nameSurnameDialog = nameSurnameDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.debugSout("Tu ustawiam dane osoby, imie: " + nameTextField.getText() + ", nazwisko: "
                + surnameTextField.getText());
        mainFrame.setNameSurname(nameTextField.getText(), surnameTextField.getText());
        mainFrame.setMainFrameVisibility(true);
        mainFrame.setStartMenuVisibility(false);
        mainFrame.setEmployeeLoginPanelVisibility(false);
        nameSurnameDialog.setVisible(false);
    }

}
