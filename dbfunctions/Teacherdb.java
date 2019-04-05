package dbfunctions;

import java.util.prefs.Preferences;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import classes.Teacher;
import database.DB;
import database.GlobalProperty;
import jdk.nashorn.internal.objects.Global;

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
            return false;
        }

        else {
            GlobalProperty gp = new GlobalProperty();
            gp.setProperty("teacherId", teacher.getId());
            return true;
        }
    }
}