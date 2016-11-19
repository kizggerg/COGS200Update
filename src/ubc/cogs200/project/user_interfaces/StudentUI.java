package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.Classroom;
import ubc.cogs200.project.model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class StudentUI {

    public static void main(String[] args) throws FileNotFoundException, DataFormatException{

        File file = new File("./data/questions.txt"); // THE SOURCE OF THIS FILE WILL NEED TO BE CHANGED
        Scanner sc = new Scanner(System.in);

        System.out.println("This is a very crude implementation of what a student would see in their questionaire.");
        System.out.println("This UI is meant to serve for modeling purposes only.");
        System.out.println("Type 'begin' to start the questionaire.");
        String input = sc.nextLine().toLowerCase();
        while (!(input.equals("begin"))) {
            System.out.println("Type 'begin' to start the questionaire.");
            input = sc.nextLine().toLowerCase();
        }
        System.out.println("The questionnaire has begun.");

        System.out.println("What is your name:");
        String name = sc.nextLine();
        System.out.println("What is your student number?");
        String number = sc.nextLine();
        ubc.cogs200.project.model.Student s = new ubc.cogs200.project.model.Student(name, number);

        System.out.println("Thank you. Please answer the following questions to the best of your ability.");

        // THIS IS A TEMPORARY IMPLEMENTATION OF THE QUESTIONAIRE
        Scanner questions = new Scanner(file);
        String line;
        int style;

        while (questions.hasNextLine()) {
            line = questions.nextLine();
            System.out.println(line);
            System.out.println("Type 'yes' (without quotations) if you agree with the statement, type 'no' (without quotations) if you disagree, and type anything else if you don't know:");
            input = sc.next();
            line = questions.nextLine();
            style = parseStyleType(line);
            updateProfile(s, style, parseAnswer(input));
        }
        questions.close();
        // Add student to Classroom
        System.out.println("This is the end of the questionaire.");
        System.out.println("Your learning style is:");
        System.out.println(s.getProfile().percentActvistScore() + "% activist learner.");
        System.out.println(s.getProfile().percentTheoristScore() + "% theorist learner.");
        System.out.println(s.getProfile().percentPragmatistScore() + "% pragmatist learner.");
        System.out.println(s.getProfile().percentReflectorScore() + "% reflector learner.");
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
    private static void updateProfile(ubc.cogs200.project.model.Student s, int style, boolean update) {
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

