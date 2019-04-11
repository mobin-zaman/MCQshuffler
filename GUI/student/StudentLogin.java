package student;

import javax.swing.*;

public class StudentLogin extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton;
    private JPanel panel;

    public StudentLogin() {

        super("Faculty Login");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(150, 110, 100, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(250, 110, 100, 30);
        panel.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(150, 170, 100, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 170, 100, 30);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 250, 80, 30);
        panel.add(loginButton);

        signupButton = new JButton("Sign up");
        signupButton.setBounds(250, 250, 80, 30);
        panel.add(signupButton);

        this.add(panel);

    }
}