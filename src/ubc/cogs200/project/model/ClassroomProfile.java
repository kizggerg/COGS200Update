package ubc.cogs200.project.model;


/**
 * The Statistics of the Classroom given Uncertainty in Student Modelling.
 */
public class ClassroomProfile {
    private double activistScore;
    private double theoristScore;
    private double pragmatistScore;
    private double reflectorScore;

    public ClassroomProfile() {
        activistScore = 0;
        theoristScore = 0;
        pragmatistScore = 0;
        reflectorScore = 0;
    }

    // Getters:
    public double getActivistScore() {
        return activistScore;
    }

    public double getTheoristScore() {
        return theoristScore;
    }

    public double getPragmatistScore() {
        return pragmatistScore;
    }

    public double getReflectorScore() {
        return reflectorScore;
    }

    private void updateScore(Student s) {
        activistScore   += s.getProfile().certaintyActivistScore();
        theoristScore   += s.getProfile().certaintyTheoristScore();
        pragmatistScore += s.getProfile().certaintyPragmatistScore();
        reflectorScore  += s.getProfile().certaintyReflectorScore();
    }

    // This seems more like UI behaviour -> Better for Cohesion
    public void getStats() {
        double total = activistScore + pragmatistScore + theoristScore + reflectorScore;
        System.out.println("your classroom is:");
        double activistPercent = activistScore / total * 100.00;
        System.out.println(activistPercent + "% Activist");
        double pragmatistPercent = pragmatistScore / total * 100.00;
        System.out.println(pragmatistPercent + "% Pragmatist");
        double theoristPercent = theoristScore / total * 100.00;
        System.out.println(theoristPercent + "% Theorist");
        double reflectorPercent = reflectorScore / total * 100.00;
        System.out.println(reflectorPercent + "% Reflector");

    }

    // This seems like behaviour for another class -> Better for Cohesion
    public void getRecommendations() {
        System.out.println("No recommendations set yet");
    }

}
