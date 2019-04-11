package teacher;

import javax.swing.*;

public class Exam extends JFrame {
    private JLabel questionList, sampleQues;
    private JButton examButton, studentButton;

    private JPanel panel;

    public Exam() {

        super("Exam");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        questionList = new JLabel("Avaibale Exams");
        questionList.setBounds(380, 50, 150, 30);
        panel.add(questionList);

        examButton = new JButton("Marks");
        examButton.setBounds(100, 100, 150, 30);
        panel.add(examButton);

        studentButton = new JButton("Create Exam");
        studentButton.setBounds(100, 300, 150, 30);
        panel.add(studentButton);

        // List of questions will be here

        sampleQues = new JLabel("Exam. hahaahahahahahahahahahahaahaha");
        sampleQues.setBounds(380, 100, 500, 20);
        panel.add(sampleQues);

        this.add(panel);

    }
}