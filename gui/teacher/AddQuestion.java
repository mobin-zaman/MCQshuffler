package gui.teacher;

import gui.utilities.*;
import dbfunctions.*;
import classes.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddQuestion extends JFrame implements ActionListener {

    private int courseId;

    private JLabel ques, choice1, choice2, choice3, choice4, headerOne, navBar, welcome;
    private JTextField quesField, choice1Field, choice2Field, choice3Field, choice4Field;
    private JButton addQuestionButton, backButton;

    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private ButtonGroup boxCombo;

    private JPanel panel;
    private JOptionPane errorMessage, errorPane, successPane;

    JToggleButton toggleButton;

    // navigation
    private Teacher teacher;
    private Course course;

    public AddQuestion(Teacher teacher, Course course) {

        super("Add Question");

        // private navigation
        this.teacher = teacher;
        this.course = course;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(MyColor.whiteColor());
        panel.setLayout(null);

        // Navbar
        welcome = new JLabel("Course: " + course.getName());
        welcome.setFont(MyFont.primaryFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(300, 18, 400, 25);
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

        headerOne = new JLabel("*Add your Question here");
        headerOne.setBounds(300, 100, 200, 40);
        headerOne.setFont(MyFont.primaryFont());
        headerOne.setForeground(MyColor.textColor());
        panel.add(headerOne);

        headerOne = new JLabel("(Check the correct option)");
        headerOne.setBounds(505, 100, 250, 40);
        headerOne.setFont(MyFont.smallFont());
        headerOne.setForeground(MyColor.dangerColor());
        panel.add(headerOne);

        // Labels with inputs

        ques = new JLabel("Question: ");
        ques.setFont(MyFont.primaryFont());
        ques.setBounds(180, 210, 200, 20);
        ques.setForeground(MyColor.textColor());
        panel.add(ques);

        quesField = new JTextField();
        quesField.setBounds(300, 190, 400, 60);
        quesField.setFont(MyFont.primaryFont());
        panel.add(quesField);

        choice1 = new JLabel("Option one: ");
        choice1.setFont(MyFont.primaryFont());
        choice1.setBounds(180, 282, 150, 20);
        choice1.setForeground(MyColor.textColor());
        panel.add(choice1);

        choice1Field = new JTextField();
        choice1Field.setBounds(300, 280, 400, 40);
        choice1Field.setFont(MyFont.primaryFont());
        panel.add(choice1Field);

        choice2 = new JLabel("Option two: ");
        choice2.setFont(MyFont.primaryFont());
        choice2.setBounds(180, 332, 200, 20);
        choice2.setForeground(MyColor.textColor());
        panel.add(choice2);

        choice2Field = new JTextField();
        choice2Field.setBounds(300, 330, 400, 40);
        choice2Field.setFont(MyFont.primaryFont());
        panel.add(choice2Field);

        choice3 = new JLabel("Option three: ");
        choice3.setFont(MyFont.primaryFont());
        choice3.setBounds(180, 382, 200, 20);
        choice3.setForeground(MyColor.textColor());
        panel.add(choice3);

        choice3Field = new JTextField();
        choice3Field.setBounds(300, 380, 400, 40);
        choice3Field.setFont(MyFont.primaryFont());
        panel.add(choice3Field);

        choice4 = new JLabel("Option four: ");
        choice4.setFont(MyFont.primaryFont());
        choice4.setBounds(180, 432, 200, 20);
        choice4.setForeground(MyColor.textColor());
        panel.add(choice4);

        choice4Field = new JTextField();
        choice4Field.setBounds(300, 430, 400, 40);
        choice4Field.setFont(MyFont.primaryFont());
        panel.add(choice4Field);

        // Check Boxes

        checkOne = new JCheckBox();
        checkTwo = new JCheckBox();
        checkThree = new JCheckBox();
        checkFour = new JCheckBox();

        boxCombo = new ButtonGroup();
        boxCombo.add(checkOne);
        boxCombo.add(checkTwo);
        boxCombo.add(checkThree);
        boxCombo.add(checkFour);

        checkOne.setOpaque(false);
        checkTwo.setOpaque(false);
        checkThree.setOpaque(false);
        checkFour.setOpaque(false);

        // Icon gu = new ImageIcon("icon.png");
        // // Icon guu = new ImageIcon("Sicon.png");
        // checkOne.setIcon(gu);
        // checkOne.setSelectedIcon(gu);
        // // c2.setSelectedIcon(guu);

        checkOne.setBounds(720, 280, 50, 30);
        panel.add(checkOne);
        checkTwo.setBounds(720, 330, 50, 30);
        panel.add(checkTwo);
        checkThree.setBounds(720, 380, 50, 30);
        panel.add(checkThree);
        checkFour.setBounds(720, 430, 50, 30);
        panel.add(checkFour);

        // Button

        addQuestionButton = new JButton("ADD Question");
        addQuestionButton.setBounds(300, 520, 400, 40);
        addQuestionButton.setFont(MyFont.primaryFont());
        addQuestionButton.setForeground(MyColor.whiteColor());
        addQuestionButton.setBackground(MyColor.primaryColor());
        addQuestionButton.addActionListener(this);
        panel.add(addQuestionButton);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {

        System.out.println("Action perfoered");
        if (e.getSource() == addQuestionButton) {

            if (quesField.getText().equals("") || choice1Field.getText().equals("") || choice2Field.getText().equals("")
                    || choice3Field.getText().equals("") || choice4Field.getText().equals("")
                    || boxCombo.getSelection() == null) {

                errorMessage = new JOptionPane();
                errorMessage.setFont(MyFont.primaryFont());
                errorMessage.showMessageDialog(null, "All fields are required!", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);

            }

            else {

                String correctChoice = null;

                String questionItself = quesField.getText();
                String choice1 = choice1Field.getText();
                String choice2 = choice2Field.getText();
                String choice3 = choice3Field.getText();
                String choice4 = choice4Field.getText();

                if (checkOne.isSelected()) {
                    correctChoice = choice1;
                } else if (checkTwo.isSelected()) {
                    correctChoice = choice2;
                } else if (checkThree.isSelected()) {
                    correctChoice = choice3;
                } else if (checkFour.isSelected()) {
                    correctChoice = choice4;
                }
                System.out.println("DEBUG: course.getId(): " + course.getId());
                System.out
                        .println(questionItself + choice1 + choice2 + choice3 + choice4 + "Correct: " + correctChoice);
                Questiondb.insertQuestion(new Question(course.getId(), questionItself, choice1, choice2, choice3,
                        choice4, correctChoice));
                // Database checking here

                // Go back to home
                successPane = new JOptionPane();
                successPane.setFont(MyFont.primaryFont());
                successPane.showMessageDialog(null, "Question Added", "Success!", JOptionPane.WARNING_MESSAGE);
                quesField.setText("");
                choice1Field.setText("");
                choice2Field.setText("");
                choice3Field.setText("");
                choice4Field.setText("");

            }

        } else if (e.getSource() == backButton)

        {
            dispose();
            CoursePage cp = new CoursePage(teacher, course);
            cp.setLocationRelativeTo(null);
            cp.setResizable(false);
            cp.setVisible(true);
        } else {

        }
    }

}