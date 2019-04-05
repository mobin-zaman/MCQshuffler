package database;

import java.math.BigInteger;
import java.sql.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class DB {
    private Connection connection;
    public QueryRunner run;
    private Databaseproperty dbproperty;

    public DB() {
        dbproperty = new Databaseproperty();
        run = new QueryRunner();
        DbUtils.loadDriver("com.mysql.jdbc.Driver");
        System.out.println("db driver loaded");

        try {
            connection = DriverManager.getConnection(dbproperty.url(), dbproperty.username(), dbproperty.password());
        } catch (Exception e) {
            System.out.println("exception in DB constructor: " + e);
        }
        System.out.println("db initiation done");

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
