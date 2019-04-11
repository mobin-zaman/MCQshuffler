package gui.teacher;

import gui.components.*;
import dbfunctions.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AddCourse extends JFrame implements ActionListener {

    private String teacherName, teacherId;

    private JLabel courseName, courseId, courseCredit, headerOne, navBar, welcome;
    private JTextField courseNameField;
    private JButton addCourseButton, backButton;
    private JPanel panel;
    private JOptionPane errorMessage, errorPane, successPane;

    // Components
    private MyColor color;
    private MyFont font;

    JToggleButton toggleButton;

    public AddCourse(String name, String ID) {

        super("Add Course");

        teacherName = name;
        teacherId = ID;

        color = new MyColor();
        font = new MyFont();

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(color.getBgColor());
        panel.setLayout(null);

        // Navbar
        welcome = new JLabel(name);
        welcome.setFont(font.getprimaryFont());
        welcome.setForeground(color.getBgColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFont(font.getprimaryFont());
        backButton.setBackground(color.getsecondaryButtonColor());
        backButton.setForeground(color.getBgColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(850, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(color.getNavbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Teacher Login Elements

        headerOne = new JLabel("Add your Course here");
        headerOne.setBounds(380, 120, 400, 40);
        headerOne.setFont(font.getHeaderFont());
        headerOne.setForeground(color.getTextColor());
        panel.add(headerOne);

        courseName = new JLabel("Course Name: ");
        courseName.setFont(font.getSmallFont());
        courseName.setBounds(300, 260, 200, 20);
        courseName.setForeground(color.getTextColor());
        panel.add(courseName);

        courseNameField = new JTextField();
        courseNameField.setBounds(300, 310, 400, 40);
        courseNameField.setFont(font.getprimaryFont());
        panel.add(courseNameField);

        addCourseButton = new JButton("ADD COURSE");
        addCourseButton.setBounds(300, 390, 400, 40);
        addCourseButton.setFont(font.getprimaryFont());
        addCourseButton.setForeground(color.getBgColor());
        addCourseButton.setBackground(color.getButtonColor());
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
                errorMessage.setFont(font.getprimaryFont());
                errorMessage.showMessageDialog(null, "All fields are required!", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                String name = courseNameField.getText();

                // Database checking here
                Coursedb.insertCourse(name, teacherId);
                // Go back to home
                successPane = new JOptionPane();
                successPane.setFont(font.getprimaryFont());
                successPane.showMessageDialog(null, "Course Added", "Success!", JOptionPane.WARNING_MESSAGE);
                courseNameField.setText("");

            }

        } else if (e.getSource() == backButton) {
            dispose();
            TeacherHome teacherHome = new TeacherHome(teacherName, teacherId);
            teacherHome.setLocationRelativeTo(null);
            teacherHome.setVisible(true);
        } else {

        }
    }

}