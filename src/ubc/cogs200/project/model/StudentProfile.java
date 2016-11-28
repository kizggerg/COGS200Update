package ubc.cogs200.project.model;

/**
 * The Statistics of a Student's Learning Style
 */

public class StudentProfile {
    // Using the Honey and Mumford Learning Styles Model, a student is categorized into one of four learning styles:
    private int activist;
    private int theorist;
    private int pragmatist;
    private int reflector;
    // The int value compared with the total values determines the certainty that has one of these learning styles.

    public StudentProfile() {
        this.activist = 0;
        this.theorist = 0;
        this.pragmatist = 0;
        this.reflector = 0;
    }

    // Getters
    public int getActivistScore() {
        return activist;
    }

    public int getTheoristScore() {
        return theorist;
    }

    public int getPragmatistScore() {
        return pragmatist;
    }

    public int getReflectorScore() {
        return reflector;
    }

    //Setters:
    public void setAll(int activist, int theorist, int pragmatist, int reflector) {
        this.activist = activist;
        this.theorist = theorist;
        this.pragmatist = pragmatist;
        this.reflector = reflector;
    }

    public void setActivist(int a) {
        activist = a;
    }

    public void setTheorist(int a) {
        theorist = a;
    }

    public void setPragmatist(int a) {
        pragmatist = a;
    }

    public void setReflector(int a) {
        reflector = a;
    }


    public void addScore(String style) {
        switch (style) {
            case "activist" : {
                activist++;
                break;
            }
            case "theorist" : {
                theorist++;
                break;
            }
            case "pragmatist" : {
                pragmatist++;
                break;
            }
            case "reflector" : {
                reflector++;
                break;
            }
            default: break;
        }
    }

    public void addScoreActivist() {
        activist++;
    }

    public void addScoreTheorist() {
        theorist++;
    }

    public void addScorePragmatist() {
        pragmatist++;
    }

    public void addScoreReflector() {
        reflector++;
    }

    // Cleaerers: Clears the score for each or all learning style
    public void clearProfile() {
        activist = 0;
        theorist = 0;
        pragmatist = 0;
        reflector = 0;
    }

    public void clearScoreActivist() {
        activist = 0;
    }

    public void clearScoreTheorist() {
        theorist = 0;
    }

    public void clearScorePragmatist() {
        pragmatist = 0;
    }

    public void clearScoreReflector() {
        reflector = 0;
    }

    // Certainty: Returns the likelihood student maps to one learning style.
    public double certaintyActivistScore() {
        return activist/(double)getAll()/1.00;
    }

    public double certaintyTheoristScore() {
        return theorist/(double)getAll()/1.00;
    }

    public double certaintyPragmatistScore() {
        return pragmatist/(double)getAll()/1.00;
    }

    public double certaintyReflectorScore() {
        return reflector/(double)getAll()/1.00;
    }

    // Returns the score of all learning styles: not useful outside of class
    private int getAll() {
        return activist + theorist + pragmatist + reflector;
    }

}
