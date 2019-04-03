import java.sql.Connection;
import java.sql.DriverManager;
import classes.Student;
import java.sql.SQLException;
import java.util.*;


import classes.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        // final String url = "jdbc:mysql://localhost:3306/mcq?useSSL=false";
        // final String driver = "com.mysql.jdbc.Driver";
        // final String usr = "phpmyadmin";
        // final String pwd = "amarsql";
        // Connection conn=null;

        // QueryRunner run = new QueryRunner();

        // System.out.println("1");
        // DbUtils.loadDriver(driver);
        // try{
        //     System.out.println("this");
        // conn = DriverManager.getConnection(url, usr, pwd);
        // System.out.println(3);
        // }
        // catch(Exception e){
        //     System.out.println("ex: "+e);
        // }
        // System.out.println("2");
        // -----------------------------------------------------------------------------------

        DB db = new DB();

        ResultSetHandler <List<Question>> resultSetHandler=new BeanListHandler<Question>(Question.class);

        List<Question> questionList = db.run.query(db.getConn(),"SELECT * FROM question where courseId=?",resultSetHandler,"1");
        Collections.shuffle(questionList);

        for(Question q:questionList){
            System.out.println("id: "+q.getId());
            System.out.println("description: "+q.getDescription());
            System.out.println("choice 1"+q.getChoiceOne());
            System.out.println("choice 2"+q.getChoiceTwo());
            System.out.println("choice 3"+q.getChoiceThree());
            System.out.println("choice 4"+q.getChoiceFour());
            System.out.println();
            System.out.println("correct answer"+q.getCorrectChoice());
        }


        }
       
}