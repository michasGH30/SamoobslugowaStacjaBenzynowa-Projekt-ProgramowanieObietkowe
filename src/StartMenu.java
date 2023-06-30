import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class StartMenu extends JDialog {
    private CustomButton client;
    private CustomButton employee;

    public StartMenu(MainFrame mainFrame) {
        super(mainFrame, "Menu startowe");
        client = new CustomButton("Klient", FontSingleton.getInstance().getFont());
        employee = new CustomButton("Pracownik", FontSingleton.getInstance().getFont());
        setLayout(new FlowLayout());
        setSize(300, 200);
        setLocationRelativeTo(mainFrame);

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
