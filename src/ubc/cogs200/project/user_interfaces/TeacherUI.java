package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.Classroom;
import ubc.cogs200.project.model.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeacherUI {

    // List of Classrooms
    // Select classroom
    // Once Selected: Overview is Shown:
    //     - Number of Student
    //     - Stats of Classroom
    //     - Recommendations
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome! Enter your first and last name:");
        String input = in.nextLine();
        String name = input;
        System.out.println("Enter your ID number:");
        input = in.nextLine();
        String number = input;

        Teacher teacher = new Teacher(name, number);
        System.out.println("Retrieving Classrooms... Please Wait One Moment");

        for (Classroom classroom : teacher.getClassrooms()) {
            classroom.getProfile().getStats();
            classroom.getProfile().getRecommendations();
    }

    }

    private void updateModel() throws FileNotFoundException {
        File model = new File("./data/model.txt");
        Scanner data = new Scanner(model);
        String teacherData = data.nextLine();
    }

    private void parseTeacher(String data) {
        String accum;

        for (int i = 0; i < data.length(); i++) {



        }
    }
}
