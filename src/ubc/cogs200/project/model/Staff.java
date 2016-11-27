package ubc.cogs200.project.model;

import java.util.HashSet;
import java.util.Set;

/**
 * A set of all Teachers in the System.
 * Singleton Design Pattern used.
 */
public class Staff {
    private static Staff instance;
    private Set<Teacher> teachers;

    private Staff() {
        teachers = new HashSet<>();
    }

    public static Staff getInstance() {
        if (instance == null) {
            instance = new Staff();
        }
        return instance;
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    public void addAll(Set<Teacher> t) {
        teachers.addAll(t);
    }

    public void removeTeacher(Teacher t) {
        teachers.remove(t);
    }

    public void clearStaff() {
        teachers.clear();
    }


}
