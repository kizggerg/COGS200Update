package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.Classroom;
import ubc.cogs200.project.model.Staff;
import ubc.cogs200.project.model.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TeacherUI extends AbstractUI{
    Scanner input = new Scanner(System.in);
    Teacher teacher;
    Boolean newProfile;
    Classroom theClass;

    // List of Classrooms
    // Select classroom
    // Once Selected: Overview is Shown:
    //     - Number of Student
    //     - Stats of Classroom
    //     - Recommendations
    protected void initializeUI() {

        login();
        chooseClassroom();

        if (newProfile) {
            createProfile();
        }
        else retrieveData();

        for (Classroom classroom : teacher.getClassrooms()) {
            classroom.getProfile().getStats();
            classroom.getProfile().getRecommendations();}
    }

    protected void login() {
            System.out.println();
            System.out.println("Hello Teacher! What is your name?");
            String name = input.nextLine();
            System.out.println("Hi " + name + "! Please enter your ID number:");
            String number = input.nextLine();
            determineIfAlreadyInSystem(name, number);
    }


    protected void determineIfAlreadyInSystem(String name, String number) {
        Teacher t = Staff.getInstance().getTeacherinSystem(number);

        if (t == null) {
            System.out.println("Welcome " + name + ". Before we begin, let's create a profile!");
            teacher = new Teacher(name, number);
            newProfile = true;
        }

        else {
            System.out.println("Welcome " + name + ".");
            teacher = t;
            newProfile = false;
        }
    }

    //TODO: Implement this so teacher can only see her/his classes.
    //TODO: Copy this code to the student UI.
    protected void chooseClassroom() {
        List<Classroom> classes = Staff.getInstance().getAllClassrooms();
        System.out.println("Please choose the classroom you wish to examine:");

        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i+1) + ". " + classes.get(i).getCourseCode() + ": " +
                    classes.get(i).getName());
        }
        System.out.println();
        System.out.println("Simply enter the number which corresponds to the classroom you wish to examine:");

        Boolean continueLoop = true;
        Integer response = -1;

        while (continueLoop) {
            try {
                response = Integer.parseInt(input.nextLine().trim());
                if (response > 0 && response <= classes.size()) continueLoop = false;
                else  System.out.println("Simply enter the number which corresponds to the classroom you wish to examine:");
            } catch (NumberFormatException e) {
                System.out.println("Simply enter the number which corresponds to the classroom you wish to examine:");
            }
        }

        theClass = classes.get(response - 1);

    }

    private void createProfile() {
        //TODO: Implement Method
    }

    private void retrieveData() {

    }


}
