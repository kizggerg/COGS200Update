package ubc.cogs200.project.model;

/**
 * A Question
 */
public class Question {
    private String question;
    private String style;

    public Question(String question, String style) {
        this.question = question;
        this.style = style;
    }

    public String getQuestion() {return question;}

    public String getStyle() {return style;}
}
