package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.Classroom;
import ubc.cogs200.project.model.Staff;
import ubc.cogs200.project.model.Student;
import java.util.Scanner;
import java.util.zip.DataFormatException;

// todo: Implement questionnaire
public class StudentUI extends AbstractUI {
    Scanner input = new Scanner(System.in);
    Student student;
    Classroom theClass;

    protected void initializeUI() {
        login();
        askToBegin();
        System.out.println("The questionnaire has begun. Have fun!");
        //TODO: Implement Questionnaire
        //TODO: Write Data from Questionnaire to JSON File
    }

    protected void login() {
        System.out.println();
        System.out.println("Hello Student! What is your name?");
        String name = input.nextLine();
        System.out.println("Hi " + name + "! Please enter your student number:");
        String number = input.nextLine();
        determineIfAlreadyInSystem(name, number);
    }

    protected void determineIfAlreadyInSystem(String name, String number) {
        Student s = Staff.getInstance().getStudentinSystem(number);

        if (s == null) {
            System.out.println("Welcome " + name + ". We hope you enjoy your first time doing our questionnaire!");
            student = new Student(name, number);
            chooseClassroom();
        }
        else {
            System.out.println("Welcome back " + name + "! Thanks for taking our questionnaire again :) We hope its just as fun as before.");
            student = s;
            student.getProfile().clearProfile();
            chooseClassroom();
        }
    }

    protected void chooseClassroom() {

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
    }

}

