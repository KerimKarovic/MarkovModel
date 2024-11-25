import edu.duke.FileResource;

public class MarkovRunner {
    // Existing methods ...

    public void runMarkovWordOne() {
        FileResource fr = new FileResource("C:\\Users\\kerim\\Desktop\\data\\confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordOne markov = new MarkovWordOne();
        markov.setTraining(st);
        markov.setRandom(139);
        String text = markov.getRandomText(50); // Adjust the length as needed
        printOut(text);
    }

    public void runMarkovWordTwo() {
        FileResource fr = new FileResource("C:\\Users\\kerim\\Desktop\\data\\confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordTwo markov = new MarkovWordTwo();
        markov.setTraining(st);
        markov.setRandom(832);
        String text = markov.getRandomText(50); // Adjust the length as needed
        printOut(text);
    }
    
    // Existing methods ...
    
    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
}
