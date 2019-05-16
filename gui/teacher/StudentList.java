package gui.teacher;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.border.EmptyBorder;

import gui.teacher.*;
import gui.Home;
import gui.utilities.*;

// Navigations
import classes.Course;
import classes.Teacher;
import classes.Student;

// database
import dbfunctions.*;

public class StudentList extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, welcome, courses, studentNameText, studentIdText;
    private JButton backButton, removeStudent;

    private JPanel panel;
    private JList list;

    private Teacher teacher;
    private Course course;
    private List<Student> students;
    private Student selectedStudent;

    public StudentList(Teacher teacher, Course course) {

        super("Student List page");

        this.teacher = teacher;
        this.course = course;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Navbar

        welcome = new JLabel("Course: " + course.getName());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setFont(MyFont.primaryFont());
        welcome.setBounds(600, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setBounds(40, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        courses = new JLabel("Enrolled Students: ");
        courses.setForeground(MyColor.textColor());
        courses.setFont(MyFont.primaryFont());
        courses.setBounds(40, 70, 200, 25);
        panel.add(courses);

        studentNameText = new JLabel();
        studentNameText.setForeground(MyColor.textColor());
        studentNameText.setFont(MyFont.primaryFont());
        studentNameText.setBounds(400, 200, 500, 25);
        panel.add(studentNameText);

        studentIdText = new JLabel();
        studentIdText.setForeground(MyColor.textColor());
        studentIdText.setFont(MyFont.primaryFont());
        studentIdText.setBounds(400, 250, 500, 25);
        panel.add(studentIdText);

        removeStudent = new JButton("Remove Student");
        removeStudent.setBounds(500, 350, 200, 45);
        removeStudent.setFont(MyFont.primaryFont());
        removeStudent.setForeground(MyColor.whiteColor());
        removeStudent.setBackground(MyColor.dangerColor());
        removeStudent.addActionListener(this);
        removeStudent.setEnabled(false);
        panel.add(removeStudent);

        // creating string array for list

        students = Coursedb.getEnrolledStudentList(course.getId());

        int length = students.size();
        String studentsString[] = new String[length];
        int i = 0;
        for (Student s : students) {
            studentsString[i] = s.getName();
            i++;
        }

        JScrollPane scrollPane = new JScrollPane();
        list = new JList(studentsString);
        list.setFont(MyFont.tinyFont());
        list.setForeground(MyColor.textColor());
        list.setBorder(new EmptyBorder(10, 10, 10, 10));
        list.setForeground(MyColor.textColor());
        list.addMouseListener(this);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(list);
        scrollPane.setBounds(40, 110, 280, 480);
        panel.add(scrollPane);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();

        if (action.equals(backButton.getText())) {
            dispose();
            CoursePage cp = new CoursePage(teacher, course);
            cp.setLocationRelativeTo(null);
            cp.setResizable(false);
            cp.setVisible(true);
        } else if (action.equals(removeStudent.getText())) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete the course?", "Warning",
                    dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Teacherdb.removeStudent(course.getId(), selectedStudent.getId());
                System.out.println("Student Removed successfully");
                // refresh GUI;
                StudentList sList = new StudentList(teacher, course);
                this.dispose();
                sList.setLocationRelativeTo(null);
                sList.setResizable(false);
                sList.setVisible(true);

            }
        }
    }

    public void mouseClicked(MouseEvent e) {

        // String str2 = "123";
        if (e.getSource() == list) {

            removeStudent.setEnabled(true);

            int selected = list.getSelectedIndex();

            selectedStudent = students.get(selected);

            studentNameText.setText("Student Name: " + selectedStudent.getName());
            studentIdText.setText("Student ID: " + selectedStudent.getId());

        }

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
