package dbfunctions;

import database.*;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.math.BigInteger;

import classes.Student;

public class Studentdb {

    public static boolean login(String username, String password) {
        DB db = DB.getDB();
        String sql = "SELECT id FROM student WHERE name=? AND password=?";

        ResultSetHandler<Student> resultSetHandler = new BeanHandler<Student>(Student.class);

        Student student = null;

        try {
            student = db.run.query(db.getConn(), sql, resultSetHandler, username, password);
        } catch (Exception e) {
            System.out.println("Studentdb login(): " + e);
        }

        if (student == null) {
            System.out.println("student not available");
            // GP.setProperty("teacherId", "-1");
            return false;
        }

        else {
            return true;
        }
    }

    // TODO: function for requesting course from the course list
    // if the return value is false, means the student was rejected and can't
    // request again
    public static boolean requestCourse(String studentId, String courseId) {
        DB db = DB.getDB();
        // as the student was rejected so he can't request anymore
        if (isRejected(studentId, courseId)) {
            return false;
        }
        // else
        String sql = "INSERT INTO request(studentId,courseId) VALUES(?,?)";
        try {
            db.run.update(db.getConn(), sql, studentId, courseId);
        } catch (Exception e) {
            System.out.println("requestCourse(): " + e);
        }

        return true;

    }

    public static boolean isRejected(String studentId, String courseId) {
        DB db = DB.getDB();
        String sql = "SELECT isRejected FROM request WHERE studentId=? AND courseId=?";
        int isRejected = 0;
        try {
            isRejected = ((Integer) db.run.query(db.getConn(), sql, new ScalarHandler(1), studentId, courseId))
                    .intValue();
        } catch (Exception e) {
            System.out.println("isrejected: " + e);
        }
        if (isRejected == 1)
            return true;
        else
            return false;

    }

    // TODO: will be done after gui
    public static void sitForExam(String examId, String studentId) {

    }

}