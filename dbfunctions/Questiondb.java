package dbfunctions;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.*;
import database.DB;
import classes.Question;
import java.util.*;
public class Questiondb{
    //self explanatory name
    public static List<Question> getRandomQuestionIdList(int courseId){
        DB db=new DB();
        //needed for passing to db.run.query()
        ResultSetHandler<List<Question>> resultSetHandler=new BeanListHandler(Question.class);
        //needed for getting the results from table
        List<Question> questionList=null;
        //retrieve from database
        try{
            questionList = db.run.query(db.getConn(),"SELECT id FROM question where courseId=?",resultSetHandler,"1");
        } catch(Exception e){
            System.out.println("getRandomQuestionIdList: "+e);
        }
        //return after shuffle
        Collections.shuffle(questionList);
        return questionList;
    }
}