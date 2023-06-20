import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private StartMenu startMenu;
    private EmployeeLoginPanel employeeLoginPanel;
    private DispensersPanel dispensersPanel;
    private TopPanel topPanel;
    private BottomPanel bottomPanel;
    private Person person;

    public MainFrame() {
        super("Mój program");
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        person = new Client();

        dispensersPanel = new DispensersPanel(this);
        add(dispensersPanel, BorderLayout.CENTER);

        startMenu = new StartMenu(this);

        employeeLoginPanel = new EmployeeLoginPanel(this);

        topPanel = new TopPanel(this);
        add(topPanel, BorderLayout.PAGE_START);

        bottomPanel = new BottomPanel(this);
        add(bottomPanel, BorderLayout.PAGE_END);

        pack();
        setMainFrameVisibility(false);
        setEmployeeLoginPanelVisibility(false);
        setStartMenuVisibility(true);
    }

    public DispensersPanel getDispensersPanel() {
        return dispensersPanel;
    }

    public void debugSout(String message) {
        System.out.println(message);
    }

    public void exitProgram() {
        System.exit(0);
    }

    public void setStartMenuVisibility(boolean visible) {
        if (visible) {
            debugSout("Pokazuje Start Menu");
        } else {
            debugSout("Chowam Start Menu");
        }

        startMenu.setVisible(visible);
    }

    public EmployeeLoginPanel getEmployeeLoginPanel() {
        return employeeLoginPanel;
    }

    public void setEmployeeLoginPanelVisibility(boolean visible) {
        if (visible) {
            debugSout("Pokazuje Panel Logowania");
        } else {
            debugSout("Chowam Panel Logowania");
        }
        employeeLoginPanel.setVisible(visible);
        if (visible) {
            employeeLoginPanel.getPasswordField().setText("");
        }

    }

    public void setMainFrameVisibility(boolean visible) {
        if (visible) {
            debugSout("Pokazuje Główną Ramkę");
        } else {
            debugSout("Chowam Główną Ramkę");
        }
        setVisible(visible);
    }

    public void setNameSurname(String name, String surname) {
        person.setName(name);
        person.setSurname(surname);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

}