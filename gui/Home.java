package gui;

import gui.student.*;
import gui.teacher.*;
import gui.utilities.*;

import classes.*;
import dbfunctions.Teacherdb;
import dbfunctions.Studentdb;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Home extends JFrame implements ActionListener, MouseListener {
    private JLabel textLabel, usernameLabel, passwordLabel, boxOne;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton, forgetButton, credits, about;
    private JPanel panel;

    private Teacher teacher;
    private Student student;
    String username;
    String password;

    public Home() {

        super("Home Page");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(MyColor.whiteBg());
        panel.setOpaque(true);
        panel.setLayout(null);

        // Login UI Elements
        textLabel = new JLabel("Sign in");
        textLabel.setBounds(245, 110, 300, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.black);
        panel.add(textLabel);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(MyFont.primaryFont());
        usernameLabel.setBounds(130, 200, 120, 30);
        usernameLabel.setForeground(MyColor.textColor());
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 240, 340, 40);
        usernameField.setFont(MyFont.primaryFont());
        usernameField.setText(SignupPage.getUname());
        panel.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(MyFont.primaryFont());
        passwordLabel.setForeground(MyColor.textColor());
        passwordLabel.setBounds(130, 290, 120, 40);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(MyFont.primaryFont());
        passwordField.setBounds(130, 330, 340, 40);
        passwordField.setText(SignupPage.getUpass());
        panel.add(passwordField);

        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(225, 410, 150, 45);
        loginButton.setFont(MyFont.primaryFont());
        loginButton.setForeground(MyColor.whiteColor());
        loginButton.setBackground(MyColor.primaryColor());
        panel.add(loginButton);

        forgetButton = new JButton("Forget your password?");
        forgetButton.setFont(MyFont.smallFont());
        forgetButton.setForeground(MyColor.textColor());
        forgetButton.setBounds(150, 480, 300, 40);
        forgetButton.setFocusPainted(false);
        forgetButton.setContentAreaFilled(false);
        forgetButton.setBorder(BorderFactory.createEmptyBorder());
        forgetButton.addActionListener(this);
        panel.add(forgetButton);

        textLabel = new JLabel("Hello, there!");
        textLabel.setBounds(600, 200, 300, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        textLabel = new JLabel("Don't have an account?");
        textLabel.setBounds(590, 280, 300, 60);
        textLabel.setFont(MyFont.mediumFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        signupButton = new JButton("SIGN  UP");
        signupButton.setBounds(630, 350, 145, 45);
        signupButton.setBorder(new LineBorder(Color.white));
        signupButton.setFont(MyFont.primaryFont());
        signupButton.setFocusPainted(false);
        signupButton.setForeground(MyColor.whiteColor());
        signupButton.setBackground(MyColor.primaryColor());
        panel.add(signupButton);

        credits = new JButton("Credits");
        credits.setBounds(675, 10, 100, 40);
        credits.setBorder(new LineBorder(Color.white));
        credits.setFont(MyFont.primaryFont());
        credits.setFocusPainted(false);
        credits.setForeground(MyColor.primaryColor());
        credits.setBackground(MyColor.whiteColor());
        credits.addActionListener(this);
        panel.add(credits);

        about = new JButton("About");
        about.setBounds(800, 10, 100, 40);
        about.setBorder(new LineBorder(Color.white));
        about.setFont(MyFont.primaryFont());
        about.setFocusPainted(false);
        about.setForeground(MyColor.primaryColor());
        about.setBackground(MyColor.whiteColor());
        about.addActionListener(this);
        panel.add(about);

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        loginButton.addMouseListener(this);
        signupButton.addMouseListener(this);

        boxOne = new JLabel();
        boxOne.setBounds(100, 80, 400, 500);
        boxOne.setFont(MyFont.headerFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(Color.white);
        panel.add(boxOne);

        boxOne = new JLabel();
        boxOne.setBounds(500, 80, 400, 500);
        boxOne.setFont(MyFont.headerFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.primaryColor());
        panel.add(boxOne);

        this.add(panel);
    }

    // Action Listeners
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        username = usernameField.getText();
        password = passwordField.getText();

        // Sign up
        if (actionCommand.equals(signupButton.getText())) {
            this.dispose();
            SignupPage sp = new SignupPage();
            sp.setLocationRelativeTo(null);
            sp.setResizable(false);
            sp.setVisible(true);
        }

        // Login
        else if (actionCommand.equals(loginButton.getText())) {

            if (usernameField.getText().equals("") || passwordField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "username or password can not be empty", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else { // If fields are not empty
                SignupPage.resetData();

                teacher = Teacherdb.login(username, password);
                System.out.println(teacher);
                student = Studentdb.login(username, password);
                System.out.println(student);

                if (teacher == null && student == null) {
                    JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "Wrong Information!",
                            JOptionPane.WARNING_MESSAGE);
                } else if (student == null) {
                    dispose();
                    System.out.println("in teacher home: " + teacher.getName());
                    TeacherHome teacherHome = new TeacherHome(teacher);
                    teacherHome.setLocationRelativeTo(null);
                    teacherHome.setResizable(false);
                    teacherHome.setVisible(true);

                } else if (teacher == null) {
                    dispose();
                    System.out.println("in student home: " + student.getName());
                    StudentHome studentHome = new StudentHome(student);
                    studentHome.setLocationRelativeTo(null);
                    studentHome.setResizable(false);
                    studentHome.setVisible(true);
                }

            }

        } else if (actionCommand.equals(forgetButton.getText())) {
            SignupPage.resetData();
            System.out.println("Forgot button clicked");
            PasswordReset ps = new PasswordReset();
            this.dispose();
            ps.setLocationRelativeTo(null);
            ps.setResizable(false);
            ps.setVisible(true);
        } else if (actionCommand.equals(credits.getText())) {
            System.out.println("Credits button clicked");
            Credits cre = new Credits();
            this.dispose();
            cre.setLocationRelativeTo(null);
            cre.setResizable(false);
            cre.setVisible(true);
        } else if (actionCommand.equals(about.getText())) {
            System.out.println("Credits button clicked");
            About aboutPage = new About();
            this.dispose();
            aboutPage.setLocationRelativeTo(null);
            aboutPage.setResizable(false);
            aboutPage.setVisible(true);
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

}