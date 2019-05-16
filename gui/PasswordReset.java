package gui;

import gui.student.*;
import dbfunctions.Teacherdb;
import gui.utilities.*;
import gui.teacher.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PasswordReset extends JFrame implements ActionListener, MouseListener {
    private JLabel textLabel, passText;
    private JTextField usernameField;
    private JButton resetButton, backButton;
    private JPanel panel;
    private JOptionPane errorPane;

    public PasswordReset() {

        super("Reset password");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(MyColor.primaryColor());
        panel.setOpaque(true);
        panel.setLayout(null);

        textLabel = new JLabel("Password Reset Form");
        textLabel.setBounds(310, 50, 450, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        textLabel = new JLabel("Forgot Password");
        textLabel.setBounds(355, 155, 450, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(MyColor.primaryColor());
        panel.add(textLabel);

        textLabel = new JLabel("Enter your username:");
        textLabel.setFont(MyFont.smallFont());
        textLabel.setForeground(MyColor.textColor());
        textLabel.setBounds(420, 280, 380, 40);
        panel.add(textLabel);

        usernameField = new JTextField();
        usernameField.setBounds(325, 320, 340, 40);
        usernameField.setFont(MyFont.primaryFont());
        panel.add(usernameField);

        resetButton = new JButton("Reset My Password");
        resetButton.setBounds(365, 390, 250, 45);
        resetButton.setFont(MyFont.primaryFont());
        resetButton.setForeground(MyColor.whiteColor());
        resetButton.setBackground(MyColor.primaryColor());
        resetButton.setFocusPainted(false);
        resetButton.setBorder(new LineBorder(MyColor.whiteColor()));
        resetButton.addActionListener(this);
        panel.add(resetButton);

        backButton = new JButton("Back");
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(40, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        passText = new JLabel();
        passText.setFont(MyFont.mediumFont());
        passText.setForeground(MyColor.whiteColor());
        passText.setBounds(250, 510, 520, 40);
        passText.setVisible(false);
        panel.add(passText);

        textLabel = new JLabel();
        textLabel.setBounds(225, 150, 550, 350);
        textLabel.setOpaque(true);
        textLabel.setBackground(MyColor.whiteColor());
        panel.add(textLabel);

        textLabel = new JLabel();
        textLabel.setBounds(0, 0, 1000, 700);
        textLabel.setOpaque(true);
        textLabel.setBackground(MyColor.primaryColor());
        panel.add(textLabel);

        this.add(panel);

    }

    // Action Listeners
    public void actionPerformed(ActionEvent ae) {
        String actionCommand = ae.getActionCommand();

        if (actionCommand.equals(backButton.getText())) {
            this.dispose();
            Home sp = new Home();
            sp.setLocationRelativeTo(null);
            sp.setResizable(false);
            sp.setVisible(true);

        } else if (actionCommand.equals(resetButton.getText())) {
            // check empty of not
            String username = usernameField.getText();

            if (username.equals("")) {
                errorPane = new JOptionPane();
                errorPane.setFont(MyFont.primaryFont());
                errorPane.showMessageDialog(null, "Enter your username first!", "Error!", JOptionPane.WARNING_MESSAGE);
            } else {
                passText.setText("Contact with JUBAYER or MOBIN for your password!!");
                passText.setVisible(true);
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

}