package ubc.cogs200.project.model;

/**
 * A Student
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

    public String getName() {
        return name;
    }

    public String getNumber() {
        return studentNumber;
    }

    public StudentProfile getProfile() {
        return profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setProfile(StudentProfile profile) {this.profile = profile;}

}
