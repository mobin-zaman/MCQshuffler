package dbfunctions;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.*;
import database.DB;
import classes.Question;
import java.util.*;

public class Questiondb {

    // for inserting a single question
    public static void insertQuestion(int courseid, Question q) {
        DB db = new DB();
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
        DB db = new DB();
        // needed for passing to db.run.query()
        ResultSetHandler<List<Question>> resultSetHandler = new BeanListHandler<Question>(Question.class);
        // needed for getting the results from table
        List<Question> questionList = null;
        String sql = "Select id FROM question where courseId=?";
        // retrieve from database
        try {
            questionList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getQuestionList(): " + e);
        }
        return questionList;
    }

    // for retrieving all the questions of an exam
    public static List<Question> getExamQuestions(int examId) {
        DB db = new DB();
        // needed for passing to db.run.query()
        ResultSetHandler<List<Question>> resultSetHandler = new BeanListHandler<Question>(Question.class);
        // needed for return
        List<Question> questionList = null;
        // this is an example of IN
        // needed for future reference as well
        String sql = "SELECT * FROM question WHERE id IN(SELECT questionId FROM exam_question WHERE examId=?)";

        try {
<<<<<<< HEAD
            questionList = db.run.query(db.getConn(), sql, resultSetHandler, examId);
=======
            System.out.println("Inserting Questions");
            db.run.update(db.getConn(), sql, q.getCourseId(), q.getDescription(), q.getChoiceOne(), q.getChoiceTwo(),
                    q.getChoiceThree(), q.getChoiceFour(), q.getCorrectChoice());
>>>>>>> f859d8c15cb2e8becc8569a84f73ca9d64e81784
        } catch (Exception e) {
            System.out.println("getExamQuestions(): " + e);
        }

        return questionList;
    }

    // self explanatory name
    public static List<Question> getRandomQuestionList(int courseId) {

        List<Question> questionList = getAllQuestionList(courseId);
        Collections.shuffle(questionList);
        return questionList;
    }
}