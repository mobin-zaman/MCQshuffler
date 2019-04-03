package classes;

public class Course{
    private int id;
    private String name;
    private int teacherId;

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getTeacherId(){
        return teacherId;
    }

    public void setTeacherId(int teacherId){
        this.teacherId=teacherId;
    }



}