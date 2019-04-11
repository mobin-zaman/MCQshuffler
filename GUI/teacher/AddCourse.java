package teacher;

import javax.swing.*;

public class AddCourse extends JFrame {
    private JLabel courseName, courseCode, credit, title;
    private JTextField courseNameField, courseCodeField, creditField;
    private JButton addCourse;
    private JPanel panel;

    public AddCourse() {

        super("Add course");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Add Course");
        title.setBounds(250, 50, 200, 30);
        panel.add(title);

        courseName = new JLabel("Course Name: ");
        courseName.setBounds(150, 100, 100, 30);
        panel.add(courseName);

        courseNameField = new JTextField();
        courseNameField.setBounds(250, 100, 100, 30);
        panel.add(courseNameField);

        courseName = new JLabel("Course Code: ");
        courseName.setBounds(150, 150, 100, 30);
        panel.add(courseName);

        courseNameField = new JTextField();
        courseNameField.setBounds(250, 150, 100, 30);
        panel.add(courseNameField);

        courseName = new JLabel("Credit(s): ");
        courseName.setBounds(150, 200, 100, 30);
        panel.add(courseName);

        courseNameField = new JTextField();
        courseNameField.setBounds(250, 200, 100, 30);
        panel.add(courseNameField);

        addCourse = new JButton("Add Course");
        addCourse.setBounds(200, 250, 150, 30);
        panel.add(addCourse);

        this.add(panel);

    }
}