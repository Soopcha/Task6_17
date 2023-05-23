import java.util.*;

public class AbbreviationCounterSelf {
    public static MyMap<String, Integer> abbreviationsself(String[] words) {


        MyMap<String, Integer> abbreviations = new MyMap<>();
        for (String word : words) {
            if (word.length() <= 5 && word.equals(word.toUpperCase())) {
                if (abbreviations.containsKey(word)) {
                    abbreviations.put(word, abbreviations.get(word) + 1);
                } else {
                    abbreviations.put(word, 1);
                }
            }
        }

//        for (MyMap.Entry<String, Integer> entry : abbreviations.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }
        return abbreviations;
    }


}
