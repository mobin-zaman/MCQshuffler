package dbfunctions;

import java.util.List;
import java.util.prefs.Preferences;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import classes.Student;
import classes.Teacher;
import database.*;

public class Teacherdb {

    public static boolean login(String username, String password) {
        DB db = DB.getDB();
        String sql = "SELECT id FROM teacher WHERE name=? AND password=?";

        ResultSetHandler<Teacher> resultSetHandler = new BeanHandler<Teacher>(Teacher.class);

        Teacher teacher = null;

        try {
            teacher = db.run.query(db.getConn(), sql, resultSetHandler, username, password);
        } catch (Exception e) {
            System.out.println("teacherdb login(): " + e);
        }

        if (teacher == null) {
            System.out.println("teacher not available");
            GP.setProperty("teacherId", "-1");
            return false;
        }

        else {
            // these global property might not be needed
            // GlobalProperty gp = new GlobalProperty();
            // gp.setProperty("teacherId", Integer.toString(teacher.getId()));
            return true;
        }
    }

    // public static void logout() {
    // GlobalProperty gp = new GlobalProperty();
    // gp.setProperty("teacherId", "-1");
    // }

    // TODO: will be done with the gui
    public static void SignUp() {

    }

    // might be useful
    public String getTeacherName(String teacherId) {
        String teacherName = null;
        return teacherName;
    }

    // to show the requestListOfTheCourse
    public List<Student> getRequestList(String courseId) {
        DB db = DB.getDB();

        String sql = "SELECT * FROM student WHERE id in (SELECT studentId FROM request WHERE courseId=? AND isRejected=0 AND isAccepted=0)";

        List<Student> studentList = null;
        ResultSetHandler<List<Student>> resultSetHandler = new BeanListHandler<Student>(Student.class);

        try {
            studentList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getRequestList(): " + e);
        }

        return studentList;
    }
}