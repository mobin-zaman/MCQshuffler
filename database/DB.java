package database;

import java.math.BigInteger;
import java.sql.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class DB {
    private Connection connection;
    public QueryRunner run;
    private DatabaseProperty dbproperty;
    private static DB uniqueInstance;

    private DB() {
        dbproperty = new DatabaseProperty();
        run = new QueryRunner();
        DbUtils.loadDriver("com.mysql.jdbc.Driver");
        System.out.println("db driver loaded");

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcq?useSSL=false", "root", "");
        } catch (Exception e) {
            System.out.println("exception in DB constructor: " + e);
        }
        System.out.println("db initiation done");

    }

    public static DB getDB() {
        if (uniqueInstance == null) {
            uniqueInstance = new DB();
        }
        return uniqueInstance;

    }

    public Connection getConn() {
        return connection;
    }

    public int lastInsertId() {
        int insertId = 0;
        try {
            insertId = ((BigInteger) this.run.query(this.connection, "SELECT LAST_INSERT_ID()", new ScalarHandler(1)))
                    .intValue();
        } catch (Exception e) {
            System.out.println(e);
        }
        return insertId;

    }
}
