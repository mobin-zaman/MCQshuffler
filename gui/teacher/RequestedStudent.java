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

public class RequestedStudent extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, welcome, courses, studentNameText, studentIdText;
    private JButton backButton, acceptRequestButton, rejectRequestButton;

    private JPanel panel;

    private Teacher teacher;
    private Course course;
    private List<Student> students;
    private JList list;

    private Student selectedStudent;

    public RequestedStudent(Teacher teacher, Course course) {

        super("Requested Student");

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
        welcome.setBounds(550, 18, 400, 25);
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

        courses = new JLabel("Requested Students: ");
        courses.setForeground(MyColor.textColor());
        courses.setFont(MyFont.primaryFont());
        courses.setBounds(40, 70, 200, 25);
        panel.add(courses);

        // other labels
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

        acceptRequestButton = new JButton("Accept Student");
        acceptRequestButton.setBounds(400, 370, 180, 50);
        acceptRequestButton.setFont(MyFont.primaryFont());
        acceptRequestButton.setForeground(MyColor.whiteColor());
        acceptRequestButton.setBackground(MyColor.primaryColor());
        acceptRequestButton.addActionListener(this);
        acceptRequestButton.setEnabled(false);
        panel.add(acceptRequestButton);

        rejectRequestButton = new JButton("Reject Student");
        rejectRequestButton.setBounds(620, 370, 180, 50);
        rejectRequestButton.setFont(MyFont.primaryFont());
        rejectRequestButton.setForeground(MyColor.whiteColor());
        rejectRequestButton.setBackground(MyColor.dangerColor());
        rejectRequestButton.addActionListener(this);
        rejectRequestButton.setEnabled(false);
        panel.add(rejectRequestButton);

        // creating string array for list

        try {
            students = Coursedb.getRequestStudentList(course.getId());

        } catch (Exception e) {
            System.out.println("you got an error on RequestStudentList because there is no requested student " + e);
        }
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
        list.addMouseListener(this);
        list.setForeground(MyColor.textColor());

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(list);
        scrollPane.setBounds(40, 110, 280, 450);
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
        } else if (action.equals(acceptRequestButton.getText())) {

            System.out.println("courseID:::: " + course.getId() + "studentID::::" + selectedStudent.getId());
            Teacherdb.acceptRequest(course.getId(), selectedStudent.getId());
            System.out.println("Request accepted");
            acceptRequestButton.setEnabled(false);
            rejectRequestButton.setEnabled(false);

            JOptionPane.showMessageDialog(null, "Student added in you Enrolled student list!", "Done!",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (action.equals(rejectRequestButton.getText())) {
            Teacherdb.rejectRuquest(course.getId(), selectedStudent.getId());
            System.out.println("Request Rejected");
            acceptRequestButton.setEnabled(false);
            rejectRequestButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Student Request rejected!", "Informations!",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void mouseClicked(MouseEvent e) {

        // String str2 = "123";
        if (e.getSource() == list) {

            acceptRequestButton.setEnabled(true);
            rejectRequestButton.setEnabled(true);

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
