package ubc.cogs200.project.model;

/**
 * Created by Aaron on 11/10/2016.
 * Edited by Greg on 11/17/2016
 */

public class StudentProfile {
    // Using the Honey and Mumford Learning Styles Model, a student is categorized into one of four learning styles:
    private int actvist;
    private int theorist;
    private int pragmatist;
    private int reflector;
    // The int value compared with the total values determines the certainty that has one of these learning styles.

    public StudentProfile() {
        this.actvist = 0;
        this.theorist = 0;
        this.pragmatist = 0;
        this.reflector = 0;
    }

    // Getters
    public int getActvistScore() {
        return actvist;
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

    // Returns the score of all learning styles: not useful outside of class
    private int getAll() {
        return actvist + theorist + pragmatist + reflector;
    }

    //Setters: Current implementation only allows one point to be added at a time to each style
    public void addScoreActivist() {
        actvist++;
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
        actvist = 0;
        theorist = 0;
        pragmatist = 0;
        reflector = 0;
    }

    public void clearScoreActivist() {
        actvist = 0;
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

    // Percenters: Return the ratio of the learning style to the total profile as a percent (% sign excluded).
    public double percentActvistScore() {
        return Math.round(actvist/(double)getAll() * 100.00);
    }

    public double percentTheoristScore() {
        return Math.round(theorist/(double)getAll() * 100.00);
    }

    public double percentPragmatistScore() {
        return Math.round( pragmatist/(double)getAll() * 100.00);
    }

    public double percentReflectorScore() {
        return Math.round(reflector/(double)getAll() * 100.00);
    }





}
