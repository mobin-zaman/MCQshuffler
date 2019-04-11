package teacher;


import java.lang.*;
import javax.swing.*;

public class Course extends JFrame {

    private JLabel questionList, sampleQues;
    private JButton examButton, studentButton;

    private JPanel panel;

    public Course() {

        super("single course");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        questionList = new JLabel("Question List ");
        questionList.setBounds(380, 50, 150, 30);
        panel.add(questionList);

        examButton = new JButton("Create Exam");
        examButton.setBounds(100, 100, 150, 30);
        panel.add(examButton);

        studentButton = new JButton("Avaiable Students");
        studentButton.setBounds(100, 300, 150, 30);
        panel.add(studentButton);

        // List of questions will be here

        sampleQues = new JLabel("Question01. hahaahahahahahahahahahahaahaha");
        sampleQues.setBounds(380, 100, 500, 20);
        panel.add(sampleQues);

        this.add(panel);

    }
}