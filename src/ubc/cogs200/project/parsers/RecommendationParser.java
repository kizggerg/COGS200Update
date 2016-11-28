package ubc.cogs200.project.parsers;

import ubc.cogs200.project.model.Recommendation;
import ubc.cogs200.project.model.Recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Used to update the internal state of the recommendations.
 */
public class RecommendationParser {
    File file;
    Scanner reader;

    public RecommendationParser(String url) throws FileNotFoundException {
        file = new File(url);
        reader = new Scanner(file);
    }

    public void parse() {
        String recommendation;
        String style;

        while (reader.hasNextLine()) {
            recommendation = reader.nextLine();
            style = reader.nextLine();
            Recommendation theRecommendation = new Recommendation(recommendation, style);
            Recommender.getInstance().addRecommendation(theRecommendation);
        }
    }

}
