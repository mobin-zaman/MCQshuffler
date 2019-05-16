package gui.teacher;

import gui.utilities.*;

import dbfunctions.Examdb;
import dbfunctions.Coursedb;

import classes.*;

import java.awt.Color;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class AddExam extends JFrame implements ActionListener {

    // private String teacherName, teacherId;
    // private int courseId;

    private JLabel navBar, headerOne, examName, welcome, numberOfQuestion;
    private JTextField examNameField, numberOfQuestionField;

    // FIXME: set bounds for the below two lebels
    // default value should be 00:00
    private JLabel examDurationEntryField;
    private JTextField examHourField;
    private JTextField examMinuteField;

    private JButton createExam, backButton;
    private JPanel panel;
    JToggleButton toggleButton;

    // navigation
    private Teacher teacher;
    private Course course;
    private String totalQuestions;

    public AddExam(Teacher teacher, Course course) {

        super("Add Exam");
        System.out.println("asheche");

        this.teacher = teacher;
        this.course = course;

        System.out.println("Course ID here: " + course.getId());

        totalQuestions = Coursedb.getNumberOfQuestions(course.getId());
        System.out.println("Total Quesions: " + totalQuestions);

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(MyColor.whiteBg());
        panel.setLayout(null);

        // Navbar
        welcome = new JLabel("Course: " + course.getName());
        welcome.setFont(MyFont.primaryFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(550, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(40, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Teacher Login Elements

        headerOne = new JLabel("Create Exam here");
        headerOne.setBounds(372, 120, 400, 40);
        headerOne.setFont(MyFont.headerFont());
        headerOne.setForeground(MyColor.textColor());
        panel.add(headerOne);

        examName = new JLabel("Exam Name: ");
        examName.setFont(MyFont.smallFont());
        examName.setBounds(300, 200, 200, 20);
        examName.setForeground(MyColor.textColor());
        panel.add(examName);

        examNameField = new JTextField();
        examNameField.setBounds(300, 230, 400, 40);
        examNameField.setFont(MyFont.primaryFont());
        panel.add(examNameField);

        examDurationEntryField = new JLabel("Exam Duration: (HH:MM)");
        examDurationEntryField.setFont(MyFont.smallFont());
        examDurationEntryField.setBounds(300, 300, 400, 20);
        examDurationEntryField.setForeground(MyColor.textColor());
        panel.add(examDurationEntryField);

        // FIXME: setbounds for the below two labels

        examHourField = new JTextField();
        examHourField.setBounds(300, 330, 190, 40);
        examHourField.setFont(MyFont.primaryFont());
        panel.add(examHourField);

        examMinuteField = new JTextField();
        examMinuteField.setBounds(500, 330, 190, 40);
        examMinuteField.setFont(MyFont.primaryFont());
        panel.add(examMinuteField);

        numberOfQuestion = new JLabel("Number of Questions: (Max " + totalQuestions + ")");
        numberOfQuestion.setFont(MyFont.smallFont());
        numberOfQuestion.setBounds(300, 400, 400, 20);
        numberOfQuestion.setForeground(MyColor.textColor());
        panel.add(numberOfQuestion);

        numberOfQuestionField = new JTextField();
        numberOfQuestionField.setBounds(300, 430, 400, 40);
        numberOfQuestionField.setFont(MyFont.primaryFont());
        panel.add(numberOfQuestionField);

        createExam = new JButton("Create Exam");
        createExam.setBounds(300, 530, 400, 40);
        createExam.setFont(MyFont.primaryFont());
        createExam.setForeground(MyColor.whiteColor());
        createExam.setBackground(MyColor.primaryColor());
        createExam.addActionListener(this);
        panel.add(createExam);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createExam) {

            if (examNameField.getText().equals("") || examHourField.getText().equals("")
                    || examMinuteField.getText().equals("") || numberOfQuestionField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are required!", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {
                int enterQuestions = Integer.valueOf(numberOfQuestionField.getText());
                int maxQuesions = Integer.valueOf(totalQuestions);

                if (enterQuestions <= maxQuesions && enterQuestions >= 1) {

                    String descripton = examNameField.getText();
                    // FIXME: change the gui, for hh:mm, I am doing the math here
                    int examHour = Integer.parseInt(examHourField.getText());
                    int duration = examHour * 60;
                    int examMinute = Integer.parseInt(examMinuteField.getText());
                    duration += examMinute;
                    // FIXME: while showing the exam duration, we have to do the revers of this
                    int numberOfQuestion = Integer.parseInt(numberOfQuestionField.getText());

                    // Database checking here
                    if (Examdb.createExam(course.getId(), descripton, numberOfQuestion, duration)) {
                        examNameField.setText("");
                        examHourField.setText("");
                        examMinuteField.setText("");
                        numberOfQuestionField.setText("");
                        JOptionPane.showMessageDialog(null, "Exam Created Successfully!", "Success!",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please insert valid data types", "Error!",
                                JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No of questions  should be between 1 to maximum number)",
                            "Error!", JOptionPane.WARNING_MESSAGE);
                }

            }

        } else if (e.getSource() == backButton) {
            dispose();
            ExamPage tm = new ExamPage(teacher, course);
            tm.setLocationRelativeTo(null);
            tm.setResizable(false);
            tm.setVisible(true);
        }

    }
}