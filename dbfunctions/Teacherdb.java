package dbfunctions;

import java.util.prefs.Preferences;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import classes.Teacher;
import database.*;

public class Teacherdb {

    public static boolean login(String username, String password) {
        DB db = new DB();
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
            GlobalProperty gp = new GlobalProperty();
            gp.setProperty("teacherId", Integer.toString(teacher.getId()));
            return true;
        }
    }

    public static void logout() {
        GlobalProperty gp = new GlobalProperty();
        gp.setProperty("teacherId", "-1");
    }

    // TODO: will be done with the gui
    public static void SignUp() {

    }
}