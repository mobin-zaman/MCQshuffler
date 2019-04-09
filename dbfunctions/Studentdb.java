package dbfunctions;

import database.*;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

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
}