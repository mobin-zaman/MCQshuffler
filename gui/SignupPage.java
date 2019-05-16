package gui;

import gui.student.*;
import dbfunctions.Studentdb;
import dbfunctions.Teacherdb;
import gui.utilities.*;
import gui.teacher.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignupPage extends JFrame implements ActionListener, MouseListener {
    private JLabel textLabel, usernameLabel, passwordLabel, singupText, boxOne, positionLabel;
    private JComboBox comboBox;
    private String positions[] = { "Student", "Teacher" };
    private JTextField usernameField, anotherField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton;
    private JPanel panel;
    private JOptionPane errorPane, successPane;

    // Inital values
    private static String Uname, Upassword;

    public SignupPage() {

        super("Sign up");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(MyColor.secondaryColor());
        panel.setOpaque(false);
        panel.setLayout(null);

        // Login UI Elements
        textLabel = new JLabel("Create Account");
        textLabel.setBounds(565, 110, 300, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.black);
        panel.add(textLabel);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(MyFont.primaryFont());
        usernameLabel.setBounds(535, 200, 120, 30);
        usernameLabel.setForeground(MyColor.textColor());
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(535, 240, 340, 40);
        usernameField.setFont(MyFont.primaryFont());
        panel.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(MyFont.primaryFont());
        passwordLabel.setForeground(MyColor.textColor());
        passwordLabel.setBounds(535, 290, 120, 40);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(MyFont.primaryFont());
        passwordField.setBounds(535, 330, 340, 40);
        panel.add(passwordField);

        positionLabel = new JLabel("Position: ");
        positionLabel.setFont(MyFont.primaryFont());
        positionLabel.setForeground(MyColor.textColor());
        positionLabel.setBounds(535, 380, 120, 40);
        panel.add(positionLabel);

        comboBox = new JComboBox(positions);
        comboBox.setBounds(535, 420, 340, 40);
        comboBox.setBackground(Color.white);
        comboBox.setFont(MyFont.primaryFont());
        panel.add(comboBox);

        anotherField = new JTextField();
        anotherField.setBounds(535, 420, 340, 40);
        anotherField.setFont(MyFont.primaryFont());
        panel.add(anotherField);

        signupButton = new JButton("SIGN  UP");
        signupButton.setBounds(630, 500, 145, 45);
        signupButton.setBorder(new LineBorder(MyColor.whiteColor()));
        signupButton.setFont(MyFont.primaryFont());
        signupButton.setForeground(MyColor.whiteColor());
        signupButton.setBackground(MyColor.primaryColor());
        panel.add(signupButton);

        textLabel = new JLabel("Welcome Back!");
        textLabel.setBounds(180, 200, 350, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        singupText = new JLabel("If you already have an account");
        singupText.setFont(MyFont.mediumFont());
        singupText.setForeground(Color.white);
        singupText.setBounds(155, 280, 380, 40);
        panel.add(singupText);

        singupText = new JLabel("Then please sign in");
        singupText.setFont(MyFont.mediumFont());
        singupText.setForeground(Color.white);
        singupText.setBounds(210, 320, 300, 40);

        panel.add(singupText);

        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(225, 380, 150, 45);
        loginButton.setFont(MyFont.primaryFont());
        loginButton.setForeground(MyColor.whiteColor());
        loginButton.setBackground(MyColor.primaryColor());
        loginButton.setBorder(new LineBorder(MyColor.whiteColor()));
        panel.add(loginButton);

        boxOne = new JLabel();
        boxOne.setBounds(100, 80, 400, 500);
        boxOne.setFont(MyFont.headerFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.primaryColor());
        panel.add(boxOne);

        boxOne = new JLabel();
        boxOne.setBounds(500, 80, 400, 500);
        boxOne.setFont(MyFont.headerFont());
        boxOne.setBackground(Color.white);
        boxOne.setOpaque(true);
        panel.add(boxOne);

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        loginButton.addMouseListener(this);
        signupButton.addMouseListener(this);

        this.add(panel);

    }

    // Action Listeners
    public void actionPerformed(ActionEvent ae) {
        String actionCommand = ae.getActionCommand();

        if (actionCommand.equals(loginButton.getText())) {
            this.dispose();
            Home sp = new Home();
            sp.setLocationRelativeTo(null);
            sp.setResizable(false);
            sp.setVisible(true);

        } else if (actionCommand.equals(signupButton.getText())) {
            // check empty of not
            String username = usernameField.getText();
            String password = passwordField.getText();
            String selectedPosition = (String) comboBox.getSelectedItem();

            if (username.equals("") || password.equals("")) {
                errorPane = new JOptionPane();
                errorPane.setFont(MyFont.primaryFont());
                errorPane.showMessageDialog(null, "All fields are required!", "Error!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (selectedPosition.equals("Student")) {
                    // insert into Student database
                    if (Studentdb.signUp(username, password)) {
                        System.out.println("Student Inserted");
                        System.out.println(username);
                        System.out.println(password);
                    } else {
                        System.out.println("Already Fucked up");

                    }

                } else {
                    if (Teacherdb.signUp(username, password)) {

                        System.out.println("Teacher clicked");
                        System.out.println(username);
                        System.out.println(password);
                    } else {
                        System.out.println("Already Fucked up");

                    }
                }
                setUserData(username, password);
                successPane = new JOptionPane();
                successPane.setFont(MyFont.primaryFont());
                successPane.showMessageDialog(null, "Registration Successful!", "No you can Login",
                        JOptionPane.INFORMATION_MESSAGE);
                // and go back to Login page
                this.dispose();
                Home sp = new Home();
                System.out.println(username);
                sp.setLocationRelativeTo(null);
                sp.setResizable(false);
                sp.setVisible(true);

            }
        }

    }

    // Mouse listeners
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public static String getUname() {
        if (Uname != null)
            return Uname;
        else
            return "";
    }

    public static String getUpass() {
        if (Upassword != null)
            return Upassword;
        else
            return "";
    }

    public void setUserData(String name, String password) {
        Uname = name;
        Upassword = password;
    }

    public static void resetData() {
        Uname = "";
        Upassword = "";
    }
}