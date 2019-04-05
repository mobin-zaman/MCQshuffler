package dbfunctions;

import classes.Course;
import database.*;
import java.util.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

public class Coursedb {

    public static List<Course> getCourseList(String teacherId) {
        DB db = new DB();
        String sql = "SELECT * FROM course WHERE teacherID=?";
        List<Course> course = null;
        ResultSetHandler<List<Course>> resultSetHandler = new BeanListHandler<Course>(Course.class);

        try {
            course = db.run.query(db.getConn(), sql, resultSetHandler, teacherId);
        } catch (Exception e) {
            System.out.println("getCourseList(): " + e);
        }

        return course;

        // kept for future reference
        // List<Course> course = Coursedb.getCourseList(GP.getProperty("teacherId"));
        // course.forEach((c) -> {
        // System.out.println(c.getId());
        // System.out.println(c.getName());
        // System.out.println(c.getTeacherId());
        // });
    }
}
