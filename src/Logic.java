import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Найти в тексте все имена собственные (за таковые считать слова, которые начинаются с
большой буквы не в начале предложения) и посчитать, сколько каждое из них
встречается
 */
public class Logic {

    public static String withStundartRealis(String text) { //реализация со стандартно мапой

        Map<String, Integer> properNounsMap = new HashMap<>();
        Pattern pattern = Pattern.compile("(?<=^|[^А-Яа-я])([А-Я][а-я]+)(?=[^А-Яа-я]|$)"); //верно ли регулярное выражение?
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

    public static String withMyRealis(String text) { //реализация с моей мапой (собственной - соломенной )

        SimpleHashMap<String, Integer> properNounsMap = new SimpleHashMap<>(100);
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

