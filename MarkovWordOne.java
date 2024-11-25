import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Generates random text using a Markov model with one-word keys.
 * 
 * @version 1.0
 */
public class MarkovWordOne {
    private HashMap<String, ArrayList<String>> myMap;
    private String myText;
    private Random myRandom;

    public MarkovWordOne() {
        myRandom = new Random();
        myMap = new HashMap<>();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
    }

    private void buildMap() {
        myMap.clear();
        String[] words = myText.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String nextWord = words[i + 1];
            if (!myMap.containsKey(word)) {
                myMap.put(word, new ArrayList<>());
            }
            myMap.get(word).add(nextWord);
        }
    }

    public String getRandomText(int numWords) {
        if (myText == null || myText.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] words = myText.split("\\s+");
        String currentWord = words[myRandom.nextInt(words.length)];
        sb.append(currentWord);

        for (int k = 1; k < numWords; k++) {
            ArrayList<String> follows = myMap.get(currentWord);
            if (follows == null || follows.isEmpty()) {
                break;
            }
            currentWord = follows.get(myRandom.nextInt(follows.size()));
            sb.append(" ").append(currentWord);
        }
        return sb.toString();
    }
}
