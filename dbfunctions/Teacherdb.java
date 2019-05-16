package dbfunctions;

import database.DB;

import java.util.List;
import java.util.prefs.Preferences;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import classes.Question;
import classes.Student;
import classes.Teacher;

public class Teacherdb {

    public static Teacher login(String username, String password) {
        DB db = DB.getDB();
        String sql = "SELECT * FROM teacher WHERE name=? AND password=?";

        ResultSetHandler<Teacher> resultSetHandler = new BeanHandler<Teacher>(Teacher.class);

        Teacher teacher = null;

        try {
            teacher = db.run.query(db.getConn(), sql, resultSetHandler, username, password);
        } catch (Exception e) {
            System.out.println("teacherdb login(): " + e);
        }

        return teacher;
    }

    // public static void logout() {
    // GlobalProperty gp = new GlobalProperty();
    // gp.setProperty("teacherId", "-1");
    // }

    // TODO: will be done with the gui
    public static boolean signUp(String username, String password) {
        DB db = DB.getDB();
        String sql = "SELECT * FROM student WHERE name=?";
        ResultSetHandler<Teacher> resultSetHandler = new BeanHandler<Teacher>(Teacher.class);
        Teacher teacher = null;
        try {
            teacher = db.run.query(db.getConn(), sql, resultSetHandler, username);

        } catch (Exception e) {
            System.out.println("signup(): teacher:  " + e);
        }

        if (teacher != null) {
            System.out.println("username existes!");
            return false;
        }

        sql = "INSERT into teacher(name,password) VALUES(?,?)";
        try {
            db.run.update(db.getConn(), sql, username, password);
        } catch (Exception e) {
            System.out.println("teacher signup: " + e);
        }
        return true;

    }

    // might be useful
    public static String getTeacherName(int teacherId) {
        DB db = DB.getDB();
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE id=?";
        ResultSetHandler<Teacher> resultSetHandler = new BeanHandler<Teacher>(Teacher.class);

        try {
            teacher = db.run.query(db.getConn(), sql, resultSetHandler, teacherId);
        } catch (Exception e) {
            System.out.println("getTeacherName(): " + e);
        }

        return teacher.getName();
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

    public static void acceptRequest(int courseId, int studentId) {
        String sql = "UPDATE `request` SET `isAccepted` = '1' WHERE `request`.`courseId`=? AND `request`.`studentId`=?";
        DB db = DB.getDB();
        try {
            db.run.update(db.getConn(), sql, courseId, studentId);
        } catch (Exception e) {
            System.out.println("teacherDB.acceptRequest():" + e);
        }
        sql = "insert into course_student (courseId,studentId) values(?,?)";
        try {
            db.run.update(db.getConn(), sql, courseId, studentId);
        } catch (Exception e) {
            System.out.println("teacherDB.adfdfdcceptRequest():" + e);
        }
    }

    public static void rejectRuquest(int courseId, int studentId) {
        String sql = "UPDATE `request` SET `isRejected` = '1' WHERE `request`.`courseId`=? AND `request`.`studentId`=?";
        DB db = DB.getDB();
        try {
            db.run.update(db.getConn(), sql, courseId, studentId);
        } catch (Exception e) {
            System.out.println("teacherDB.rejectRequest():" + e);
        }
    }

    public static void removeStudent(int courseId, int studentId) {
        String sql = "DELETE FROM `course_student` WHERE courseId=? AND studentId=?";
        DB db = DB.getDB();
        try {
            db.run.update(db.getConn(), sql, courseId, studentId);
        } catch (Exception e) {
            System.out.println("removeStudent(): " + e);
        }
    }

}