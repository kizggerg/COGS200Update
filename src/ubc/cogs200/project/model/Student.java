package ubc.cogs200.project.model;

/**
 * Created by Aaron on 11/10/2016.
 */
public class Student {

    private String name;
    private String studentNumber;
    private StudentProfile profile;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.profile = new StudentProfile();
    }

    public Student(String name, String studentNumber, StudentProfile profile) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public StudentProfile getProfile() {
        return profile;
    }

}
