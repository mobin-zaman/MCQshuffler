package gui.teacher;

import gui.components.*;
import dbfunctions.Coursedb;
import dbfunctions.Teacherdb;
import dbfunctions.Examdb;
import classes.Course;
import classes.Exam;

import javax.swing.border.EmptyBorder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ExamPage extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, boxOne, boxTwo, welcome, title, studentNumber, questionNumber, num1, num2, loginSuccess;
    private JButton addExam, backButton, courseName, publish, getMarks, deleteButton;

    private JPanel panel;
    private JOptionPane confirmDelete;
    private String teacherName, teacherId;
    private int courseId;
    private int examId;
    private String theCourse;
    private String exams[];

    private List<Exam> exam;

    // Components
    private MyColor color;
    private MyFont font;

    private JList examList;

    public ExamPage(String tName, String tId, int cId) {

        super("Exam Page");

        teacherName = tName;
        teacherId = tId;
        courseId = cId;
        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        color = new MyColor();
        font = new MyFont();

        // Navbar

        welcome = new JLabel("Course name Here");
        welcome.setFont(font.getMediumFont());
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

        // Buttons

        addExam = new JButton("Create Exam");

        addExam.setFont(font.getMediumFont());
        addExam.setBackground(color.getButtonColor());
        addExam.setForeground(color.getBgColor());
        addExam.setFocusPainted(false);
        addExam.setBounds(40, 70, 200, 50);
        addExam.addActionListener(this);
        panel.add(addExam);

        title = new JLabel("Exam List");
        title.setFont(font.getTinyFont());
        title.setBounds(150, 125, 120, 25);
        panel.add(title);

        // Texts

        studentNumber = new JLabel("Questions");
        studentNumber.setFont(font.getBigFont());
        studentNumber.setForeground(color.getBgColor());
        studentNumber.setBounds(420, 380, 250, 50);
        panel.add(studentNumber);

        num1 = new JLabel();
        num1.setText("00");
        num1.setFont(font.getBigBigFont());
        num1.setForeground(color.getBgColor());
        num1.setBounds(390, 70, 400, 400);
        panel.add(num1);

        questionNumber = new JLabel("Duration");
        questionNumber.setFont(font.getBigFont());
        questionNumber.setForeground(color.getBgColor());
        questionNumber.setBounds(720, 380, 250, 50);
        panel.add(questionNumber);

        num2 = new JLabel();
        num2.setText("00");
        num2.setFont(font.getBigBigFont());
        num2.setForeground(color.getBgColor());
        num2.setBounds(700, 70, 400, 400);
        panel.add(num2);

        // Boxes

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(color.gettBackgroundColor());
        boxOne.setBounds(360, 150, 290, 300);
        panel.add(boxOne);

        boxTwo = new JLabel();
        boxTwo.setOpaque(true);
        boxTwo.setBackground(color.gettBackgroundColor());
        boxTwo.setBounds(660, 150, 290, 300);
        panel.add(boxTwo);

        // Combobox

        List<Exam> exam = Examdb.getExamList(courseId);

        int length = exam.size();
        exams = new String[length];
        int i = 0;
        for (Exam c : exam) {
            exams[i] = c.getDescription();
            i++;
        }
        examList = new JList(exams);
        examList.setFont(font.getMediumFont());
        examList.setBorder(new EmptyBorder(10, 10, 10, 10));
        examList.setForeground(color.getTextColor());
        examList.setBounds(40, 150, 300, 450);
        examList.addMouseListener(this);

        panel.add(examList);

        publish = new JButton("Publish");
        publish.setBounds(360, 500, 180, 50);
        publish.setFont(font.getprimaryFont());
        publish.setForeground(color.getBgColor());
        publish.setBackground(color.getButtonColor());
        publish.setEnabled(false);
        publish.setFocusPainted(false);
        publish.addActionListener(this);
        panel.add(publish);

        getMarks = new JButton("Get Marks");
        getMarks.setBounds(570, 500, 180, 50);
        getMarks.setFont(font.getprimaryFont());
        getMarks.setForeground(color.getBgColor());
        getMarks.setEnabled(false);
        getMarks.setBackground(color.getDelteButtonColor());
        getMarks.addActionListener(this);
        panel.add(getMarks);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(780, 500, 180, 50);
        deleteButton.setFont(font.getprimaryFont());
        deleteButton.setForeground(color.getBgColor());
        deleteButton.setBackground(color.getDelteButtonColor());
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        this.add(panel);

        // backButton.addActionListener(this);

    }

    public void getUser(String name) {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addExam) {
            this.dispose();
            AddExam f = new AddExam(teacherName, teacherId, courseId);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        } else if (e.getSource() == publish) {

            this.dispose();
            CoursePage cc = new CoursePage(teacherName, teacherId, courseId);
            cc.setLocationRelativeTo(null);
            cc.setVisible(true);

        } else if (e.getSource() == backButton) {
            this.dispose();
            CoursePage cc = new CoursePage(teacherName, teacherId, courseId);
            cc.setLocationRelativeTo(null);
            cc.setVisible(true);

        } else if (e.getSource() == deleteButton) {
            System.out.println("Delete question Clicked");

            confirmDelete = new JOptionPane();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = confirmDelete.showConfirmDialog(null, "Are you sure to delete the course?", "Warning",
                    dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                Examdb.deleteExam(examId);
                this.dispose();
                ExamPage cp = new ExamPage(teacherName, teacherId, courseId);
                cp.setLocationRelativeTo(null);
                cp.setVisible(true);
            }
        }

    }

    public void mouseClicked(MouseEvent e) {

        // String str2 = "123";
        if (e.getSource() == examList) {
            publish.setEnabled(true);
            getMarks.setEnabled(true);
            deleteButton.setEnabled(true);

            int selected = examList.getSelectedIndex();

            // System.out.println(selected);

            List<Exam> c = Examdb.getExamList(courseId);

            int indice = c.get(selected).getId();
            examId = indice;
            int str = c.get(selected).getDuration();

            num2.setText(Integer.toString(str));

            System.out.println(str);

            int str2 = Examdb.getNumberOfQuestions(c.get(selected).getId());
            num1.setText(Integer.toString(str2));

        }

        else {

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