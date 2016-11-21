package ubc.cogs200.project.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaron on 11/17/2016.
 * Edited by Greg on 11/18/2016.
 */
public class Teacher {
    private String name;
    private String number;
    private Set<Classroom> classrooms;

    public Teacher(String name, String number) {
        this.name = name;
        this.number = number;
        classrooms = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Set<Classroom> getClassrooms() {
        return Collections.unmodifiableSet(classrooms);
    }

    public void add(Classroom classroom) {
        classrooms.add(classroom);
    }

    public void remove(Classroom classroom) {
        classrooms.remove(classroom);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
