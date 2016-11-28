package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.*;

import java.util.List;
import java.util.Scanner;

public class StudentUI extends AbstractUI {
    private Scanner input = new Scanner(System.in);
    private Student student;
    private Classroom theClass;

    protected void initializeUI() {
        login();
        askToBegin();
        initializeQuestionnaire();
        endQuestionnaire();
        System.exit(0);
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
            theClass.addStudent(student);
        }
        else {
            System.out.println("Welcome back " + name + "! Thanks for taking our questionnaire again :) We hope its just as fun as before.");
            student = s;
            theClass = Staff.getInstance().getClassStudentIsIn(student);
            student.getProfile().clearProfile();

        }
    }

    protected void chooseClassroom() {
        List<Classroom> classes = Staff.getInstance().getAllClassrooms();
        System.out.println("Please choose the your classroom:");

        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i+1) + ". " + classes.get(i).getCourseCode() + ": " +
                    classes.get(i).getName());
        }
        System.out.println();
        System.out.println("Simply enter the number which corresponds to your classroom:");

        Boolean continueLoop = true;
        Integer response = -1;

        while (continueLoop) {
            try {
                response = Integer.parseInt(input.nextLine().trim());
                if (response > 0 && response <= classes.size()) continueLoop = false;
                else  System.out.println("Simply enter the number which corresponds to your classroom:");
            } catch (NumberFormatException e) {
                System.out.println("Simply enter the number which corresponds to your classroom:");
            }
        }
        theClass = classes.get(response - 1);
    }

    private void askToBegin() {
        System.out.println();
        System.out.println("In this questionnaire, we will try to determine your individual style of learning.");
        System.out.println("These styles can be very different from your other classmates, and teaching to a group of various different learners can be challenging.");
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

    private void initializeQuestionnaire() {
        System.out.println("The questionnaire has begun. Have fun!");
        System.out.println();
        List <Question> questions = Questionnaire.getInstance().getQuestions();
        String response;

        for (Question q : questions) {
            System.out.println(q.getQuestion());
            System.out.println("Enter 'agree' if you agree, 'disagree' if you do not agree, and enter anything else if you are neutral/unsure");
            response = input.nextLine();
            if (response.trim().equalsIgnoreCase("agree")) student.getProfile().addScore(q.getStyle().toLowerCase().trim());
        }
    }

    private void endQuestionnaire() {
        System.out.println("That's it! Thanks for participating!");
        System.out.println("If you are curious about your learning style, we predict that you are:");
        System.out.println(Math.round(student.getProfile().certaintyActivistScore()*100) + "% of an Activist Learner.");
        System.out.println(Math.round(student.getProfile().certaintyTheoristScore()*100) + "% of an Theorist Learner.");
        System.out.println(Math.round(student.getProfile().certaintyPragmatistScore()*100) + "% of an Pragmatist Learner.");
        System.out.println(Math.round(student.getProfile().certaintyReflectorScore()*100) + "% of an Reflector Learner.");
        System.out.println("To see what each of these learning styles mean for you, visit http://www2.le.ac.uk/departments/gradschool/training/eresources/teaching/theories/honey-mumford.");
        System.out.println("Have a great day!");
        //TODO: Parse Data as JSON
    }

}

