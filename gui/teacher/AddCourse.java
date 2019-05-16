package gui.teacher;

import gui.utilities.*;
import dbfunctions.*;
import gui.Home;

//needed for navigation
import classes.Teacher;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AddCourse extends JFrame implements ActionListener {

    private JLabel courseName, courseId, courseCredit, headerOne, navBar, welcome;
    private JTextField courseNameField;
    private JButton addCourseButton, backButton;
    private JPanel panel;
    private JOptionPane errorMessage, errorPane, successPane;

    // navigation
    private Teacher teacher;
    private Home home;

    public AddCourse(Teacher teacher, Home home) {

        super("Add Course");

        this.home = home;
        this.teacher = teacher;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(MyColor.whiteBg());
        panel.setLayout(null);

        // Navbar
        welcome = new JLabel(teacher.getName() + "'s Area");
        welcome.setFont(MyFont.primaryFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(800, 18, 200, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(30, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Teacher Login Elements

        headerOne = new JLabel("Add your Course here");
        headerOne.setBounds(305, 150, 400, 50);
        headerOne.setFont(MyFont.bigFont());
        headerOne.setForeground(MyColor.textColor());
        panel.add(headerOne);

        courseName = new JLabel("Course Name: ");
        courseName.setFont(MyFont.smallFont());
        courseName.setBounds(300, 260, 200, 20);
        courseName.setForeground(MyColor.textColor());
        panel.add(courseName);

        courseNameField = new JTextField();
        courseNameField.setBounds(300, 310, 400, 40);
        courseNameField.setFont(MyFont.primaryFont());
        panel.add(courseNameField);

        addCourseButton = new JButton("ADD COURSE");
        addCourseButton.setBounds(300, 390, 400, 40);
        addCourseButton.setFont(MyFont.primaryFont());
        addCourseButton.setForeground(MyColor.whiteColor());
        addCourseButton.setBackground(MyColor.primaryColor());
        addCourseButton.addActionListener(this);
        panel.add(addCourseButton);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {

        System.out.println("Action perfoered");
        if (e.getSource() == addCourseButton) {

            if (courseNameField.getText().equals("")) {
                System.out.println("Dhukse");

                errorMessage = new JOptionPane();
                errorMessage.setFont(MyFont.primaryFont());
                errorMessage.showMessageDialog(null, "All fields are required!", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                String description = courseNameField.getText();

                // Database checking here
                System.out.println("Course page: " + teacher.getName());
                Coursedb.insertCourse(description, Integer.toString(teacher.getId()));
                // Go back to home
                successPane = new JOptionPane();
                successPane.setFont(MyFont.primaryFont());
                successPane.showMessageDialog(null, "Course Added", "Success!", JOptionPane.INFORMATION_MESSAGE);
                courseNameField.setText("");

            }

        } else if (e.getSource() == backButton) {
            this.dispose();
            // navigatoin
            TeacherHome th = new TeacherHome(teacher);
            th.setVisible(true);
            th.setLocationRelativeTo(null);

        }
    }

}