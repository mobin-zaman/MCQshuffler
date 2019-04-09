package dbfunctions;

import classes.Course;
import database.*;
import java.util.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

public class Coursedb {

    public static void insertCourse(String description, String teacherId) {
        DB db = DB.getDB();
        String sql = "INSERT INTO course(name,teacherId) VALUES(?,?)";
        try {
            db.run.update(db.getConn(), sql, description, teacherId);
        } catch (Exception e) {
            System.out.println(e);
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

    public static List<Course> getCourseList(String teacherId) {

        String sql = "SELECT * FROM course WHERE teacherID=?";
        return query(sql, teacherId);

    }

    public static List<Course> getOfferedCourseList(String studentId) {
        String sql = "SELECT * FROM course WHERE id NOT IN(SELECT courseId FROM course_student WHERE studentId=?)";
        return query(sql, studentId);
    }

    public static List<Course> getEnrolledCourseList(String studentId) {
        String sql = "SELECT * FROM course WHERE id IN(SELECT courseId FROM course_student WHERE studentId=?)";
        return query(sql, studentId);

    }

}
