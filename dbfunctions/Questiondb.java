package dbfunctions;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.*;
import database.DB;
import classes.Question;
import java.util.*;

public class Questiondb {

    // for inserting a single question
    public static void insertQuestion(Question q) {
        DB db = DB.getDB();
        String sql = "Insert into question (courseId,description,choiceOne,choiceTwo,choiceThree,choiceFour,correctChoice) Value(?,?,?,?,?,?,?)";
        try {
            db.run.update(db.getConn(), sql, q.getCourseId(), q.getDescription(), q.getChoiceOne(), q.getChoiceTwo(),
                    q.getChoiceThree(), q.getChoiceFour(), q.getCorrectChoice());
        } catch (Exception e) {
            System.out.println("insertQuestion(): " + e);
        }
    }

    // the function needed for showing the question bank in courses
    // also needed for creating exam
    public static List<Question> getAllQuestionList(int courseId) {
        DB db = DB.getDB();
        // needed for passing to db.run.query()
        ResultSetHandler<List<Question>> resultSetHandler = new BeanListHandler<Question>(Question.class);
        // needed for getting the results from table
        List<Question> questionList = null;
        String sql = "Select * FROM question where courseId=?";
        // retrieve from database
        try {
            questionList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getQuestionList(): " + e);
        }
        return questionList;
    }

    // self explanatory name
    public static List<Question> getRandomQuestionList(int courseId) {

        List<Question> questionList = getAllQuestionList(courseId);
        Collections.shuffle(questionList);
        return questionList;
    }

    // TODO: fix this method
    // public static void updateQuestion(Question q){
    // DB db =DB.getDB();
    // String sql="UPDATE `question` SET `description` = ? , `choiceOne` = ? ,
    // `choiceTwo` = ?, `choiceThree` = ?, `choiceFour` = ?, `correctChoice` = ?
    // WHERE `question`.`id` = ?";
    // try{
    // db.run.update(db.getConn(),sql,q.getId(),q.getDescription(),q.getChoiceOne(),q.getChoiceTwo(),q.getChoiceThree(),q.getChoiceFour(),q.getCurrectChoice(),q.getId());
    // }
    // catch(Exception e){
    // System.out.println("updateQuestion(): "+e);
    // }
    // }

    public static void deleteQuestion(int questionId) {
        DB db = DB.getDB();
        String sql = "DELETE FROM question WHERE id=?";
        try {
            db.run.update(db.getConn(), sql, questionId);
        } catch (Exception e) {
            System.out.println("Delete question: " + e);
        }
    }

}