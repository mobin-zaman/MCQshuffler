package classes;

public class Question {
    private int id;
    private int courseId;
    private String Description;
    private String choiceOne;
    private String choiceTwo;
    private String choiceThree;
    private String choiceFour;
    private String correctChoice;

    public Question(int id, int courseId, String d, String c1, String c2, String c3, String c4, String correctAns) {
        this.id = id;
        this.courseId = courseId;
        this.Description = d;
        this.choiceOne = c1;
        this.choiceTwo = c2;
        this.choiceThree = c3;
        this.choiceFour = c4;
        this.correctChoice = correctAns;

    }

    public Question(int courseId, String d, String c1, String c2, String c3, String c4, String correctAns) {
        this.courseId = courseId;
        this.Description = d;
        this.choiceOne = c1;
        this.choiceTwo = c2;
        this.choiceThree = c3;
        this.choiceFour = c4;
        this.correctChoice = correctAns;

    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    public String getChoiceThree() {
        return choiceThree;
    }

    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }

    public String getChoiceFour() {
        return choiceFour;
    }

    public void setChoiceFour(String choiceFour) {
        this.choiceFour = choiceFour;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(String correctAnswer) {
        this.correctChoice = correctAnswer;
    }

    public boolean isCorrect(String choice) {
        return (choice.equals(correctChoice));
    }

}
