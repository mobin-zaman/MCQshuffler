package dbfunctions;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.*;
import database.DB;
import classes.Question;
import java.util.*;

public class Questiondb {
    // self explanatory name
    public static List<Question> getRandomQuestionList(int courseId) {

        List<Question> questionList = getAllQuestionList(courseId);
        Collections.shuffle(questionList);
        return questionList;
    }

    // the function needed for showing the question bank in courses
    // also needed for creating exam
    public static List<Question> getAllQuestionList(int courseId) {
        DB db = new DB();
        // needed for passing to db.run.query()
        ResultSetHandler<List<Question>> resultSetHandler = new BeanListHandler<Question>(Question.class);
        // needed for getting the results from table
        List<Question> questionList = null;
        // retrieve from database
        try {
            questionList = db.run.query(db.getConn(), "SELECT id FROM question where courseId=?", resultSetHandler,
                    courseId);
        } catch (Exception e) {
            System.out.println("getQuestionList(): " + e);
        }
        return questionList;
    }

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
}