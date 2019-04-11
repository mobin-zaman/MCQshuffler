package gui.teacher;

import gui.components.*;
import dbfunctions.Coursedb;
import dbfunctions.Teacherdb;
import classes.Course;

import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TeacherHome extends JFrame implements ActionListener {

    private JLabel navBar, welcome, title, subTitle;
    private JButton addCourse, requests, homeButton, backButton;
    private JComboBox courseList;

    private JPanel panel;
    // Components
    private MyColor color;
    private MyFont font;

    public TeacherHome(String name, String ID) {

        super(name + "'s Home");

        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        color = new MyColor();
        font = new MyFont();

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(color.getNavbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        welcome = new JLabel("Welcome, " + name);
        welcome.setFont(font.getprimaryFont());
        welcome.setBounds(700, 10, 200, 25);
        panel.add(welcome);

        List<Course> course = Coursedb.getCourseList(ID);
        course.forEach((c) -> {
            System.out.println(c.getId());
            System.out.println(c.getName());
            System.out.println(c.getTeacherId());
            c.getName()

            
        });
        
        courseList = new JComboBox();


        addCourse = new JButton(ID);
        addCourse.setBounds(100, 200, 200, 30);
        panel.add(addCourse);

        requests = new JButton("Students' Requests");
        requests.setBounds(100, 300, 200, 30);
        panel.add(requests);

        subTitle = new JLabel("marakha");
        subTitle.setBounds(500, 80, 200, 30);
        panel.add(subTitle);

        homeButton = new JButton("Back");
        homeButton.setBounds(250, 350, 80, 30);
        panel.add(homeButton);

        backButton = new JButton("Home");
        backButton.setBounds(400, 350, 80, 30);
        panel.add(backButton);

        this.add(panel);

        // Listerners

        homeButton.addActionListener(this);
        backButton.addActionListener(this);

    }

    public void getUser(String name) {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();
            TeacherLogin f = new TeacherLogin();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } else if (e.getSource() == homeButton) {
            // Home(this);
        }

    }

}
