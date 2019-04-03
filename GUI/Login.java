import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

import Theme.*;

class LoginFrame extends JFrame implements ActionListener {

    Container c;

    // Labels
    JLabel heading = new JLabel("<HTML><U>Student Login</U></HTML>");
    JLabel userName = new JLabel("Username:");
    JLabel password = new JLabel("Password:");
    JLabel singUpText = new JLabel("Don't have an account? ");
    JLabel warning = new JLabel("Please enter username and password");

    // Fields
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    // Buttons
    JButton loginBtn = new JButton("Login");
    JButton singUpBtn = new JButton("Sign Up");

    // colors
    Color whiteColor = new Color(255, 255, 255);
    Color primaryColor = new Color(63, 81, 181);
    Color textColor = new Color(116, 116, 116);
    Color secondaryColor = new Color(44, 62, 80);

    // Borders
    Border border = BorderFactory.createLineBorder(primaryColor);

    LoginFrame() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(whiteColor);

        // Setting Bounds
        heading.setBounds(350, 20, 500, 25);

        userName.setBounds(150, 100, 100, 40);
        userTextField.setBounds(250, 100, 400, 40);
        userTextField.setBorder(border);

        password.setBounds(150, 180, 100, 40);
        passwordField.setBounds(250, 180, 400, 40);
        passwordField.setBorder(border);

        warning.setBounds(150, 350, 500, 100);
        loginBtn.setBounds(150, 250, 500, 45);
        singUpText.setBounds(150, 320, 250, 50);
        singUpBtn.setBounds(350, 320, 300, 45);

        // Fonts
        Font font = new Font("Roboto", Font.PLAIN, 18);
        Font HeadingFont = new Font("Roboto", Font.CENTER_BASELINE, 22);
        heading.setFont(HeadingFont);
        userName.setFont(font);
        password.setFont(font);
        userTextField.setFont(font);
        passwordField.setFont(font);
        singUpText.setFont(font);
        warning.setFont(font);

        // Colors
        heading.setForeground(textColor);
        userName.setForeground(textColor);
        password.setForeground(textColor);
        singUpText.setForeground(textColor);
        warning.setForeground(Color.RED);

        // Button Properties
        loginBtn.setFont(font);
        loginBtn.setBackground(primaryColor);
        loginBtn.setForeground(whiteColor);
        loginBtn.addActionListener(this);

        singUpBtn.setFont(font);
        singUpBtn.setBackground(secondaryColor);
        singUpBtn.setForeground(whiteColor);

        // adding to the container
        c.add(heading);
        c.add(userName);
        c.add(password);
        c.add(userTextField);
        c.add(passwordField);
        c.add(loginBtn);
        c.add(singUpText);
        c.add(singUpBtn);

    }

    // Action listener
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == loginBtn) {

            if (!userTextField.getText().isEmpty() && !userTextField.getText().isEmpty()) {

                c.remove(warning);

                String user = userTextField.getText();
                String pass = passwordField.getText();

                // Checking username and passwords
                if (user.equals("Test") && pass.equals("12345")) {
                    c.setBackground(Color.GREEN);
                } else {
                    c.setBackground(Color.RED);

                }

            } else {
                c.add(warning);
            }

        }
    }

}

public class Login {
    public static void main(String[] args) {
        LoginFrame f = new LoginFrame();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(550, 200, 800, 500);
    }
}