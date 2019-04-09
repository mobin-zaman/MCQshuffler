package dbfunctions;

import database.DB;
import classes.*;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.*;

public class Examdb {

    public static List<Exam> getExamList(int courseId) {
        List<Exam> examList = null;
        DB db = DB.getDB();

        String sql = "SELECT * FROM exam WHERE courseId=?";
        ResultSetHandler<List<Exam>> resultSetHandler = new BeanListHandler<Exam>(Exam.class);
        try {
            examList = db.run.query(db.getConn(), sql, resultSetHandler, courseId);
        } catch (Exception e) {
            System.out.println("getExamList(): " + e);
        }
        return examList;
    }

    public static void createExam(String description, int numberOfQuestions, int courseId, int duration) {
        DB db = DB.getDB();
        // fist insert the exam description, then retrieve id
        String sql = "Insert into exam(courseId,description,duration) Values(?,?,?)";
        try {
            db.run.update(db.getConn(), sql, courseId, description, duration);
        } catch (Exception e) {
            System.out.println(e);
        }
        // retrieving done
        int examId = db.lastInsertId();
        System.out.println("insertid: " + examId);

        // now get Question of the corresponding course for the exam
        // we get it by the courseId parameter
        List<Question> questionList = Questiondb.getRandomQuestionList(courseId);

        // now insert into exam_relations table, given by numberOfQuestions

        // sql for the insertion
        sql = "Insert into exam_question(examId,questionId) Values(?,?)";
        for (int i = 0; i < numberOfQuestions; i++) {
            int x = questionList.get(i).getId();
            try {
                db.run.update(db.getConn(), sql, examId, x);
            } catch (Exception e) {
                System.out.println("createExam: " + e);
            }
        }
    }

    public static void runExam(int examId) {
        DB db = DB.getDB();
        List<Question> questionList = Questiondb.getExamQuestions(examId);
        // shuffle for every exam instance
        Collections.shuffle(questionList);

        // TODO: needs to be continued after finishig gui
    }

    //
}