package ubc.cogs200.project.model;


import java.util.Set;

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

    // Percenters:
    public double percentActivistScore() {return getPercent(activistScore);}

    public double percentTheoristScore() {return getPercent(theoristScore);}

    public double percentPragmatistScore() {return getPercent(pragmatistScore);}

    public double percentReflectorScore() {return getPercent(reflectorScore);}



    private double addAll() {
        return activistScore + theoristScore + pragmatistScore + reflectorScore;
    }

    private double getPercent(double value) {
        return Math.round(value/addAll()*100);
    }

    public void clearProfile() {
        activistScore = 0;
        theoristScore = 0;
        pragmatistScore = 0;
        reflectorScore = 0;
    }

    public void updateProfile(Set<Student> students) {
        clearProfile();

        for (Student s : students) {
            updateScore(s);
        }
    }

    private void updateScore(Student s) {
        activistScore   += s.getProfile().certaintyActivistScore();
        theoristScore   += s.getProfile().certaintyTheoristScore();
        pragmatistScore += s.getProfile().certaintyPragmatistScore();
        reflectorScore  += s.getProfile().certaintyReflectorScore();
    }
}
