import java.lang.*;

public class Start {
    public static void main(String[] args) {
        FacultyLogin fl = new FacultyLogin();
        // fl.setVisible(true);

        FacultySignup fs = new FacultySignup();
        // fs.setVisible(true);

        StudentSignup ss = new StudentSignup();
        ss.setVisible(true);

        TeacherHome th = new TeacherHome();
        // th.setVisible(true);

        AddCourse ac = new AddCourse();
        // ac.setVisible(true);

        Course c = new Course();
        // c.setVisible(true);

        Exam e = new Exam();
        // e.setVisible(true);
    }
}