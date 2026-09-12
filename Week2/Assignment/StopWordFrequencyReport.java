import java.util.*;

public class StopWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // Store word and frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            // Check if word is a stop word
            for (String stop : stopWords) {

                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count word
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            }
            else {
                frequency.put(word, 1);
            }
        }

        // Convert map into list
        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}