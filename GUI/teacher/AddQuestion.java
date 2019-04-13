package gui.teacher;

import gui.components.*;
import dbfunctions.*;
import classes.Question;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddQuestion extends JFrame implements ActionListener {

    private String teacherName, teacherId;

    private int courseId;

    private JLabel ques, choice1, choice2, choice3, choice4, headerOne, navBar, welcome;
    private JTextField quesField, choice1Field, choice2Field, choice3Field, choice4Field;
    private JButton addQuestionButton, backButton;

    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private ButtonGroup boxCombo;

    private JPanel panel;
    private JOptionPane errorMessage, errorPane, successPane;

    // Components
    private MyColor color;
    private MyFont font;

    JToggleButton toggleButton;

    public AddQuestion(String name, String ID, int cId) {

        super("Add Question");

        teacherName = name;
        teacherId = ID;
        courseId = cId;

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
        headerOne.setBounds(380, 90, 400, 40);
        headerOne.setFont(font.getHeaderFont());
        headerOne.setForeground(color.getTextColor());
        panel.add(headerOne);

        // Labels with inputs

        ques = new JLabel("Question: ");
        ques.setFont(font.getprimaryFont());
        ques.setBounds(208, 210, 200, 20);
        ques.setForeground(color.getTextColor());
        panel.add(ques);

        quesField = new JTextField();
        quesField.setBounds(300, 190, 400, 60);
        quesField.setFont(font.getprimaryFont());
        panel.add(quesField);

        choice1 = new JLabel("Option one: ");
        choice1.setFont(font.getprimaryFont());
        choice1.setBounds(185, 282, 150, 20);
        choice1.setForeground(color.getTextColor());
        panel.add(choice1);

        choice1Field = new JTextField();
        choice1Field.setBounds(300, 280, 400, 40);
        choice1Field.setFont(font.getprimaryFont());
        panel.add(choice1Field);

        choice2 = new JLabel("Option two: ");
        choice2.setFont(font.getprimaryFont());
        choice2.setBounds(185, 332, 200, 20);
        choice2.setForeground(color.getTextColor());
        panel.add(choice2);

        choice2Field = new JTextField();
        choice2Field.setBounds(300, 330, 400, 40);
        choice2Field.setFont(font.getprimaryFont());
        panel.add(choice2Field);

        choice3 = new JLabel("Option three: ");
        choice3.setFont(font.getprimaryFont());
        choice3.setBounds(175, 382, 200, 20);
        choice3.setForeground(color.getTextColor());
        panel.add(choice3);

        choice3Field = new JTextField();
        choice3Field.setBounds(300, 380, 400, 40);
        choice3Field.setFont(font.getprimaryFont());
        panel.add(choice3Field);

        choice4 = new JLabel("Option four: ");
        choice4.setFont(font.getprimaryFont());
        choice4.setBounds(185, 432, 200, 20);
        choice4.setForeground(color.getTextColor());
        panel.add(choice4);

        choice4Field = new JTextField();
        choice4Field.setBounds(300, 430, 400, 40);
        choice4Field.setFont(font.getprimaryFont());
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

        // Icon gu = new ImageIcon("icon.png");
        // // Icon guu = new ImageIcon("Sicon.png");
        // checkOne.setIcon(gu);
        // checkOne.setSelectedIcon(gu);
        // // c2.setSelectedIcon(guu);

        checkOne.setBounds(750, 280, 50, 30);
        panel.add(checkOne);
        checkTwo.setBounds(750, 330, 50, 30);
        panel.add(checkTwo);
        checkThree.setBounds(750, 380, 50, 30);
        panel.add(checkThree);
        checkFour.setBounds(750, 430, 50, 30);
        panel.add(checkFour);

        // Button

        addQuestionButton = new JButton("ADD Question");
        addQuestionButton.setBounds(300, 520, 400, 40);
        addQuestionButton.setFont(font.getprimaryFont());
        addQuestionButton.setForeground(color.getBgColor());
        addQuestionButton.setBackground(color.getButtonColor());
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

                System.out.println("Dhukse");

                errorMessage = new JOptionPane();
                errorMessage.setFont(font.getprimaryFont());
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
                System.out
                        .println(questionItself + choice1 + choice2 + choice3 + choice4 + "Correct: " + correctChoice);
                Questiondb.insertQuestion(
                        new Question(courseId, questionItself, choice1, choice2, choice3, choice4, correctChoice));
                // Database checking here

                // Go back to home
                successPane = new JOptionPane();
                successPane.setFont(font.getprimaryFont());
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
            CoursePage tm = new CoursePage(teacherName, teacherId, courseId);
            tm.setLocationRelativeTo(null);
            tm.setVisible(true);
        } else {

        }
    }

}