package gui.teacher;

import gui.utilities.*;
import gui.Home;

import dbfunctions.Coursedb;
import dbfunctions.Teacherdb;
import classes.Course;
import classes.Teacher;

import javax.swing.border.EmptyBorder;
import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TeacherHome extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, boxOne, boxTwo, welcome, title, studentNumber, questionNumber, num1, num2, loginSuccess;
    private JButton addCourse, logoutButton, goToButton, deleteButton;

    private JPanel panel;
    private String teacherId, teacherName;
    private int courseId;
    private String theCourse;
    private String coursess[];

    private List<Course> course;

    private JList courseList;

    // NAVIGATION OBJECTS:
    private Teacher teacher;
    private Home home;
    private Course selectedCourse;

    public TeacherHome(Teacher teacher) {

        super("Teacher Home");

        // got from navigation
        this.teacher = teacher;

        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(MyColor.whiteBg());

        // Add Course Button
        addCourse = new JButton("ADD Course");
        addCourse.setFont(MyFont.mediumFont());
        addCourse.setBackground(MyColor.primaryColor());
        addCourse.setForeground(MyColor.whiteColor());
        addCourse.setFocusPainted(false);
        addCourse.setBounds(400, 45, 200, 50);
        addCourse.addActionListener(this);
        panel.add(addCourse);

        // Navbar
        welcome = new JLabel("Welcome, " + teacher.getName());
        welcome.setFont(MyFont.mediumFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(MyFont.primaryFont());
        logoutButton.setBackground(MyColor.lightColor());
        logoutButton.setForeground(MyColor.textColor());
        logoutButton.setFocusPainted(false);
        logoutButton.setBounds(850, 13, 100, 35);
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        title = new JLabel("Your Courses:");
        title.setFont(MyFont.tinyFont());
        title.setBounds(40, 125, 120, 25);
        panel.add(title);

        // Texts

        loginSuccess = new JLabel("Please Select a course");
        loginSuccess.setFont(MyFont.mediumFont());
        loginSuccess.setForeground(MyColor.darkColor());
        loginSuccess.setBounds(40, 95, 700, 25);
        panel.add(loginSuccess);

        studentNumber = new JLabel("Students");
        studentNumber.setFont(MyFont.bigFont());
        studentNumber.setForeground(MyColor.whiteBg());
        studentNumber.setBounds(420, 380, 250, 50);
        panel.add(studentNumber);

        num1 = new JLabel();
        num1.setText("00");
        num1.setFont(MyFont.bigBigFont());
        num1.setForeground(MyColor.whiteBg());
        num1.setBounds(390, 70, 400, 400);
        panel.add(num1);

        questionNumber = new JLabel("Questions");
        questionNumber.setFont(MyFont.bigFont());
        questionNumber.setForeground(MyColor.whiteBg());
        questionNumber.setBounds(720, 380, 250, 50);
        panel.add(questionNumber);

        num2 = new JLabel();
        num2.setText("00");
        num2.setFont(MyFont.bigBigFont());
        num2.setForeground(MyColor.whiteBg());
        num2.setBounds(700, 70, 400, 400);
        panel.add(num2);

        // Boxes

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.defaultColor());
        boxOne.setBounds(360, 150, 290, 300);
        panel.add(boxOne);

        boxTwo = new JLabel();
        boxTwo.setOpaque(true);
        boxTwo.setBackground(MyColor.defaultColor());
        boxTwo.setBounds(660, 150, 290, 300);
        panel.add(boxTwo);

        // Combobox
        List<Course> course = Coursedb.getCourseList(teacher.getId());

        int length = course.size();
        coursess = new String[length];
        int i = 0;
        for (Course c : course) {
            coursess[i] = c.getName(); // c = courseList
            i++;
        }
        courseList = new JList(coursess);
        courseList.setFont(MyFont.smallFont());
        courseList.setBorder(new EmptyBorder(10, 10, 10, 10));
        courseList.setForeground(MyColor.textColor());

        courseList.addMouseListener(this);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(courseList);
        scrollPane.setBounds(40, 150, 300, 450);

        panel.add(scrollPane);

        goToButton = new JButton("Go to Course");
        goToButton.setBounds(360, 500, 400, 50);
        goToButton.setFont(MyFont.primaryFont());
        goToButton.setBackground(MyColor.primaryColor());
        goToButton.setForeground(MyColor.whiteColor());
        goToButton.setFocusPainted(false);
        goToButton.addActionListener(this);
        goToButton.setEnabled(false);
        panel.add(goToButton);

        deleteButton = new JButton("Delete Course");
        deleteButton.setBounds(780, 500, 170, 50);
        deleteButton.setFont(MyFont.primaryFont());
        deleteButton.setForeground(MyColor.whiteColor());
        deleteButton.setBackground(MyColor.dangerColor());
        deleteButton.addActionListener(this);
        deleteButton.setEnabled(false);
        panel.add(deleteButton);

        this.add(panel);

        // backButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCourse) {
            this.dispose();
            // NAVIGATION
            System.out.println("action performed: add course: " + teacher.getName());
            AddCourse f = new AddCourse(teacher, home);
            f.setLocationRelativeTo(null);
            f.setResizable(false);
            f.setVisible(true);

        } else if (e.getSource() == goToButton) {

            this.dispose();
            // navigation
            CoursePage cc = new CoursePage(teacher, selectedCourse);
            cc.setLocationRelativeTo(null);
            cc.setResizable(false);
            cc.setVisible(true);

        } else if (e.getSource() == logoutButton) {
            home = new Home();
            this.dispose();
            home.setLocationRelativeTo(null);
            home.setResizable(false);
            home.setVisible(true);

        } else if (e.getSource() == deleteButton) {
            Coursedb.deleteCourse(selectedCourse.getId());
            dispose();
            // NAVIGATION
            TeacherHome teacherHome = new TeacherHome(teacher);
            teacherHome.setLocationRelativeTo(null);
            teacherHome.setResizable(false);
            teacherHome.setVisible(true);

        }

    }

    public void mouseClicked(MouseEvent e) {

        // String str2 = "123";
        if (e.getSource() == courseList) {

            goToButton.setEnabled(true);
            deleteButton.setEnabled(true);

            int selected = courseList.getSelectedIndex();

            // System.out.println(selected);

            List<Course> c = Coursedb.getCourseList(teacher.getId());

            selectedCourse = c.get(selected);

            int indice = c.get(selected).getId();
            courseId = selected;
            theCourse = c.get(selected).getName();

            loginSuccess.setText(theCourse + " is now selected");

            String str = Coursedb.getNumberOfStudents(indice);
            num1.setText(str);

            String str2 = Coursedb.getNumberOfQuestions(indice);
            num2.setText(str2);

        } else {

        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        // try {
        // // print something here
        // Thread.sleep(3000); // sleep for 3 seconds
        // // print something else here
        // loginSuccess.setText("");
        // } catch (InterruptedException ea) {
        // System.out.println("got interrupted!");
        // }
    }

    public void mouseExited(MouseEvent e) {
    }

}
