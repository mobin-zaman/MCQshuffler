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

public class About extends JFrame implements ActionListener {
    private JButton backbutton;
    private JPanel panel;
    private ImageIcon image;
    JLabel imgLabel;

    public About() {

        super("About");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        // panel.setBackground(MyColor.secondaryColor());
        // panel.setOpaque(true);
        panel.setLayout(null);

        backbutton = new JButton("Back");
        backbutton.setFont(MyFont.mediumFont());
        backbutton.setBackground(MyColor.primaryColor());
        backbutton.setForeground(MyColor.whiteColor());
        backbutton.addActionListener(this);
        backbutton.setFocusPainted(false);
        backbutton.setBounds(405, 522, 200, 45);
        panel.add(backbutton);

        image = new ImageIcon("about.png");
        imgLabel = new JLabel(image);
        imgLabel.setBounds(95, 45, 812, 550);
        panel.add(imgLabel);

        this.add(panel);

    }

    // Action Listeners
    public void actionPerformed(ActionEvent ae) {
        String actionCommand = ae.getActionCommand();

        if (actionCommand.equals(backbutton.getText())) {
            this.dispose();
            Home sp = new Home();
            sp.setLocationRelativeTo(null);
            sp.setResizable(false);
            sp.setVisible(true);

        }

    }

}