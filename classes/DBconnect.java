import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Class.Teacher

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class DBUtilsWithConnection {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://scintilib.com:3306/mcq";
        final String driver = "com.mysql.jdbc.Driver";
        final String usr = "root";
        final String pwd = "97865321";

        QueryRunner run = new QueryRunner();

        DbUtils.loadDriver(driver);
        Connection conn = DriverManager.getConnection(url, usr, pwd);
        // -----------------------------------------------------------------------------------
        ResultSetHandler<Employee> resultHandler = new BeanHandler<Employee>(Employee.class);
       
       
        try {
            Employee emp = run.query(conn, "SELECT * FROM employee WHERE employeename=?",
                    resultHandler, "Jose");
            System.out.println(emp.getEmployeeId());
        } finally {
            DbUtils.close(conn);
        }
       
    }
}