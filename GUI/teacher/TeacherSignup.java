package teacher;

import javax.swing.*;

public class TeacherSignup extends JFrame {
    private JLabel usernameLabel, passwordLabel, email;
    private JTextField usernameField, emailField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton;
    private JPanel panel;

    public TeacherSignup() {

        super("Faculty Signup");
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

        email = new JLabel("Email: ");
        email.setBounds(150, 240, 100, 30);
        panel.add(email);

        emailField = new JTextField();
        emailField.setBounds(250, 240, 100, 30);
        panel.add(emailField);

        loginButton = new JButton("Sign up");
        loginButton.setBounds(150, 300, 80, 30);
        panel.add(loginButton);

        signupButton = new JButton("Log in");
        signupButton.setBounds(250, 300, 80, 30);
        panel.add(signupButton);

        this.add(panel);

    }
}