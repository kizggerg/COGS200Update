package ubc.cogs200.project.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A Questionnaire given to Students to Test their Learning Styles.
 * Singleton Design Pattern Used
 */
public class Questionnaire implements Iterable<Question> {
    private static Questionnaire instance;
    private Set<Question> questions;

    private Questionnaire() {
        questions = new HashSet<>();
    }

    public static Questionnaire getInstance() {
        if (instance == null)
            instance = new Questionnaire();
        return instance;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void removeQuestion(Question q) {
        questions.remove(q);
    }

    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }
}
