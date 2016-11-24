package ubc.cogs200.project.model;


/**
 * Created by Greg on 2016-11-18.
 */
public class ClassroomProfile {
    // Temporary Implementation of Fields
    private Classroom thisClass;

    private int activistTotalScore;
    private int theoristTotalScore;
    private int pragmatistTotalScore;
    private int reflectorTotalScore;

    private double activistUncertainScore;
    private double theoristUncertainScore;
    private double pragmatistUncertainScore;
    private double reflectorUncertainScore;

    private int numberOfStudents;

    private int activistPercent;
    private int pragmatistPercent;
    private int theoristPercent;
    private int reflectorPercent;

    public ClassroomProfile() {
        activistTotalScore = 0;
        theoristTotalScore = 0;
        pragmatistTotalScore = 0;
        reflectorTotalScore = 0;

        activistUncertainScore = 0.00;
        theoristUncertainScore = 0.00;
        pragmatistUncertainScore = 0.00;
        reflectorUncertainScore = 0.00;
    }

    public void parseClassroomData() {
        for (Student s : thisClass) {
            updateAll(s);
        }
    }

    public void updateAll(Student s) {
        StudentProfile student = s.getProfile();
        updateScore(student.getActivistScore(), (student.percentActivistScore() / 100.00), 0);
        updateScore(student.getTheoristScore(), (student.percentTheoristScore() / 100.00), 1);
        updateScore(student.getPragmatistScore(), (student.percentPragmatistScore() / 100.00), 2);
        updateScore(student.getReflectorScore(), (student.percentReflectorScore() / 100.00), 3);
    }


    private void updateScore(int total, double uncertain, int type) {
        // type is: 0 for activist, 1 for theorist, 2 for pragmatist, and 3 for reflector.
        switch (type) {
            case 0 : {
                activistTotalScore += total;
                activistUncertainScore += total*uncertain;
            }
            case 1 : {
                theoristTotalScore += total;
                theoristUncertainScore += total*uncertain;
            }
            case 2 : {
                pragmatistTotalScore += total;
                pragmatistUncertainScore += total*uncertain;
            }
            case 3 : {
                reflectorTotalScore += total;
                pragmatistUncertainScore += total*uncertain;
            }
        }
    }


    public void getStats() {
        int total = activistTotalScore + pragmatistTotalScore + theoristTotalScore + reflectorTotalScore;
        System.out.println("your classroom is:");
        activistPercent = activistTotalScore / total * 100;
        System.out.println(activistPercent + "% Activist");
        pragmatistPercent = pragmatistTotalScore / total * 100;
        System.out.println(pragmatistPercent + "% Pragmatist");
        theoristPercent = theoristTotalScore / total * 100;
        System.out.println(theoristPercent + "% Theorist");
        reflectorPercent = reflectorTotalScore / total * 100;
        System.out.println(reflectorPercent + "% Reflector");

    }

    public void getRecommendations() {
        System.out.println("No recommendations set yet");
    }
}
