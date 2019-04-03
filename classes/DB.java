package classes;
import java.sql.*;
import classes.Databaseproperty;
import org.apache.commons.dbutils.*;

public class DB{ 
    private Connection connection;
    public QueryRunner run; 
    private Databaseproperty dbproperty;

    public DB(){
        dbproperty=new Databaseproperty();
        run = new QueryRunner();
        DbUtils.loadDriver("com.mysql.jdbc.Driver");
        System.out.println("db driver loaded");
        
        try{ connection=DriverManager.getConnection(dbproperty.url(), dbproperty.username(),dbproperty.password());
        } catch(Exception e){ System.out.println("exception in DB constructor: "+e);}
        System.out.println("db initiating done");

    }
    public Connection getConn(){
        return connection;
    }
}
