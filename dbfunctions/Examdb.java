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

    // for retrieving all the questions of an exam
    public static List<Question> getExamQuestions(int examId) {
        DB db = DB.getDB();
        // needed for passing to db.run.query()
        ResultSetHandler<List<Question>> resultSetHandler = new BeanListHandler<Question>(Question.class);
        // needed for return
        List<Question> questionList = null;
        // this is an example of IN
        // needed for future reference as well
        String sql = "SELECT * FROM question WHERE id IN(SELECT questionId FROM exam_question WHERE examId=?)";

        try {
            questionList = db.run.query(db.getConn(), sql, resultSetHandler, examId);
        } catch (Exception e) {
            System.out.println("getExamQuestions(): " + e);
        }

        return questionList;
    }

    public static int getNumberOfQuestions(int examId) {
        List<Question> questionList = getExamQuestions(examId);
        return questionList.size();
    }

    public static void createExam(int courseId, String description, int numberOfQuestions, int duration) {
        DB db = DB.getDB();
        // fist insert the exam description, then retrieve id
        String sql = "Insert into exam(courseId,description,duration) Values(?,?,?)";
        try {
            db.run.update(db.getConn(), sql, courseId, description, duration);
        } catch (Exception e) {
            System.out.println("createExam(): " + e);
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

    public static void publishExam(int examId) {
        DB db = DB.getDB();
        String sql = "UPDATE `exam` SET `isPublished` = '1' WHERE `exam`.`id` = ?";

        try {
            db.run.update(db.getConn(), sql, examId);
        } catch (Exception e) {
            System.out.println("publsh exam: " + e);
        }
    }

    public static void runExam(int examId) {
        DB db = DB.getDB();
        List<Question> questionList = Examdb.getExamQuestions(examId);
        // shuffle for every exam instance
        Collections.shuffle(questionList);

        // TODO: needs to be continued after finishig gui
    }

    public void deleteExam(int examId) {
        DB db = DB.getDB();
        String sql = "DELETE FROM exam WHERE id=?";
        try {
            db.run.update(db.getConn(), sql, examId);
        } catch (Exception e) {
            System.out.println("deleteexam(): " + e);
        }
    }

    //
}