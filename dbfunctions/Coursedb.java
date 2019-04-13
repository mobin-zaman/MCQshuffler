package dbfunctions;

import classes.*;
import java.util.*;
import database.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.util.*;

public class Coursedb {

    public static void insertCourse(String description, String teacherId) {
        DB db = DB.getDB();
        String sql = "INSERT INTO course(name,teacherId) VALUES(?,?)";
        try {
            db.run.update(db.getConn(), sql, description, teacherId);
        } catch (Exception e) {
            System.out.println("insertCourse(): " + e);
        }

    }

    public static void deleteCourse(int courseId) {
        DB db = DB.getDB();
        String sql = "DELETE FROM course WHERE id=?";
        try {
            db.run.update(db.getConn(), sql, courseId);
        } catch (Exception e) {
            System.out.println("Delete course: " + e);
        }
    }

    // general query functions for all the functions here
    public static List<Course> query(String sql, String paramId) {
        DB db = DB.getDB();
        List<Course> course = null;
        ResultSetHandler<List<Course>> resultSetHandler = new BeanListHandler<Course>(Course.class);

        try {
            course = db.run.query(db.getConn(), sql, resultSetHandler, paramId);
        } catch (Exception e) {
            System.out.println("getCourseList(): " + e);
        }

        return course;
    }

    // kept for future reference
    // List<Course> course = Coursedb.getCourseList(GP.getProperty("teacherId"));
    // course.forEach((c) -> {
    // System.out.println(c.getId());
    // System.out.println(c.getName());
    // System.out.println(c.getTeacherId());
    // });
    // public static String[] getCourseNameArray(String courseId) {
    // List<Course> course = getCourseList(courseId);
    // ArrayList<String> courseName = null;

    // for (Course c : course) {
    // courseName.add(c.getName());
    // }

    // Object[] arr = courseName.toArray();
    // String[] str = (String) arr;
    // return str;
    // }

    public static List<Course> getCourseList(String teacherId) {

        String sql = "SELECT * FROM course WHERE teacherID=?";
        return query(sql, teacherId);

    }

    // function intended to be used in studentdb
    public static List<Course> getOfferedCourseList(String studentId) {
        String sql = "SELECT * FROM course WHERE id NOT IN(SELECT courseId FROM course_student WHERE studentId=?)";
        return query(sql, studentId);
    }

    // functoin intended to be used in teacherdb
    public static List<Course> getEnrolledCourseList(String studentId) {
        String sql = "SELECT * FROM course WHERE id IN(SELECT courseId FROM course_student WHERE studentId=?)";
        return query(sql, studentId);

    }

    public static String getNumberOfStudents(int courseId) {

        DB db = DB.getDB();

        String sql = "SELECT * FROM course_student WHERE courseId=?";

        List<Course> courseList = null;

        ResultSetHandler<List<Course>> resultSetHandler = new BeanListHandler<Course>(Course.class);

        try {
            courseList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getNumberOfStudent: " + e);
        }
        int length = courseList.size();

        String numberOfStudents = "0";
        if (length < 10) {
            numberOfStudents = numberOfStudents + Integer.toString((courseList.size()));
        } else {
            numberOfStudents = Integer.toString(courseList.size());
        }
        return numberOfStudents;
    }

    public static String getNumberOfQuestions(int courseId) {

        DB db = DB.getDB();

        String sql = "SELECT * FROM question WHERE courseId=?";

        List<Question> questionList = null;

        ResultSetHandler<List<Question>> resultSetHandler = new BeanListHandler<Question>(Question.class);
        String param = Integer.toString(courseId);

        try {
            questionList = db.run.query(db.getConn(), sql, resultSetHandler, param);
        } catch (Exception e) {
            System.out.println("getNumberOfQuestion: " + e);
        }
        int length = questionList.size();
        String numberOfQuestion = "0";
        if (length < 10) {
            numberOfQuestion = numberOfQuestion + Integer.toString(questionList.size());
        } else {
            numberOfQuestion = Integer.toString((questionList.size()));
        }
        return numberOfQuestion;
    }

    public static List<Student> getEnrolledStudentList(int courseId) {
        DB db = DB.getDB();

        String sql = "SELECT * FROM student WHERE id IN(SELECT studentId FROM course_student WHERE courseId=?";
        List<Student> studentList = null;

        ResultSetHandler<List<Student>> resultSetHandler = new BeanListHandler<Student>(Student.class);

        try {
            studentList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getStudentList: " + e);
        }

        return studentList;
    }

    public static List<Student> getRequestStudentList(int courseId) {
        DB db = DB.getDB();

        String sql = "SELECT * FROM student WHERE id IN(SELECT studentId FROM request WHERE courseId=? AND isRejected=0 AND isAccepted=0)";
        List<Student> studentList = null;

        ResultSetHandler<List<Student>> resultSetHandler = new BeanListHandler<Student>(Student.class);

        try {
            studentList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getStudentList: " + e);
        }

        return studentList;
    }

}
