package ubc.cogs200.project.parsers;

import ubc.cogs200.project.model.Question;
import ubc.cogs200.project.model.Questionnaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by greggzik on 2016-11-27.
 */
public class QuestionsParser {
    File file;
    Scanner reader;

    public QuestionsParser(String url) throws FileNotFoundException{
        file = new File(url);
        reader = new Scanner(file);
    }

    public void parse() {
        String question;
        String style;

       while (reader.hasNextLine()) {
           question = reader.nextLine();
           style = reader.nextLine();
           Question theQuestion = new Question(question, style);
           Questionnaire.getInstance().addQuestion(theQuestion);
       }
    }

}
