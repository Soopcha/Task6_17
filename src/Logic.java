import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {

    public static String withStundartRealis(String text) {

        Map<String, Integer> properNounsMap = new HashMap<>();
        Pattern pattern = Pattern.compile("(?<=^|\\s)([А-Я][а-я]+)(?=$|\\s)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String properNoun = matcher.group(1);
            if (properNounsMap.containsKey(properNoun)) {
                properNounsMap.put(properNoun, properNounsMap.get(properNoun) + 1);
            } else {
                properNounsMap.put(properNoun, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : properNounsMap.entrySet()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return result.toString();
    }

    /*public static void main(String[] args) {
        System.out.println(withStundartRealis("Вася Пупкин, Иван Иванов, Петр Петров и Сергей Сидоров пошли гулять в парк. \" +\n" +
                "                \"Вася купил мороженое, а Сергей купил попкорн. \" +\n" +
                "                \"Иван рассказывал смешную историю про своего кота, а Петр слушал с интересом.\";"));

    }
     */
}

