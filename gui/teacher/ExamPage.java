package gui.teacher;

import gui.utilities.*;
import dbfunctions.Coursedb;
import dbfunctions.Teacherdb;
import dbfunctions.Examdb;

import classes.*;

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

    private JList examList;

    // navigation
    private Teacher teacher;
    private Course course;

    public ExamPage(Teacher teacher, Course course) {

        super("Exam Page");

        this.teacher = teacher;
        this.course = course;
        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        // Navbar

        // Buttons

        addExam = new JButton("Create Exam");
        addExam.setBackground(MyColor.primaryColor());
        addExam.setForeground(MyColor.whiteColor());
        addExam.setFocusPainted(false);
        addExam.setBounds(400, 45, 200, 50);
        addExam.setFont(MyFont.mediumFont());
        addExam.addActionListener(this);
        panel.add(addExam);

        welcome = new JLabel("Course: " + course.getName());
        welcome.setFont(MyFont.mediumFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(700, 18, 300, 25);
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

        title = new JLabel("Available Exams: ");
        title.setFont(MyFont.smallFont());
        title.setBounds(145, 120, 200, 25);
        panel.add(title);

        // Texts

        studentNumber = new JLabel("Questions");
        studentNumber.setFont(MyFont.bigFont());
        studentNumber.setForeground(MyColor.whiteColor());
        studentNumber.setBounds(420, 380, 250, 50);
        panel.add(studentNumber);

        num1 = new JLabel();
        num1.setText("00");
        num1.setFont(MyFont.bigBigFont());
        num1.setForeground(MyColor.whiteColor());
        num1.setBounds(390, 70, 400, 400);
        panel.add(num1);

        questionNumber = new JLabel("Minutes");
        questionNumber.setFont(MyFont.bigFont());
        questionNumber.setForeground(MyColor.whiteColor());
        questionNumber.setBounds(735, 380, 250, 50);
        panel.add(questionNumber);

        num2 = new JLabel();
        num2.setText("00");
        num2.setFont(MyFont.bigBigFont());
        num2.setForeground(MyColor.whiteColor());
        num2.setBounds(700, 70, 400, 400);
        panel.add(num2);

        // Boxes

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.defaultColor());
        boxOne.setBounds(360, 150, 290, 300);
        panel.add(boxOne);

        boxTwo = new JLabel();
        boxTwo.setOpaque(true);
        boxTwo.setBackground(MyColor.defaultColor());
        boxTwo.setBounds(660, 150, 290, 300);
        panel.add(boxTwo);

        // Combobox

        List<Exam> exam = Examdb.getExamList(course.getId());

        int length = exam.size();
        exams = new String[length];
        int i = 0;
        for (Exam c : exam) {
            exams[i] = c.getDescription();
            i++;
        }
        examList = new JList(exams);
        examList.setFont(MyFont.smallFont());
        examList.setBorder(new EmptyBorder(10, 10, 10, 10));
        examList.setForeground(MyColor.textColor());
        examList.addMouseListener(this);

        JScrollPane scrollPaneTwo = new JScrollPane();
        scrollPaneTwo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setViewportView(examList);
        scrollPaneTwo.setBounds(40, 150, 300, 450);
        panel.add(scrollPaneTwo);

        publish = new JButton("Publish");
        publish.setBounds(360, 500, 180, 50);
        publish.setFont(MyFont.primaryFont());
        publish.setForeground(MyColor.whiteColor());
        publish.setBackground(MyColor.successColor());
        publish.setEnabled(false);
        publish.setFocusPainted(false);
        publish.addActionListener(this);
        panel.add(publish);

        getMarks = new JButton("Get Marks");
        getMarks.setBounds(570, 500, 180, 50);
        getMarks.setFont(MyFont.primaryFont());
        getMarks.setForeground(MyColor.whiteColor());
        getMarks.setEnabled(false);
        getMarks.setBackground(MyColor.deepPurpleColor());
        getMarks.addActionListener(this);
        panel.add(getMarks);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(780, 500, 170, 50);
        deleteButton.setFont(MyFont.primaryFont());
        deleteButton.setForeground(MyColor.whiteColor());
        deleteButton.setBackground(MyColor.dangerColor());
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        this.add(panel);

        // backButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addExam) {
            this.dispose();
            AddExam addExam = new AddExam(teacher, course);
            addExam.setLocationRelativeTo(null);
            addExam.setResizable(false);
            addExam.setVisible(true);

        } else if (e.getSource() == getMarks) {
            this.dispose();
            System.out.println("getMarks: " + examId);
            MarksList getmark = new MarksList(teacher, course, examId);
            getmark.setLocationRelativeTo(null);
            getmark.setResizable(false);
            getmark.setVisible(true);

        } else if (e.getSource() == publish) {

            confirmDelete = new JOptionPane();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = confirmDelete.showConfirmDialog(null, "Are you sure to publish the exam?",
                    "Confirmation", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                Examdb.publishExam(examId);
                JOptionPane.showMessageDialog(null, "Exam Published!", "Done!", JOptionPane.INFORMATION_MESSAGE);
                publish.setEnabled(false);
                getMarks.setEnabled(true);
            }

        } else if (e.getSource() == backButton) {
            this.dispose();
            CoursePage cc = new CoursePage(teacher, course);
            cc.setLocationRelativeTo(null);
            cc.setResizable(false);
            cc.setVisible(true);

        } else if (e.getSource() == deleteButton) {
            System.out.println("Delete question Clicked");

            confirmDelete = new JOptionPane();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = confirmDelete.showConfirmDialog(null, "Are you sure to delete the course?",
                    "Confirmation", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                Examdb.deleteExam(examId);
                this.dispose();
                ExamPage ep = new ExamPage(teacher, course);
                ep.setLocationRelativeTo(null);
                ep.setResizable(false);
                ep.setVisible(true);
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

            List<Exam> c = Examdb.getExamList(course.getId());

            int indice = c.get(selected).getId();
            examId = indice;
            System.out.println("examID: " + examId);
            int str = c.get(selected).getDuration();

            // for disabling button
            if (c.get(selected).getIsPublished() == 1) {
                publish.setEnabled(false);
                getMarks.setEnabled(true);
            } else {
                getMarks.setEnabled(false);

            }

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