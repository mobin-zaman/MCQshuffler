package gui.teacher;

import gui.Home;

import gui.utilities.*;

import dbfunctions.Questiondb;
import dbfunctions.Coursedb;
import classes.Course;
import classes.Question;

//navigation
import classes.Teacher;

import java.util.List;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CoursePage extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, titleBar, welcome, boxOne, title, oneLabel, twoLabel, threeLabel, fourLabel;
    private JButton addQuestion, addExam, studentListButton, requests, logoutButton, updateButton, deleteBtn,
            backButton;
    private JTextField theQuestion, choice1, choice2, choice3, choice4;
    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private ButtonGroup boxCombo;

    private JScrollPane scrollPane;

    private JList questionList;
    JOptionPane confirmDelete, errorMessage, successPane;

    private JPanel panel;

    private List<Question> courseQuestion;

    private int questionId;
    private Question question;

    // navigation
    private Teacher teacher;
    // private Home home;
    private Course course;

    public CoursePage(Teacher teacher, Course course) {

        super("Course page");

        // got from navigation
        // this.home = home;
        this.teacher = teacher;
        this.course = course;

        // this.teacherId = Integer.toString(courseId);

        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(MyColor.whiteBg());

        // Navbar

        welcome = new JLabel("Course: " + course.getName());
        welcome.setFont(MyFont.mediumFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(255, 18, 600, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(30, 10, 100, 40);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Input boxes

        theQuestion = new JTextField();
        theQuestion.setBounds(620, 110, 312, 60);
        theQuestion.setBackground(MyColor.whiteColor());
        theQuestion.setFont(MyFont.tinyFont());
        panel.add(theQuestion);

        choice1 = new JTextField();
        choice1.setBounds(650, 200, 220, 35);
        choice1.setBackground(MyColor.whiteColor());
        choice1.setFont(MyFont.smallFont());
        panel.add(choice1);

        choice2 = new JTextField();
        choice2.setBounds(650, 250, 220, 35);
        choice2.setBackground(MyColor.whiteColor());
        choice2.setFont(MyFont.smallFont());
        panel.add(choice2);

        choice3 = new JTextField();
        choice3.setBounds(650, 300, 220, 35);
        choice3.setBackground(MyColor.whiteColor());
        choice3.setFont(MyFont.smallFont());
        panel.add(choice3);

        choice4 = new JTextField();
        choice4.setBounds(650, 350, 220, 35);
        choice4.setBackground(MyColor.whiteColor());
        choice4.setFont(MyFont.smallFont());
        panel.add(choice4);

        checkOne = new JCheckBox();
        checkTwo = new JCheckBox();
        checkThree = new JCheckBox();
        checkFour = new JCheckBox();
        checkOne.setBounds(900, 200, 25, 30);
        checkTwo.setBounds(900, 250, 25, 30);
        checkThree.setBounds(900, 300, 25, 30);
        checkFour.setBounds(900, 350, 25, 30);

        checkFour.setOpaque(false);
        checkOne.setOpaque(false);
        checkTwo.setOpaque(false);
        checkThree.setOpaque(false);

        checkOne.setFont(MyFont.bigFont());
        checkTwo.setFont(MyFont.smallFont());
        checkThree.setFont(MyFont.smallFont());
        checkFour.setFont(MyFont.smallFont());

        panel.add(checkOne);
        panel.add(checkTwo);
        panel.add(checkThree);
        panel.add(checkFour);

        boxCombo = new ButtonGroup();
        boxCombo.add(checkOne);
        boxCombo.add(checkTwo);
        boxCombo.add(checkThree);
        boxCombo.add(checkFour);

        oneLabel = new JLabel("1)");
        oneLabel.setBounds(620, 200, 30, 20);
        oneLabel.setFont(MyFont.primaryFont());
        oneLabel.setForeground(MyColor.whiteColor());
        panel.add(oneLabel);

        twoLabel = new JLabel("2)");
        twoLabel.setBounds(620, 250, 30, 20);
        twoLabel.setFont(MyFont.primaryFont());
        twoLabel.setForeground(MyColor.whiteColor());
        panel.add(twoLabel);

        threeLabel = new JLabel("3)");
        threeLabel.setBounds(620, 300, 30, 20);
        threeLabel.setFont(MyFont.primaryFont());
        threeLabel.setForeground(MyColor.whiteColor());
        panel.add(threeLabel);

        fourLabel = new JLabel("4)");
        fourLabel.setBounds(620, 350, 30, 20);
        fourLabel.setFont(MyFont.primaryFont());
        fourLabel.setForeground(MyColor.whiteColor());
        panel.add(fourLabel);

        // Buttons

        addQuestion = new JButton("ADD Question");
        addQuestion.setFont(MyFont.mediumFont());
        addQuestion.setBackground(MyColor.primaryColor());
        addQuestion.setForeground(MyColor.whiteColor());
        addQuestion.setFocusPainted(false);
        addQuestion.setBounds(30, 100, 200, 80);
        addQuestion.addActionListener(this);
        panel.add(addQuestion);

        addExam = new JButton("Exam");
        addExam.setFont(MyFont.mediumFont());
        addExam.setBackground(MyColor.primaryColor());
        addExam.setForeground(MyColor.whiteColor());
        addExam.setFocusPainted(false);
        addExam.setBounds(30, 240, 200, 80);
        addExam.addActionListener(this);
        panel.add(addExam);

        studentListButton = new JButton("Student List");
        studentListButton.setFont(MyFont.mediumFont());
        studentListButton.setBackground(MyColor.primaryColor());
        studentListButton.setForeground(MyColor.whiteColor());
        studentListButton.setFocusPainted(false);
        studentListButton.setBounds(30, 380, 200, 80);
        studentListButton.addActionListener(this);
        panel.add(studentListButton);

        requests = new JButton("Requests");
        requests.setFont(MyFont.mediumFont());
        requests.setBackground(MyColor.primaryColor());
        requests.setForeground(MyColor.whiteColor());
        requests.setFocusPainted(false);
        requests.setBounds(30, 520, 200, 80);
        requests.addActionListener(this);
        panel.add(requests);

        titleBar = new JLabel();
        titleBar.setOpaque(true);
        titleBar.setBackground(MyColor.buleGreyColor());
        titleBar.setBounds(255, 100, 2, 500);
        panel.add(titleBar);

        title = new JLabel("Available Questions");
        title.setFont(MyFont.smallFont());
        title.setBounds(280, 72, 300, 25);
        panel.add(title);

        courseQuestion = Questiondb.getAllQuestionList(course.getId());

        int length = courseQuestion.size();
        String questionBak[] = new String[length];
        int i = 0;
        for (Question c : courseQuestion) {
            questionBak[i] = c.getDescription();
            i++;
        }

        questionList = new JList(questionBak);
        questionList.setFont(MyFont.tinyFont());
        questionList.setForeground(MyColor.textColor());
        questionList.setBorder(new EmptyBorder(10, 10, 10, 10));
        questionList.addMouseListener(this);
        // panel.add(questionList);
        // questionList.setBounds(280, 100, 300, 500);

        JScrollPane scrollPaneTwo = new JScrollPane();
        scrollPaneTwo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTwo.setViewportView(questionList);
        scrollPaneTwo.setBounds(280, 100, 300, 500);
        panel.add(scrollPaneTwo);

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.defaultColor());
        boxOne.setBounds(600, 100, 355, 320);
        panel.add(boxOne);

        updateButton = new JButton("Update");

        updateButton.setFont(MyFont.mediumFont());
        updateButton.setBackground(MyColor.successColor());
        updateButton.setForeground(MyColor.whiteColor());
        updateButton.setFocusPainted(false);
        updateButton.setEnabled(false);
        updateButton.setBounds(600, 450, 150, 50);
        updateButton.addActionListener(this);
        panel.add(updateButton);

        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(MyFont.mediumFont());
        deleteBtn.setBackground(MyColor.dangerColor());
        deleteBtn.setForeground(MyColor.whiteColor());
        deleteBtn.setFocusPainted(false);
        deleteBtn.setEnabled(false);
        deleteBtn.setBounds(800, 450, 155, 50);
        deleteBtn.addActionListener(this);
        panel.add(deleteBtn);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {

            this.dispose();
            // navigation
            TeacherHome f = new TeacherHome(teacher);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } else if (e.getSource() == addQuestion) {

            System.out.println("Add Question Clicked");
            this.dispose();
            AddQuestion aq = new AddQuestion(teacher, course);
            aq.setResizable(false);
            aq.setLocationRelativeTo(null);
            aq.setVisible(true);

        } else if (e.getSource() == addExam) {
            System.out.println("Add Exam Clicked");

            this.dispose();
            ExamPage exam = new ExamPage(teacher, course);
            exam.setLocationRelativeTo(null);
            exam.setResizable(false);
            exam.setVisible(true);

        } else if (e.getSource() == requests) {
            this.dispose();
            RequestedStudent requestedStudent = new RequestedStudent(teacher, course);
            requestedStudent.setLocationRelativeTo(null);
            requestedStudent.setResizable(false);
            requestedStudent.setVisible(true);
            System.out.println("Requests Clicked");
        } else if (e.getSource() == studentListButton) {

            this.dispose();
            StudentList sl = new StudentList(teacher, course);
            sl.setLocationRelativeTo(null);
            sl.setResizable(false);
            sl.setVisible(true);

        } else if (e.getSource() == updateButton) {

            if (theQuestion.getText().equals("") || choice1.getText().equals("") || choice2.getText().equals("")
                    || choice3.getText().equals("") || choice4.getText().equals("")
                    || boxCombo.getSelection() == null) {

                errorMessage = new JOptionPane();
                errorMessage.setFont(MyFont.primaryFont());
                errorMessage.showMessageDialog(null, "All fields are required!", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);

            } else {
                String correctChoice = null;

                if (checkOne.isSelected()) {
                    correctChoice = choice1.getText();
                } else if (checkTwo.isSelected()) {
                    correctChoice = choice2.getText();
                } else if (checkThree.isSelected()) {
                    correctChoice = choice3.getText();
                } else if (checkFour.isSelected()) {
                    correctChoice = choice4.getText();
                }

                // TODO: set selected item and check empty DONE!!!!!!!!!

                Question q = new Question(question.getId(),course.getId(), theQuestion.getText(), choice1.getText(), choice2.getText(),
                        choice3.getText(), choice4.getText(), correctChoice);
                Questiondb.updateQuestion(q);

                successPane = new JOptionPane();
                successPane.setFont(MyFont.primaryFont());
                successPane.showMessageDialog(null, "Question updated!", "Done!", JOptionPane.INFORMATION_MESSAGE);

            }

        }

        else if (e.getSource() == deleteBtn) {
            System.out.println("Delete question Clicked");

            confirmDelete = new JOptionPane();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = confirmDelete.showConfirmDialog(null, "Are you sure to delete the course?", "Warning",
                    dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                Questiondb.deleteQuestion(courseQuestion.get(questionId).getId());
                this.dispose();
                CoursePage cp = new CoursePage(teacher, course);
                cp.setLocationRelativeTo(null);
                cp.setVisible(true);
            } else {
            }

        }

    }

    public void mouseClicked(MouseEvent e) {

        System.out.println("Mouse clicked");

        if (e.getSource() == questionList) {

            updateButton.setEnabled(true);
            deleteBtn.setEnabled(true);

            int selected = questionList.getSelectedIndex();

            System.out.println(selected);

            List<Question> c = Questiondb.getAllQuestionList(course.getId());

            String myQuestion = c.get(selected).getDescription();
            String choiceOne = c.get(selected).getChoiceOne();
            String choiceTwo = c.get(selected).getChoiceTwo();
            String choiceThree = c.get(selected).getChoiceThree();
            String choiceFour = c.get(selected).getChoiceFour();
            String currectChoice = c.get(selected).getCorrectChoice();

            if (choiceOne.equals(currectChoice)) {
                checkOne.setSelected(true);
            } else if (choiceTwo.equals(currectChoice)) {
                checkTwo.setSelected(true);
            } else if (choiceThree.equals(currectChoice)) {
                checkThree.setSelected(true);
            } else if (choiceTwo.equals(currectChoice)) {
                checkFour.setSelected(true);
            }

            questionId = selected;
            question = c.get(selected);

            System.out.println(currectChoice);

            theQuestion.setText(myQuestion);
            choice1.setText(choiceOne);
            choice2.setText(choiceTwo);
            choice3.setText(choiceThree);
            choice4.setText(choiceFour);

        } else {

        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
