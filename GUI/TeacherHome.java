import java.lang.*;
import javax.swing.*;

public class TeacherHome extends JFrame {

    private JLabel title, subTitle;
    private JButton addCourse, requests;

    private JPanel panel;

    public TeacherHome() {

        super("Teacher Home");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Teacher Home");
        title.setBounds(350, 20, 100, 30);
        panel.add(title);

        addCourse = new JButton("ADD Course");
        addCourse.setBounds(100, 80, 200, 30);
        panel.add(addCourse);

        requests = new JButton("Students' Requests");
        requests.setBounds(100, 300, 200, 30);
        panel.add(requests);

        subTitle = new JLabel("Course List");
        subTitle.setBounds(500, 80, 200, 30);
        panel.add(subTitle);

        this.add(panel);

    }
}