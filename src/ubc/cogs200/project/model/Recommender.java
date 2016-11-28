package ubc.cogs200.project.model;

import java.util.*;

/**
 * Used to store and retrieve recommendations.
 * Singleton Design Pattern Used.
 */
public class Recommender {
    private static Recommender instance;
    private Set<Recommendation> recommendations;

    private Recommender() {
        this.recommendations = new HashSet<>();
    }

    public static Recommender getInstance(){
        if (instance == null) {
            instance = new Recommender();
        }
        return instance;
    }

    public void addRecommendation(Recommendation r) {
        recommendations.add(r);
    }

    public void addAll(Collection<Recommendation> r) {
        recommendations.addAll(r);
    }

    public List<Recommendation> getAllRecommendations() {
        List<Recommendation> result = new ArrayList<>();
        result.addAll(recommendations);
        return result;
    }

    public List<Recommendation> getAllActivistRecommendations() {
        List<Recommendation> result = new ArrayList<>();
        for (Recommendation r : recommendations) {
            if (r.getStyle().equals("activist")) result.add(r);
        }
        return result;
    }
    public List<Recommendation> getAllTheoristRecommendations() {
        List<Recommendation> result = new ArrayList<>();
        for (Recommendation r : recommendations) {
            if (r.getStyle().equals("theorist")) result.add(r);
        }
        return result;
    }
    public List<Recommendation> getAllPragmatistRecommendations() {
        List<Recommendation> result = new ArrayList<>();
        for (Recommendation r : recommendations) {
            if (r.getStyle().equals("pragmatist")) result.add(r);
        }
        return result;
    }
    public List<Recommendation> getAllReflectorRecommendations() {
        List<Recommendation> result = new ArrayList<>();
        for (Recommendation r : recommendations) {
            if (r.getStyle().equals("reflector")) result.add(r);
        }
        return result;
    }

    private int activistRecommendationCount() {
        return getAllActivistRecommendations().size();
    }

    private int theoristRecommendationCount() {
        return getAllTheoristRecommendations().size();
    }

    private int pragmatistRecommendationCount() {
        return  getAllPragmatistRecommendations().size();
    }

    private int reflectorRecommendationCount() {
        return  getAllReflectorRecommendations().size();
    }

    private int totalRecommendationCount() {
        return activistRecommendationCount() + pragmatistRecommendationCount() + reflectorRecommendationCount() + theoristRecommendationCount();
    }

    private int percentCount(List<Recommendation> recommendations, String style) {
        int count = 0;

        if (recommendations == null || recommendations.size() == 0) return count;

        for (Recommendation recommendation : recommendations) {
            if (recommendation.getStyle().equals(style)) count++;
        }

        return count*100/recommendations.size();
    }

    public List<Recommendation> recommend(double activistPercent, double theoristPercent, double pragmatistPercent, double reflectorPercent) {
        List<Recommendation> result = new ArrayList<>();

        List<Recommendation> activistRecommendations = getAllActivistRecommendations();
        List<Recommendation> theoristRecommendations = getAllTheoristRecommendations();
        List<Recommendation> pragmatistRecommendations = getAllPragmatistRecommendations();
        List<Recommendation> reflectorRecommendations = getAllReflectorRecommendations();

        int idealActivistCount = roundToNearestTen(activistPercent) / 10;
        int idealTheoristCount = roundToNearestTen(theoristPercent) / 10;
        int idealPragmatistCount = roundToNearestTen(pragmatistPercent) / 10;
        int idealReflectorCount = roundToNearestTen(reflectorPercent) / 10;

        Random rand = new Random();
        int randIndex;

        for (int i = 0; (i < idealActivistCount && activistRecommendations.size() > 0); i++) {
            randIndex = rand.nextInt(100) % activistRecommendations.size();
            result.add(activistRecommendations.get(randIndex));
            activistRecommendations.remove(randIndex);
        }
        for (int i = 0; (i < idealTheoristCount && theoristRecommendations.size() > 0); i++) {
            randIndex = rand.nextInt(100) % theoristRecommendations.size();
            result.add(theoristRecommendations.get(randIndex));
            theoristRecommendations.remove(randIndex);
        }
        for (int i = 0; (i < idealPragmatistCount && pragmatistRecommendations.size() > 0); i++) {
            randIndex = rand.nextInt(100) % pragmatistRecommendations.size();
            result.add(pragmatistRecommendations.get(randIndex));
            pragmatistRecommendations.remove(randIndex);
        }
        for (int i = 0; (i < idealReflectorCount && reflectorRecommendations.size() > 0); i++) {
            randIndex = rand.nextInt(100) % reflectorRecommendations.size();
            result.add(reflectorRecommendations.get(randIndex));
            reflectorRecommendations.remove(randIndex);
        }

        return result;
    }

    private int roundToNearestTen(double value) {
        int result = (int) value;
        int temp = result % 10;

        if (temp == 0) return result;

        else if (temp < 5) {
            result -= temp;
        }
        else {
            result += (10 - temp);
        }

        return result;

    }
}
