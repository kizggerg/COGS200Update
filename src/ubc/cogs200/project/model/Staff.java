package ubc.cogs200.project.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public Student getStudentinSystem(String number) {
        Student s = new Student("", number);
        Student result = null;

        for (Teacher t : teachers) {
            for (Classroom c : t.getClassrooms()) {
                result = c.getStudent(s);
            }
        }

        return result;
    }

    public Teacher getTeacherinSystem(String number) {
        Teacher t = new Teacher("", number);
        Teacher result = null;

        for (Teacher teacher : teachers) {
            if (teacher.equals(t)) result = teacher;
        }

        return result;
    }

    public List<Classroom> getAllClassrooms() {
        List<Classroom> result = new ArrayList<>();

        for (Teacher t : teachers) {
            Set<Classroom> classes = t.getClassrooms();
            if (classes != null) {
            result.addAll(t.getClassrooms());
            }
        }
        return result;
    }

    public Classroom getClassStudentIsIn(Student s) {
        Classroom result = null;

        for (Teacher t : teachers) {
            for (Classroom classroom : t.getClassrooms()) {
                if (classroom.containsStudent(s)) {
                    result = classroom;
                }
            }

        }

        return result;
    }


}
