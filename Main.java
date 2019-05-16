import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JLabel;

import gui.Home;
import gui.teacher.*;
import classes.Course;
import dbfunctions.*;
import database.*;
import javax.swing.*;
import gui.utilities.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        // System.out.println(Studentdb.isRejected("1", "2"));

        // Studentdb.signUp(mobin, mobin);
        // List<Course> course = Coursedb.getEnrolledCourseList(1);
        // course.forEach((c) -> {
        // System.out.println(c.getId()); // System.out.println(c.getName());
        // System.out.println(c.getName());
        // System.out.println("teacher id: " + c.getTeacherId());
        // System.out.println("teacher name: " +
        // Teacherdb.getTeacherName(c.getTeacherId()));
        // });
        // List<Course> course = Coursedb.getCourseList("1");
        // String str = Coursedb.getNumberOfQuestions(course.get(0).getId());

        // Studentdb.deleteRequest(4,dd 1);
        // Teacherdb.rejectRuquest(9, 1);
        // System.out.println(Studentdb.requestCourse(1, 1));
        // FIXME: home
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setResizable(false);
        home.setVisible(true);

        // Homes home = new Homes();
        // home.setLocationRelativeTo(null);
        // home.setResizable(false);
        // home.setVisible(true);

        // System.out.println(Coursedb.getNumberOfQuestions(3));

        // Coursedb.deleteCourse(3);

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