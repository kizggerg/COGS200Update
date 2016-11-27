package ubc.cogs200.project.user_interfaces;

import org.json.JSONException;
import ubc.cogs200.project.parsers.DataParser;
import ubc.cogs200.project.parsers.QuestionsParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This UI serves as a Template for both UIs.
 */
public abstract class AbstractUI {

    public static void main(String[] args) {
        setUp();
        displayIntroduction();
        chooseUI();
    }

    protected abstract void initializeUI();

    protected abstract void login();

    protected abstract void determineIfAlreadyInSystem(String name, String number);

    protected abstract void chooseClassroom();

    /**
     * Updates the internal state by parsing from the data files.
     */
    private static void setUp() {
        try {
            String questions = "./data/questions.txt";
            String data = "./data/data.json";

            QuestionsParser qParser = new QuestionsParser(questions);
            DataParser dParser = new DataParser(data);

            qParser.parse();
            dParser.parse();
        }
        catch (FileNotFoundException e) {
            System.out.println("Questions or Data File Not Found");
            e.printStackTrace();
        }
        catch (JSONException e) {
            System.out.println("Data File Not Improperly Formatted");
            e.printStackTrace();
        }
    }


    /**
     * Informs the user of the crudeness of the model and thanks them for trying this demo out.
     */
    private static void displayIntroduction() {
        System.out.println("Welcome!");
        System.out.println("This is the initial implementation of a tool we hope will improve the standard of learning in the classroom.");
        System.out.println("This UI is meant to serve for demo purposes only, and does not accurately reflect how we anticipate the final product to look.");
        System.out.println("That being said, we have worked our hardest to make sure this tool will be effective. Please let us know if you have any concerns.");
        System.out.println("Thank you for taking a step with us to improve student learning!");
    }

    /**
     * Decides which UI the user wishes to enter.
     */
    private static void chooseUI() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Are you a student (type 'student') or a teacher (type 'teacher')?");
        String input = in.nextLine().toLowerCase().trim();
        while (!(input.equals("student") || input.equals("teacher"))) {
            System.out.println("Please type 'student' if you wish to enter as a student, or");
            System.out.println("please type 'teacher' if you wish to enter as a teacher.");
            input = in.nextLine().toLowerCase().trim();
        }
        if (input.equals("student")) {
            StudentUI sUI = new StudentUI();
            sUI.initializeUI();

        }
        if (input.equals("teacher")) {
            TeacherUI tUI = new TeacherUI();
            tUI.initializeUI();
        }
    }
}
