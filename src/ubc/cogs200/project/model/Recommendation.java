package ubc.cogs200.project.model;

/**
 * A Pedagogical Tool to Recommend to a Teacher
 */
public class Recommendation {
    String recommendation;
    String style;

    public Recommendation(String recommendation, String style) {
        this.recommendation = recommendation;
        this.style = style;

    }

    public String getRecommendation() {
        return recommendation;
    }

    public String getStyle() {
        return style;
    }
}

