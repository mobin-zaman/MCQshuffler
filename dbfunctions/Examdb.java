package dbfunctions;
import database.DB;
import classes.*;
import java.util.List;

public class Examdb{
public static void createExam(String description, int numberOfQuestions, int courseId){
    DB db = new DB();
    //fist insert the exam description, then retrieve id
    String sql="Insert into exam(courseId,Description) Values(?,?)";
    try{
        db.run.update(db.getConn(),sql,courseId,description);
    } catch (Exception e){
        System.out.println(e);
    }
    //retrieving done
    int examId=db.lastInsertId();
    System.out.println("insertid: "+examId);
    
    //now get Question of the corresponding course for the exam
    //we get it by the courseId parameter
    List <Question> questionList =Questiondb.getRandomQuestionList(courseId);

    //now insert into exam_relations table, given by numberOfQuestions

    //sql for the insertion

    sql="Insert into exam_question(examId,questionId) Values(?,?)";
        for(int i=0;i<numberOfQuestions;i++){
        int x=questionList.get(i).getId();
        try { db.run.update(db.getConn(), sql, examId,x);
          } catch(Exception e) {System.out.println("createExam: "+e);}
        }
    }
}