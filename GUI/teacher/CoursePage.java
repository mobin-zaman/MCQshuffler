package gui.teacher;

import gui.components.*;
import dbfunctions.Questiondb;
import dbfunctions.Coursedb;
import classes.Course;
import classes.Question;

import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CoursePage extends JFrame implements ActionListener {

    private JLabel navBar, titleBar, welcome, boxOne, title;
    private JButton addQuestion, addExam, students, requests, logoutButton, updateButton;

    private JScrollPane scrollPane;

    private JList questionList;

    private String name;
    private int courseId;

    private JPanel panel;

    // Components
    private MyColor color;
    private MyFont font;

    public CoursePage(String name, int courseId) {

        super(name);

        this.name = name;
        this.courseId = courseId;

        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        color = new MyColor();
        font = new MyFont();

        // Navbar

        welcome = new JLabel(name);
        welcome.setFont(font.getMediumFont());
        welcome.setForeground(color.getBgColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(font.getprimaryFont());
        logoutButton.setBackground(color.getsecondaryButtonColor());
        logoutButton.setForeground(color.getBgColor());
        logoutButton.setFocusPainted(false);
        logoutButton.setBounds(850, 13, 100, 35);
        panel.add(logoutButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(color.getNavbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Buttons

        addQuestion = new JButton("ADD Question");
        addQuestion.setFont(font.getMediumFont());
        addQuestion.setBackground(color.getButtonColor());
        addQuestion.setForeground(color.getBgColor());
        addQuestion.setFocusPainted(false);
        addQuestion.setBounds(30, 100, 200, 80);
        panel.add(addQuestion);

        addExam = new JButton("Exam");
        addExam.setFont(font.getMediumFont());
        addExam.setBackground(color.getButtonColor());
        addExam.setForeground(color.getBgColor());
        addExam.setFocusPainted(false);
        addExam.setBounds(30, 240, 200, 80);
        panel.add(addExam);

        students = new JButton("Student List");
        students.setFont(font.getMediumFont());
        students.setBackground(color.getButtonColor());
        students.setForeground(color.getBgColor());
        students.setFocusPainted(false);
        students.setBounds(30, 380, 200, 80);
        panel.add(students);

        requests = new JButton("Requests");
        requests.setFont(font.getMediumFont());
        requests.setBackground(color.getButtonColor());
        requests.setForeground(color.getBgColor());
        requests.setFocusPainted(false);
        requests.setBounds(30, 520, 200, 80);
        panel.add(requests);

        titleBar = new JLabel();
        titleBar.setOpaque(true);
        titleBar.setBackground(color.gettitleBarColor());
        titleBar.setBounds(255, 100, 2, 500);
        panel.add(titleBar);

        title = new JLabel("Available Questions");
        title.setFont(font.getSmallFont());
        title.setBounds(280, 75, 300, 25);
        panel.add(title);

        List<Question> questionL = Questiondb.getAllQuestionList(courseId);

        int length = questionL.size();
        String questions[] = new String[length];
        int i = 0;

        for (Question c : questionL) {
            questions[i] = c.getDescription();
            i++;
            System.out.println(c.getDescription());
        }

        questionList = new JList(questions);
        questionList.setFont(font.getMediumFont());
        questionList.setForeground(color.getTextColor());
        questionList.setBounds(280, 100, 300, 500);
        panel.add(questionList);
        // questionList.addMouseListener(this);

        // JScrollPane scrollPane = new JScrollPane();
        // scrollPane.setViewportView(questionList);

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(color.gettBackgroundColor());
        boxOne.setBounds(600, 100, 355, 300);
        panel.add(boxOne);

        updateButton = new JButton("Update Question");
        updateButton.setFont(font.getMediumFont());
        updateButton.setBackground(color.getEditButtonColor());
        updateButton.setForeground(color.getBgColor());
        updateButton.setFocusPainted(false);
        updateButton.setBounds(652, 450, 250, 50);
        panel.add(updateButton);

        // editButton = new JButton("Edit");
        // editButton.setBounds(440, 260,100,30);
        // editButton.setFont(font.getprimaryFont());
        // editButton.setForeground(color.getBgColor());
        // editButton.setBackground(color.getEditButtonColor());
        // editButton.setFocusPainted(false);
        // editButton.addActionListener(this);
        // panel.add(editButton);

        // deleteButton = new JButton("Delete");
        // deleteButton.setBounds(560, 260,100,30);
        // deleteButton.setFont(font.getprimaryFont());
        // deleteButton.setForeground(color.getBgColor());
        // deleteButton.setBackground(color.getDelteButtonColor());
        // deleteButton.addActionListener(this);
        // panel.add(deleteButton);

        this.add(panel);

    }

    public void getUser(String name) {

    }

    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == courseName) {

        // System.out.println("hjahahjauahja");
        // // this.dispose();
        // // TeacherHome f = new TeacherHome();
        // // f.setLocationRelativeTo(null);
        // // f.setVisible(true);
        // // } else if (e.getSource() == homeButton) {
        // // // Home(this);
        // }

    }

    public static void main(String[] args) {
        CoursePage d = new CoursePage("amr bap", 1);
        d.setVisible(true);
    }

}
