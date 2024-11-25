import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Generates random text using a Markov model with two-word keys.
 * 
 * @version 1.0
 */
public class MarkovWordTwo {
    private HashMap<String, ArrayList<String>> myMap;
    private String myText;
    private Random myRandom;

    public MarkovWordTwo() {
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
        for (int i = 0; i < words.length - 2; i++) {
            String key = words[i] + " " + words[i + 1];
            String nextWord = words[i + 2];
            if (!myMap.containsKey(key)) {
                myMap.put(key, new ArrayList<>());
            }
            myMap.get(key).add(nextWord);
        }
    }

    public String getRandomText(int numWords) {
        if (myText == null || myText.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] words = myText.split("\\s+");
        String key = words[myRandom.nextInt(words.length - 2)] + " " + words[myRandom.nextInt(words.length - 1) + 1];
        sb.append(key);

        for (int k = 2; k < numWords; k++) {
            ArrayList<String> follows = myMap.get(key);
            if (follows == null || follows.isEmpty()) {
                break;
            }
            String nextWord = follows.get(myRandom.nextInt(follows.size()));
            sb.append(" ").append(nextWord);
            key = key.substring(key.indexOf(' ') + 1) + " " + nextWord;
        }
        return sb.toString();
    }
}
