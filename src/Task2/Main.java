package Task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;

public class Main {
    public static void main(String[] args) {

        String inputString = null;
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        while (isNullString(inputString)) {
            System.out.println("Введите текст проверки");
            input(inputString = scanner.next());
        }

    }

    public static boolean isNullString(String input) {
        return (input == null || input.isEmpty() || input.isBlank());
    }

    public static void input(String inputString) {
        Stream<String> wordCount = new ArrayList<>(List.of(inputString.split(" "))).stream();
        System.out.println("В тексте слов \n" + wordCount.count());
        System.out.println("ТОР 10 слов: ");
        Stream<String> inputStringStream = new ArrayList<>(List.of(inputString.split(" "))).stream();
        Map<String, Long> countWordMap = inputStringStream
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        countWordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(comparingByKey()))
                .limit(10)
                .forEach(System.out::println);

    }

}
