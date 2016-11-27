package ubc.cogs200.project.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A Teacher
 */
public class Teacher {
    private String name;
    private String id;   //Each ID is unique to a teacher
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

    public void addAll(Set<Classroom> classes) {this.classes.addAll(classes);}

    public void remove(Classroom classroom) {
        classes.remove(classroom);
    }

    public void clearClasses() {classes.clear();}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return id.equals(teacher.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
