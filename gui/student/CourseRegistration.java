package gui.student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.List;

import classes.Teacher;
import classes.Student;
import classes.Course;

import dbfunctions.*;

import java.awt.event.*;
import java.awt.*;

import gui.teacher.*;
import gui.Home;

// custom imports 
import gui.utilities.*;

public class CourseRegistration extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, welcome, courseText, boxOne, infoOne, infoTwo;
    private JButton backButton, startExam, resultButton, requestButton;
    private JComboBox courseList;
    private JList courseJList;
    private String coursess[];
    private Course selectedCourse;

    List<Course> course;
    private JPanel panel;

    // navigation
    private Student student;

    public CourseRegistration(Student student) {

        super("Course Registration");
        this.student = student;
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Navbar
        welcome = new JLabel("Welcome Sadat");
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.lightColor());
        backButton.setForeground(MyColor.dangerColor());
        backButton.setBounds(850, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        requestButton = new JButton("Request for the Course");
        requestButton.setFocusPainted(false);
        requestButton.setFont(MyFont.primaryFont());
        requestButton.setBackground(MyColor.primaryColor());
        requestButton.setForeground(MyColor.whiteColor());
        requestButton.setBounds(500, 500, 300, 50);
        requestButton.addActionListener(this);
        requestButton.setVisible(false);
        panel.add(requestButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        infoOne = new JLabel("Teacher Name: ");
        infoOne.setForeground(MyColor.whiteColor());
        infoOne.setFont(MyFont.primaryFont());
        infoOne.setVisible(false);
        infoOne.setBounds(410, 250, 380, 25);
        panel.add(infoOne);

        infoTwo = new JLabel("No. of students: ");
        infoTwo.setForeground(MyColor.whiteColor());
        infoTwo.setFont(MyFont.primaryFont());
        infoTwo.setBounds(410, 300, 380, 25);
        infoTwo.setVisible(false);
        panel.add(infoTwo);

        courseText = new JLabel("Select From Available courses: ");
        courseText.setForeground(MyColor.textColor());
        courseText.setFont(MyFont.smallFont());
        courseText.setBounds(40, 110, 250, 25);
        panel.add(courseText);

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.defaultColor());
        boxOne.setBounds(400, 200, 500, 180);
        boxOne.setVisible(false);
        panel.add(boxOne);

        course = Coursedb.getOfferedCourseList(student.getId());

        int length = course.size();
        coursess = new String[length];
        int i = 0;
        for (Course c : course) {
            coursess[i] = c.getName(); // c = courseList
            i++;
        }

        courseJList = new JList(coursess);
        courseJList.setFont(MyFont.smallFont());
        courseJList.setBorder(new EmptyBorder(10, 10, 10, 10));
        courseJList.setForeground(MyColor.textColor());
        courseJList.addMouseListener(this);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(courseJList);
        scrollPane.setBounds(40, 150, 300, 450);
        panel.add(scrollPane);

        startExam = new JButton("Start Exam");
        startExam.setFocusPainted(false);
        startExam.setFont(MyFont.smallFont());
        startExam.setBackground(MyColor.primaryColor());
        startExam.setForeground(MyColor.whiteColor());
        startExam.setFocusPainted(false);
        startExam.setBounds(40, 550, 350, 50);
        startExam.addActionListener(this);
        startExam.setVisible(false);
        panel.add(startExam);

        resultButton = new JButton("Percentage: 20%");
        resultButton.setFocusPainted(false);
        resultButton.setFont(MyFont.smallFont());
        resultButton.setBackground(MyColor.primaryColor());
        resultButton.setForeground(MyColor.whiteColor());
        resultButton.setFocusPainted(false);
        resultButton.setBounds(590, 550, 350, 50);
        resultButton.addActionListener(this);
        resultButton.setVisible(false);
        panel.add(resultButton);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backButton) {
            dispose();
            StudentHome shome = new StudentHome(student);
            shome.setVisible(true);
            shome.setLocationRelativeTo(null);
        }
        if (ae.getSource() == requestButton) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to Request for the course?", "Warning",
                    dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Studentdb.requestCourse(student.getId(), selectedCourse.getId());
                requestButton.setEnabled(false);
                requestButton.setText("Request Sent!");
                System.out.println("Request sent for the course");
            }

        }

    }

    public void mouseClicked(MouseEvent e) {

        // String str2 = "123";
        if (e.getSource() == courseJList) {

            requestButton.setVisible(true);
            infoOne.setVisible(true);
            infoTwo.setVisible(true);
            boxOne.setVisible(true);

            int selected = courseJList.getSelectedIndex();
            selectedCourse = course.get(selected);

            String numberOfStudents = Coursedb.getNumberOfStudents(selectedCourse.getId());
            String teacherName = Teacherdb.getTeacherName(selectedCourse.getTeacherId());

            infoOne.setText("Teacher name: " + teacherName);
            infoTwo.setText("No of Students: " + numberOfStudents);

            if (Studentdb.checkRequest(student.getId(), selectedCourse.getId()) == true) {
                requestButton.setText("Already requested");
                requestButton.setEnabled(false);
            } else {
                requestButton.setText("Request for the Course");
                requestButton.setEnabled(true);
            }

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