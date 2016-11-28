package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TeacherUI extends AbstractUI{
    Scanner input = new Scanner(System.in);
    Teacher teacher;
    Classroom theClass;

    protected void initializeUI() {

        login();
        retrieveOrEditData();

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
            System.out.println("Welcome " + name + ". Let's create your profile!");
            teacher = new Teacher(name, number);
            createProfile();

        }

        else {
            System.out.println("Welcome " + name + ".");
            teacher = t;
        }
    }

    protected void chooseClassroom() {
        List<Classroom> classes = new ArrayList<>();
        classes.addAll(teacher.getClassrooms());
        System.out.println("Please choose the classroom you wish to examine:");

        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getCourseCode() + ": " +
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
                else
                    System.out.println("Simply enter the number which corresponds to the classroom you wish to examine:");
            } catch (NumberFormatException e) {
                System.out.println("Simply enter the number which corresponds to the classroom you wish to examine:");
            }
        }
        theClass = classes.get(response - 1);
    }


    private void createProfile() {
        System.out.println();
        System.out.println("How many classes do you have? (Please enter a number)");
        String response;
        int numberOfClasses = -1;
        boolean continueLoop = true;

        while (continueLoop) {
            try {
                response = input.nextLine().trim();
                numberOfClasses = Integer.parseInt(response);
                if (numberOfClasses < 0) {
                    System.out.println("I don't understand that response. Let's try again:");
                    System.out.println("How many classes do you have? (Please enter a number)");
                }
                else {continueLoop = false;}

            } catch (NumberFormatException e) {
                System.out.println("I don't understand that response. Let's try again:");
                System.out.println("How many classes do you have? (Please enter a number)");
            }
        }

        if (numberOfClasses == 0) {
            System.out.println("Okay! We'll create a profile for you with 0 classes.");
        }
        else {
            System.out.println("Great! Let's create " + numberOfClasses + " class(es) for your profile.");

            while (numberOfClasses > 0) {
                System.out.println("Let's create a new Classroom!");
                createClassroom();
                numberOfClasses--;
            }
        }

        System.out.println("Your profile has been created! Please remember you can update your profile at any time!");
        System.out.println("See you again soon :)");
        System.exit(0);

    }

    private void retrieveOrEditData() {
        System.out.println("Would you like to:");
        System.out.println("1. Retrieve a profile from one of your classrooms.");
        System.out.println("2. Edit your profile.");
        System.out.println("Please enter the number corresponding to the thing you wish to do:");
        String response = input.nextLine().trim();

        if (response.equals("1")) {
            if (teacher.getClassrooms().isEmpty()) {
                System.out.println("You have no classes on file to retrieve data from.");
                System.out.println("You can always change this by editing your profile.");
                System.out.println("Have a nice day :)");
                System.exit(0);
            }
            else retrieveData();
        }
        else if (response.equals("2")) {
            editProfile();
        }
        else {
            System.out.println("I'm sorry, I don't understand your response. Let's try again:");
            retrieveOrEditData();
        }
    }

    private void editProfile() {
        System.out.println("Here is what we have on record in your profile:");
        System.out.println("Your name: " + teacher.getName());
        System.out.println("Your ID: " + teacher.getNumber());
        System.out.println("Your Classrooms:");
        if (teacher.getClassrooms().isEmpty()) {
            System.out.println(" - None on File");
        }
        else {
            for (Classroom c : teacher.getClassrooms()) {
                System.out.println(" - " + c.getCourseCode() + ": " + c.getName());
            }
        }

        System.out.println();
        System.out.println("What would you like to edit?");
        System.out.println("1. Your name");
        System.out.println("2. Your ID.");
        System.out.println("3. Your Classrooms.");
        boolean continueLoop = true;
        String response;

        while (continueLoop) {
            System.out.println("Please enter the number corresponding to the thing you wish to edit:");
            response = input.nextLine().trim();
            if (response.equals("1")) {
                System.out.println("Please enter the name you would like to keep on record:");
                teacher.setName(input.nextLine());
                continueLoop = false;
            } else if (response.equals("2")) {
                System.out.println("Please enter the ID you would like to keep on record:");
                teacher.setNumber(input.nextLine());
                continueLoop = false;
            } else if (response.equals("3")) {
                boolean continueNestedLoop = true;
                String nextResponse;

                while (continueNestedLoop) {
                    System.out.println("What would you like to do with your classrooms?");
                    System.out.println("1. Add a Classroom");
                    System.out.println("2. Remove a Classroom");
                    System.out.println("3. Clear all Classrooms");
                    System.out.println("Please enter the number corresponding to the thing you'd like to do:");
                    nextResponse = input.nextLine().trim();

                    if (nextResponse.equals("1")) {
                        System.out.println("Great. Let's add a classroom!");
                        createClassroom();
                        continueNestedLoop = false;
                    } else if (nextResponse.equals("2")) {
                        System.out.println("Please enter the course code of the classroom you wish to remove:");
                        teacher.remove(new Classroom("", input.nextLine()));
                        System.out.println("The class has been removed from your profile.");
                        continueNestedLoop = false;
                    } else if (nextResponse.equals("3")) {
                        teacher.clearClasses();
                        System.out.println("All of your classes have been cleared from your profile.");
                        continueNestedLoop = false;
                    } else {
                        System.out.println("I'm sorry, I didn't understand that response, let's try again.");
                    }
                }

                continueLoop = false;

            } else {
                System.out.println("I'm sorry, I didn't understand that response, let's try again.");
            }
        }

        System.out.println("I have successfully edited your profile!");
        System.out.println("Have a great day :)");
        System.exit(0);
    }

    private void retrieveData() {
        if (teacher.getClassrooms().size() == 1) {
            Set<Classroom> classes = teacher.getClassrooms();
            List<Classroom> c = new ArrayList<>();
            c.addAll(classes);
            theClass = c.get(0);
            getSummary(theClass);
        }
        else {
            chooseClassroom();
            getSummary(theClass);
        }
    }

    private void getSummary(Classroom classroom) {
        System.out.println("There are " + classroom.getNumberOfStudents() + " students in this class.");
        System.out.println();
        System.out.println("Your class is made up of:");
        double activistPercent = theClass.getProfile().percentActivistScore();
        double theoristPercent = theClass.getProfile().percentTheoristScore();
        double pragmatistPercent = theClass.getProfile().percentPragmatistScore();
        double reflectorPercent = theClass.getProfile().percentReflectorScore();
        System.out.println(activistPercent   + "% Activist Learners");
        System.out.println(theoristPercent   + "% Theorist Learners");
        System.out.println(pragmatistPercent + "% Pragmatist Learners");
        System.out.println(reflectorPercent  + "% Reflector Learners");
        System.out.println();
        System.out.println("We recommend doing the following things to your lesson plans to match the learning style of the classroom:");
        List<Recommendation> recommendations = Recommender.getInstance().recommend(activistPercent, theoristPercent,
                pragmatistPercent, reflectorPercent);
        for (Recommendation r : recommendations) {
            System.out.println(r.getRecommendation());
        }
        System.out.println();
        System.out.println("Thanks for using our program!");
        System.out.println("Have a great day!");
        System.exit(0);
    }

    private void createClassroom() {
        String name;
        String code;
        System.out.println("What is the name of this class?");
        name = input.nextLine();
        System.out.println("What is the course code of this class? This code must be unique from all other course codes.");
        code = input.nextLine();
        teacher.add(new Classroom(name, code));
        System.out.println("Great! I just added the Classroom to your profile.");
        System.out.println("Please ask your students to do the questionnaire for this class.");
        System.out.println();
    }


}
