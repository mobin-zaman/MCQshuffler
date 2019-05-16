package dbfunctions;

import database.*;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.math.BigInteger;

import classes.Student;

public class Studentdb {

    public static Student login(String username, String password) {
        DB db = DB.getDB();
        String sql = "SELECT * FROM student WHERE name=? AND password=?";

        ResultSetHandler<Student> resultSetHandler = new BeanHandler<Student>(Student.class);

        Student student = null;

        try {
            student = db.run.query(db.getConn(), sql, resultSetHandler, username, password);
        } catch (Exception e) {
            System.out.println("Studentdb login(): " + e);
        }

        return student;
    }

    public static boolean signUp(String username, String password) {
        DB db = DB.getDB();
        String sql = "SELECT * FROM student WHERE name=?";
        ResultSetHandler<Student> resultSetHandler = new BeanHandler<Student>(Student.class);
        Student student = null;
        try {
            student = db.run.query(db.getConn(), sql, resultSetHandler, username);

        } catch (Exception e) {
            System.out.println("signup(): student:  " + e);
        }

        if (student != null) {
            System.out.println("username existes!");
            return false;
        }

        sql = "INSERT into student(name,password) VALUES(?,?)";
        try {
            db.run.update(db.getConn(), sql, username, password);
        } catch (Exception e) {
            System.out.println("student signup: " + e);
        }
        return true;

    }

    // if the return value is false, means the student was rejected and can't
    // request again
    public static void requestCourse(int studentId, int courseId) {
        DB db = DB.getDB();
        // as the student was rejected so he can't request anymore
        // if (isRejected(studentId, courseId)) {
        // System.out.println("student rejected for courseId: " + courseId);
        // return false;
        // }
        // else
        String sql = "INSERT INTO request(studentId,courseId) VALUES(?,?)";
        try {
            db.run.update(db.getConn(), sql, studentId, courseId);
        } catch (Exception e) {
            System.out.println("requestCourse(): " + e);
        }

    }

    public static boolean isRejected(int studentId, int courseId) {
        DB db = DB.getDB();
        String sql = "SELECT id FROM request WHERE studentId=? AND courseId=?";
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

    public static boolean isRequested(int studentId, int courseId) {
        DB db = DB.getDB();
        String sql = "SELECT id FROM request WHERE studentId=? AND courseId=?";
        int isRejected = 0;
        try {
            isRejected = ((Integer) db.run.query(db.getConn(), sql, new ScalarHandler(1), studentId, courseId))
                    .intValue();
        } catch (Exception e) {
            System.out.println("isrequessssss: " + e);
            isRejected = 1;
        }
        if (isRejected == 1)
            return true;
        else
            return false;

    }
    // if true then you can request

    public static boolean checkRequest(int studentId, int courseId) {
        if (isRejected(studentId, courseId) == true)
            return false;
        if (isRequested(studentId, courseId) == true)
            return false;
        return true;
    }

    public static void deleteRequest(int courseId, int studentId) {
        String sql = "DELETE FROM request WHERE courseId=? AND courseId=?";
        DB db = DB.getDB();

        try {
            db.run.update(db.getConn(), sql, courseId, studentId);
        } catch (Exception e) {
            System.out.println("Sutdentdb.deleteRequest()" + e);
        }
    }

    public static String getStudentName(int studentId) {
        String sql = "select name from student where id=?";
        ResultSetHandler<Student> resultSetHandler = new BeanHandler<Student>(Student.class);
        DB db = DB.getDB();
        Student student = null;

        try {
            student = db.run.query(db.getConn(), sql, resultSetHandler, studentId);
        } catch (Exception e) {
            System.out.println("getName: " + e);
        }
        System.out.println("Ekhane kisu likhe daw to " + student.getName());
        return student.getName();
    }

}