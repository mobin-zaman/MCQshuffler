import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import classes.*;
import dbfunctions.*;
import database.*;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        System.out.println(Teacherdb.login("momom", "momom"));

        List<Course> course = Coursedb.getCourseList(GP.getProperty("teacherId"));
        course.forEach((c) -> {
            System.out.println(c.getId());
            System.out.println(c.getName());
            System.out.println(c.getTeacherId());
        });
        // ResultSetHandler <List<Question>> resultSetHandler=new
        // BeanListHandler<Question>(Question.class);

        // List<Question> questionList = db.run.query(db.getConn(),"SELECT * FROM
        // question where courseId=?",resultSetHandler,"3");
        // Collections.shuffle(questionList);

        // System.out.println("length: "+questionList.size());
        // for(Question q:questionList){
        // System.out.println("id: "+q.getId());
        // System.out.println("description: "+q.getDescription());
        // System.out.println("choice 1"+q.getChoiceOne());
        // System.out.println("choice 2"+q.getChoiceTwo());
        // System.out.println("choice 3"+q.getChoiceThree());
        // System.out.println("choice 4"+q.getChoiceFour());
        // System.out.println();
        // System.out.println("correct answer"+q.getCorrectChoice());
        // }

        // String sql="Insert into exam (courseId,Description) Values(?,?)";

        // int insertedRecords=db.run.update(db.getConn(),sql,"1","first exam ever");
        // System.out.println(insertedRecords);

    }

}