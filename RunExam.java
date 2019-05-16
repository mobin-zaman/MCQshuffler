
import classes.*;
import dbfunctions.*;
import gui.utilities.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Collections;
import java.util.List;

//TODO: it will take, student and exam parameter, for the time being I am just working with id
//TODO: gui will come here as well


public class RunExam extends JFrame implements ActionListener {

    private LocalTime endTime;
    private List<Question> questions;
    private List<Question> doneAnswering = new ArrayList<Question>();
    private int marks;

    private JPanel panel;
    private JLabel navBar, welcome, ques, choice1, choice2, choice3, choice4;
    private JButton backButton, finishButton, startExam, resultButton, nextButton;
    private JComboBox courseList;
    private ButtonGroup boxCombo;
    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private JButton next;
    private JTextField field;
    // assigned from checkbox
    private String choice = "choice";
    private int length;
    private int index = -1;

    public RunExam(int studentId, int examId) {

        super("Student Exam");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        endTime = LocalTime.now().plusMinutes(2);
        System.out.println("endtime::::" + endTime);
        questions = Examdb.getExamQuestions(examId);
        length = questions.size();
        Collections.shuffle(questions);

        ques = new JLabel();
        ques.setFont(MyFont.primaryFont());
        ques.setBounds(180, 210, 500, 20);
        ques.setForeground(MyColor.textColor());
        panel.add(ques);

        choice1 = new JLabel();
        choice1.setFont(MyFont.primaryFont());
        choice1.setBounds(180, 282, 150, 20);
        choice1.setForeground(MyColor.textColor());
        panel.add(choice1);

        choice2 = new JLabel();
        choice2.setFont(MyFont.primaryFont());
        choice2.setBounds(180, 332, 200, 20);
        choice2.setForeground(MyColor.textColor());
        panel.add(choice2);

        choice3 = new JLabel();
        choice3.setFont(MyFont.primaryFont());
        choice3.setBounds(180, 382, 200, 20);
        choice3.setForeground(MyColor.textColor());
        panel.add(choice3);

        choice4 = new JLabel();
        choice4.setFont(MyFont.primaryFont());
        choice4.setBounds(180, 432, 200, 20);
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
        checkTwo.setOpaque(false);
        checkThree.setOpaque(false);
        checkFour.setOpaque(false);

        checkOne.setBounds(720, 280, 50, 30);
        panel.add(checkOne);
        checkTwo.setBounds(720, 330, 50, 30);
        panel.add(checkTwo);
        checkThree.setBounds(720, 380, 50, 30);
        panel.add(checkThree);
        checkFour.setBounds(720, 430, 50, 30);
        panel.add(checkFour);

        next = new JButton("next");
        next.setBounds(250, 550, 300, 45);
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
        System.out.println("start");

        long elapsedMinutes = Duration.between(time, endTime).toMinutes();
        return elapsedMinutes;
    }

    public static void main(String args[]) {
        RunExam runExam = new RunExam(1, 36);
        runExam.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            boxCombo.clearSelection();
            next.setEnabled(false);

            index++;
            System.out.println("timeleft():: " + timeLeft());

            if (timeLeft() == 0 || index == length) {
                System.out.println("time is up!!!!");

                // FIXME: will be done with marks
                // database insertion will happen here

                System.out.println("you got " + marks + " marks");

                JOptionPane successPane = new JOptionPane();
                successPane = new JOptionPane();
                successPane.setFont(MyFont.primaryFont());
                successPane.showMessageDialog(null, "You have got 0.00 marks!", "Time UP!",
                        JOptionPane.WARNING_MESSAGE);
                System.exit(0);

            }

            ques.setText(questions.get(index).getDescription());
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

            // get answer

            // it will be replaced by pass
            // the action will happen upon clicking on the next button
            // when user will not select any answer and click next, the they are NOT done
            // answering the question

            if (questions.size() == 0) {
                // FIXME: finish;
            }

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