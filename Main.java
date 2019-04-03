import java.sql.Connection;
import java.sql.DriverManager;
import classes.Teacher;
import java.sql.SQLException;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class Main {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306/mcq?useSSL=false";
        final String driver = "com.mysql.jdbc.Driver";
        final String usr = "phpmyadmin";
        final String pwd = "amarsql";
        Connection conn=null;

        QueryRunner run = new QueryRunner();

        System.out.println("1");
        DbUtils.loadDriver(driver);
        try{
            System.out.println("this");
        conn = DriverManager.getConnection(url, usr, pwd);
        System.out.println(3);
        }
        catch(Exception e){
            System.out.println("ex: "+e);
        }
        System.out.println("2");
        // -----------------------------------------------------------------------------------
        ResultSetHandler<Teacher> resultHandler = new BeanHandler<Teacher>(Teacher.class);
       
        System.out.println("3");
       
        try {
            Teacher emp = run.query(conn, "SELECT * FROM teacher WHERE name=?",
                    resultHandler, "mohaim");
            System.out.println("id: "+emp.getId());
            System.out.println("name: "+emp.getName());
            System.out.println("password "+emp.getPassword());
        } finally {
            DbUtils.close(conn);
        }
        System.out.println(4);
       
    }
}