import java.util.*;

public class AbbreviationCounter {
    public static Map<String, Integer> abbreviations(String[] words) {
       // String text = "NASA is a US agency responsible for science and technology related to air and space. In the late 1950s, NASA was founded in response to the Soviet Union's launch of the first artificial satellite.";

        Map<String, Integer> abbreviations = new HashMap<>();

     //   String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() <= 5 && word.equals(word.toUpperCase())) {
                if (abbreviations.containsKey(word)) {
                    abbreviations.put(word, abbreviations.get(word) + 1);
                } else {
                    abbreviations.put(word, 1);
                }
            }
        }
        return abbreviations;
//        System.out.println(abbreviations.keySet());
//        System.out.println(abbreviations.entrySet());
//        System.out.println(abbreviations);
//
//        for (Map.Entry<String, Integer> entry : abbreviations.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }
    }
}

