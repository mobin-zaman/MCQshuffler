package gui.teacher;

import gui.components.*;
import dbfunctions.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AddExam extends JFrame implements ActionListener {

    private String teacherName, teacherId;

    private JLabel navbar, headerOne, examName, examDuration;
    private JTextField examNameField, examDurationField;
    private JButton addExamButton, backButton;
    private JPanel panel;
    private JOptionPane errorMessage, errorPane, successPane;

    // Components
    private MyColor color;
    private MyFont font;

    JToggleButton toggleButton;

    public AddExam(String name, String ID) {

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

        headerOne = new JLabel("Create Exam here");
        headerOne.setBounds(380, 120, 400, 40);
        headerOne.setFont(font.getHeaderFont());
        headerOne.setForeground(color.getTextColor());
        panel.add(headerOne);

        examName = new JLabel("Exam description: ");
        examName.setFont(font.getSmallFont());
        examName.setBounds(300, 200, 200, 20);
        examName.setForeground(color.getTextColor());
        panel.add(examName);

        examNameField = new JTextField();
        examNameField.setBounds(300, 250, 400, 40);
        examNameField.setFont(font.getprimaryFont());
        panel.add(examNameField);

        examDuration = new JLabel("Exam Duration");
        examDuration.setFont(font.getSmallFont());
        examDuration.setBounds(300, 350, 200, 20);
        examDuration.setForeground(color.getTextColor());
        panel.add(examDuration);

        examDurationField = new JTextField();
        examDurationField.setBounds(300, 400, 400, 40);
        examDurationField.setFont(font.getprimaryFont());
        panel.add(examDurationField);

        numberOfQuestion = new JLabel("Number of Questions");
        numberOfQuestion.setFont(font.getSmallFont());
        numberOfQuestion.setBounds(300, 500, 200, 20);
        numberOfQuestion.setForeground(color.getTextColor());
        panel.add(numberOfQuestion);

        numberOfQuestionField = new JTextField();
        numberOfQuestionField.setBounds(300, 550, 400, 40);
        numberOfQuestionField.setFont(font.getprimaryFont());
        panel.add(numberOfQuestionField);

        addExamButton = new JButton("Create Exam");
        addExamButton.setBounds(300, 600, 400, 40);
        addExamButton.setFont(font.getprimaryFont());
        addExamButton.setForeground(color.getBgColor());
        addExamButton.setBackground(color.getButtonColor());
        addExamButton.addActionListener(this);
        panel.add(addExamButton);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {

    }

}