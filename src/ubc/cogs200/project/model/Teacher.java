package ubc.cogs200.project.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A Teacher
 */
public class Teacher {
    private String name;
    private String id;
    private Set<Classroom> classes;

    public Teacher(String name, String number) {
        this.name = name;
        this.id = number;
        classes = new HashSet<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getNumber() {
        return id;
    }

    public Set<Classroom> getClassrooms() {
        return Collections.unmodifiableSet(classes);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.id = number;
    }



    public void add(Classroom classroom) {
        classes.add(classroom);
    }

    public void remove(Classroom classroom) {
        classes.remove(classroom);
    }


}
