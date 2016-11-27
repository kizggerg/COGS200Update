package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.Staff;
import ubc.cogs200.project.model.Student;
import java.util.Scanner;
import java.util.zip.DataFormatException;

// todo: Implement questionnaire
public class StudentUI extends AbstractUI {
    Scanner input = new Scanner(System.in);
    Student student;

    public void initializeUI() {
        login();
        askToBegin();
    }

    private void login() {
        System.out.println();
        System.out.println("Hello Student! What is your name?");
        String name = input.nextLine();
        System.out.println("Hi " + name + "! Please enter your student number:");
        String number = input.nextLine();
        determineIfAlreadyInSystem(name, number);
    }

    private void determineIfAlreadyInSystem(String name, String number) {
        Student s = Staff.getInstance().getStudentinSystem(number);

        if (s == null) {
            System.out.println("Welcome " + name + ". We hope you enjoy your first time doing our questionnaire!");
            student = new Student(name, number);
        }
        else {
            System.out.println("Welcome back " + name + "! Thanks for taking our questionnaire again :) We hope its just as fun as before.");
            student = s;
            student.getProfile().clearProfile();
        }
    }

    private void askToBegin() {
        System.out.println();
        System.out.println("In this questionnaire, we will try to determine how your individual style of learning.");
        System.out.println("These styles can be very different from your other classmates, and so teaching to a group of various different learners can be challenging");
        System.out.println("We want to make it possible for everyone to learn better by giving your teacher better data on how you learn.");
        System.out.println();
        System.out.println("We will ask you a series of questions. All you need to do is to type 'agree' if your agree with the statement.");
        System.out.println("If you disagree with the statement, are neutral, or just generally don't know, you can enter anything else, as long as its not 'agree'!");
        System.out.println("Best of luck, and have fun!");
        System.out.println("When you are ready, type 'begin' to start the questionnaire.");
        while (!(input.nextLine().toLowerCase().equals("begin"))) {
            System.out.println("Type 'begin' to start the questionnaire.");
        }
        System.out.println("The questionnaire has begun. Have fun!");

    }


    // Returns 0 for activist, 1 for theorist, 2 for pragmatist, and 3 for reflector.
    private static int parseStyleType(String style) throws DataFormatException {
        switch (style.toLowerCase()) {
            case "activist" : return 0;
            case "theorist" : return 1;
            case "pragmatist" : return 2;
            case "reflector" : return 3;
            default: throw new DataFormatException();
        }
    }

    // Computes the student answer in a way that is meaningful to the Student Model
    private static boolean parseAnswer(String answer) {
        return (answer.toLowerCase().equals("yes"));
    }

    // Updates the model if the given boolean is true
    private static void updateProfile(Student s, int style, boolean update) {
        if (update) {
            switch (style) {
                case 0: s.getProfile().addScoreActivist();
                case 1: s.getProfile().addScoreTheorist();
                case 2: s.getProfile().addScorePragmatist();
                case 3: s.getProfile().addScoreReflector();
            }
        }

    }

}

