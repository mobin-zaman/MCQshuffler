package gui.student;

import classes.*;
import dbfunctions.*;
import gui.utilities.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Collections;
import java.util.List;

//TODO: it will take, student and exam parameter, for the time being I am just working with id
//TODO: gui will come here as well

public class ParticularExam extends JFrame implements ActionListener {

    private LocalTime endTime;
    private List<Question> questions;
    private List<Question> doneAnswering = new ArrayList<Question>();
    private int marks;

    private JPanel panel;
    private JLabel navBar, welcome, ques, choice1, choice2, choice3, choice4, examTime;
    private JButton nextButton;
    private ButtonGroup boxCombo;
    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private JButton next;
    // assigned from checkbox
    private String choice = "";
    private int length;
    private int index = -1;

    // navigation
    Student student;
    Exam exam;

    private int studentId, examId;

    public ParticularExam(Student student, Exam exam) {

        super("Particular Exam");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);

        this.student = student;
        this.exam = exam;
        this.studentId = student.getId();
        this.examId = exam.getId();

        endTime = LocalTime.now().plusMinutes(exam.getDuration());
        System.out.println("endtime::::" + endTime);
        questions = Examdb.getExamQuestions(examId);
        length = questions.size();
        Collections.shuffle(questions);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String examEndTime = (endTime.format(dtf));

        // navbar
        welcome = new JLabel("Exam: " + exam.getDescription());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);
        // String et = (String) endTime;
        examTime = new JLabel("Exam will be finished at: " + examEndTime);
        examTime.setFont(MyFont.primaryFont());
        examTime.setForeground(MyColor.whiteColor());
        examTime.setBounds(500, 13, 500, 35);
        panel.add(examTime);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // others

        ques = new JLabel();
        ques.setFont(MyFont.primaryFont());
        ques.setBounds(180, 210, 550, 20);
        ques.setForeground(MyColor.textColor());
        panel.add(ques);

        choice1 = new JLabel();
        choice1.setFont(MyFont.primaryFont());
        choice1.setBounds(210, 282, 550, 20);
        choice1.setForeground(MyColor.textColor());
        panel.add(choice1);

        choice2 = new JLabel();
        choice2.setFont(MyFont.primaryFont());
        choice2.setBounds(210, 332, 550, 20);
        choice2.setForeground(MyColor.textColor());
        panel.add(choice2);

        choice3 = new JLabel();
        choice3.setFont(MyFont.primaryFont());
        choice3.setBounds(210, 382, 550, 20);
        choice3.setForeground(MyColor.textColor());
        panel.add(choice3);

        choice4 = new JLabel();
        choice4.setFont(MyFont.primaryFont());
        choice4.setBounds(210, 432, 550, 20);
        choice4.setForeground(MyColor.textColor());
        panel.add(choice4);

        // Check Boxes

        checkOne = new JCheckBox();
        checkTwo = new JCheckBox();
        checkThree = new JCheckBox();
        checkFour = new JCheckBox();
        checkOne.addActionListener(this);
        checkTwo.addActionListener(this);
        checkThree.addActionListener(this);
        checkFour.addActionListener(this);

        boxCombo = new ButtonGroup();
        boxCombo.add(checkOne);
        boxCombo.add(checkTwo);
        boxCombo.add(checkThree);
        boxCombo.add(checkFour);

        checkOne.setOpaque(false);
        checkOne.setBounds(180, 280, 50, 30);
        // TODO: set a sweet icon
        // Icon unselIcon = new ImageIcon("no-selected.png");
        // checkOne.setIcon(unselIcon);

        checkTwo.setOpaque(false);
        checkThree.setOpaque(false);
        checkFour.setOpaque(false);

        panel.add(checkOne);
        checkTwo.setBounds(180, 330, 50, 30);
        panel.add(checkTwo);
        checkThree.setBounds(180, 380, 50, 30);
        panel.add(checkThree);
        checkFour.setBounds(180, 430, 50, 30);
        panel.add(checkFour);

        next = new JButton("next");
        next.setBounds(250, 550, 300, 45);
        next.setBackground(MyColor.primaryColor());
        next.setFont(MyFont.primaryFont());
        next.setForeground(MyColor.whiteColor());
        next.addActionListener(this);

        panel.add(next);

        this.add(panel);

        next.doClick();
        // the duration will comefrom Exam objects
        // TODO: first take the system time, then add duration in minutes with it

    }

    // when it will return 0, there is no time
    public long timeLeft() {
        LocalTime time = LocalTime.now();
        System.out.println("endddd::::" + endTime);
        System.out.println("startTime:::" + time);

        long elapsedMinutes = Duration.between(time, endTime).toMinutes();
        System.out.println("elapsed time:::" + elapsedMinutes);
        return elapsedMinutes;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == next) {
            System.out.println("next clickedededed");

            boxCombo.clearSelection();
            next.setEnabled(false);

            if (choice != "") {
                if (questions.get(index).isCorrect(choice)) {
                    marks++;
                }
            }

            index++;
            System.out.println("Index:: " + index);

            if (timeLeft() != 0 && index < length) {

                System.out.println("index::::" + index);
                System.out.println("length:::" + length);
                System.out.println("timeleft():: " + timeLeft());

                ques.setText((index + 1) + ". " + questions.get(index).getDescription());
                // choices
                choice1.setText(questions.get(index).getChoiceOne());
                choice2.setText(questions.get(index).getChoiceTwo());
                choice3.setText(questions.get(index).getChoiceThree());
                choice4.setText(questions.get(index).getChoiceFour());

                System.out.println(questions.get(index).getChoiceOne());
                System.out.println(questions.get(index).getChoiceTwo());
                System.out.println(questions.get(index).getChoiceThree());
                System.out.println(questions.get(index).getChoiceFour());
                System.out.println(questions.get(index).getDescription());

            }

            else {

                System.out.println("you got " + marks + " marks");
                Examdb.insertMarks(examId, studentId, marks);

                if (timeLeft() == 0) {
                    JOptionPane successPane = new JOptionPane();
                    successPane = new JOptionPane();
                    successPane.setFont(MyFont.primaryFont());
                    successPane.showMessageDialog(null, "Time Up! You have got " + marks + " marks!", "Done",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane successPane = new JOptionPane();
                    successPane = new JOptionPane();
                    successPane.setFont(MyFont.primaryFont());
                    successPane.showMessageDialog(null, "Exam finished! You have got " + marks + " marks!", "Done!",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                this.dispose();
                StudentHome shome = new StudentHome(student);
                shome.setVisible(true);
                shome.setLocationRelativeTo(null);

            }

            // get answer

            // it will be replaced by pass
            // the action will happen upon clicking on the next button
            // when user will not select any answer and click next, the they are NOT done
            // answering the question

        }

        if (e.getSource() == checkOne || e.getSource() == checkTwo || e.getSource() == checkFour
                || e.getSource() == checkThree) {
            next.setEnabled(true);
            if (checkOne.isSelected()) {
                choice = choice1.getText();
                System.out.println("Selected Choice:::" + choice);
            }
            if (checkTwo.isSelected()) {
                choice = choice2.getText();
                System.out.println("Selected Choice:::" + choice);
            }
            if (checkThree.isSelected()) {
                choice = choice3.getText();
                System.out.println("Selected Choice:::" + choice);
            }
            if (checkFour.isSelected()) {
                choice = choice4.getText();
                System.out.println("Selected Choice:::" + choice);
            }

        }
    }
}