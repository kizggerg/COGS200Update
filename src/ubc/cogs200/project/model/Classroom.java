package ubc.cogs200.project.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A Classroom
 */
public class Classroom implements Iterable<Student> {
    private String name;
    private String code;
    private ClassroomProfile profile;
    private Set<Student> students;


    public Classroom(String name, String courseCode) {
        this.name = name;
        this.code = courseCode;
        students = new HashSet<>();
        profile = new ClassroomProfile();
    }

    // Getters
    public String getName() {return name;}

    public String getCourseCode() {
        return code;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public ClassroomProfile getProfile() {
        return profile;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void addStudent(Student s) {
        students.add(s);
    }

    public void addAllStudent(Set<Student> students) {this.students.addAll(students);}

    public void removeStudent(Student s) {students.remove(s);}

    public void clearClassroom() {students.clear();}

    public void updateClassroom() {
        profile.updateProfile(students);
    }

    public int getNumberOfStudents() {
        return students.size();
    }



    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }


}
