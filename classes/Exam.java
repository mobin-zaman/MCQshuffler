package classes;

public class Exam {
    private int id;
    private int courseId;
    private String description;
    private int duration;
    private int isPublished;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setCourseId(int id) {
        this.courseId = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int minute) {
        this.duration = minute;
    }

    public int getDuration() {
        return duration;
    }

    public void setIsPublished(int p) {
        this.isPublished = p;
    }

    public int getIsPublished() {
        return isPublished;
    }

}