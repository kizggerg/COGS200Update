package ubc.cogs200.project.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Greg on 2016-11-17.
 * Singleton Design Pattern
 */
public class Classroom implements Iterable<Student> {
    private Teacher teacher;
    private Set<Student> students;
    private ClassroomProfile profile;

    public Classroom(Teacher teacher) {
        this.teacher = teacher;
        students = new HashSet<>();
        profile = new ClassroomProfile();
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    // MIGHT NOT NEED?
    public ClassroomProfile getProfile() {
        return profile;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public int getNumberOfStudents() {
        return students.size();
    }


    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
