import edu.duke.FileResource;

public class MarkovTester {
    
    public static void main(String[] args) {
        MarkovRunner runner = new MarkovRunner();
        
        // Run the MarkovWordOne test
        System.out.println("Running MarkovWordOne Test...");
        runner.runMarkovWordOne();
        
        // Run the MarkovWordTwo test
        System.out.println("Running MarkovWordTwo Test...");
        runner.runMarkovWordTwo();
    }
}
