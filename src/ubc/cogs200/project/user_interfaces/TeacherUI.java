package ubc.cogs200.project.user_interfaces;

import ubc.cogs200.project.model.Classroom;
import ubc.cogs200.project.model.Teacher;

public class TeacherUI {

    private static Teacher teacher = new Teacher("Joe", "999");

    public static void main(String[] args) {
        for (Classroom classroom : teacher.getClassrooms()) {
            classroom.getProfile().getStats();
            classroom.getProfile().getRecommendations();
    }



    }
}
