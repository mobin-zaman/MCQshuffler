package gui.teacher;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gui.teacher.*;
import gui.Home;
import gui.utilities.*;
// Navigation's
import classes.Course;
import classes.Teacher;
import classes.Marks;

// database
import dbfunctions.*;

public class MarksList extends JFrame implements ActionListener {

    private JLabel navBar, welcome, courses;
    private Object tableHeaders[] = { "Student ID", "Student Name", "Marks" };
    private JTable table;
    private JButton backButton;

    private JPanel panel;

    private List<Marks> marksList;

    private Teacher teacher;
    private Course course;
    private int examId;

    public MarksList(Teacher teacher, Course course, int examId) {

        super("Mark List Page");

        this.teacher = teacher;
        this.course = course;
        this.examId = examId;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Navbar

        welcome = new JLabel("Course: " + course.getName());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setFont(MyFont.primaryFont());
        welcome.setBounds(600, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setBounds(40, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        courses = new JLabel("Marks of Enrolled Students: ");
        courses.setForeground(MyColor.textColor());
        courses.setFont(MyFont.primaryFont());
        courses.setBounds(380, 70, 500, 25);
        panel.add(courses);

        marksList = Examdb.getMarks(examId);

        int length = marksList.size();

        int i = 0;

        String data[][] = new String[length][3];

        // Inserting into data from database
        for (Marks mark : marksList) {
            System.out.println(mark.getMarks());
            System.out.println(Studentdb.getStudentName(mark.getStudentId()));
            data[i][0] = Integer.toString(mark.getStudentId());
            data[i][1] = Studentdb.getStudentName(mark.getStudentId());
            data[i][2] = Integer.toString(mark.getMarks());
            i++;
        }

        // creating table model with data and the table headers
        DefaultTableModel model = new DefaultTableModel(data, tableHeaders) {
            public boolean isCellEditable(int row, int column) {
                return false; // Table cell editable false
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane();
        table.setFont(MyFont.mediumFont());
        table.setForeground(MyColor.textColor());
        table.getTableHeader().setBackground(MyColor.primaryColor());
        table.getTableHeader().setForeground(MyColor.whiteColor());
        table.getTableHeader().setFont(MyFont.primaryFont());
        table.setRowHeight(30);

        // For centering table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        // Adding scroll to the table
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(250, 110, 500, 480);
        panel.add(scrollPane);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();

        if (action.equals(backButton.getText())) {
            dispose();
            ExamPage ep = new ExamPage(teacher, course);
            ep.setLocationRelativeTo(null);
            ep.setResizable(false);
            ep.setVisible(true);
        }
    }

}
