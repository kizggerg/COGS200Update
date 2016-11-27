package ubc.cogs200.project.parsers;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import ubc.cogs200.project.model.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Parses all of the data in the JSON file for internal storage.
 */
public class DataParser {
    InputStream stream;
    String data;

    public DataParser(String url) throws FileNotFoundException{
        try {
            stream = new FileInputStream(url);
            data =  readSource(stream);

        } catch (IOException e) {
            throw new FileNotFoundException("Error Reading File");
        }
    }

    public void parse() throws JSONException{
        JSONArray toAdd = new JSONArray(data);

        for (int index = 0; index < toAdd.length(); index++) {
            JSONObject teacher = toAdd.getJSONObject(index);
            parseTeacher(teacher);
        }
    }

    private void parseTeacher(JSONObject teacher) throws JSONException {
        String name = teacher.getString("name");
        String id   = teacher.getString("ID");
        Teacher t = new Teacher(name, id);
        JSONArray classes = teacher.getJSONArray("classes");
        Set<Classroom> classrooms = parseClasses(classes);
        t.addAll(classrooms);
        Staff.getInstance().addTeacher(t);
    }

    private Set<Classroom> parseClasses(JSONArray classes) throws JSONException {
        Set<Classroom> result = new HashSet<>();

        for (int index = 0; index < classes.length(); index++) {
            JSONObject classroom = classes.getJSONObject(index);
            Classroom c = parseClassroom(classroom);
            result.add(c);
        }

        return result;
    }

    private Classroom parseClassroom(JSONObject classroom) throws JSONException {
        Classroom result;
        String name = classroom.getString("name");
        String code = classroom.getString("code");
        JSONArray students = classroom.getJSONArray("students");
        result = new Classroom(name, code);
        Set<Student> s = parseStudents(students);
        result.addAllStudent(s);
        result.updateClassroom();
        return result;
    }

    private Set<Student> parseStudents(JSONArray students) throws JSONException{
        Set<Student> result = new HashSet<>();

        for (int index = 0; index < students.length(); index++) {
            JSONObject student = students.getJSONObject(index);
            Student s = parseStudent(student);
            result.add(s);
        }

        return result;
    }

    private Student parseStudent(JSONObject student) throws JSONException {
        Student result;
        String name = student.getString("name");
        String number = student.getString("number");
        result = new Student(name, number);
        JSONObject profile = student.getJSONObject("profile");
        StudentProfile p = parseProfile(profile);
        result.setProfile(p);
        return result;
    }

    private StudentProfile parseProfile(JSONObject profile) throws JSONException {
        StudentProfile result = new StudentProfile();
        int activist = profile.getInt("activist");
        int theorist = profile.getInt("theorist");
        int pragmatist = profile.getInt("pragmatist");
        int reflector = profile.getInt("reflector");
        result.setAll(activist, theorist, pragmatist, reflector);
        return result;
    }




    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

}
