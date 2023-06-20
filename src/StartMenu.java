import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

public class StartMenu extends JDialog {
    private JButton client;
    private JButton employee;

    public StartMenu(MainFrame mainFrame) {
        super(mainFrame, "Menu startowe");
        client = new JButton("Klient");
        employee = new JButton("Pracownik");
        client.setFont(FontSingleton.getInstance().getFont());
        employee.setFont(FontSingleton.getInstance().getFont());
        setLayout(new FlowLayout());
        setSize(300, 200);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.exitProgram();
            }
        });

        addActionListeners(mainFrame);
        add(client);
        add(employee);
    }

    private void addActionListeners(MainFrame mainFrame) {
        client.addActionListener(new StartMenuClientButtonActionListener(mainFrame, mainFrame.getDispensersPanel()));
        employee.addActionListener(new StartMenuEmployeeButtonActionListener(mainFrame));
    }
}
