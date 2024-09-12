package homework2.ex2;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
//2. Задание: Таможня в Болгарии
//Таможня собирает статистику о весе ввезенных чемоданов.
//Есть 3 категории чемоданов: легкий (до 5 кг), средний (от 5 кг до 10кг), тяжелый (от 10 кг)
//Необходимо создать функцию, которая:
//считывает файл с багажом, суммирует вес по каждой категории и возвращает сгруппированные данные
//т.е функция должна вернуть данные (не распечатать), в которых будет инфо:
//категория чемодана - сумма всех чемоданов этой категории

//Пример возврата:
//легкий - 205
//средний - 513
//тяжелый - 1200

public class Runner {
    private static final String DELIMITER = ";";
    private static final String LIGHT_BAGGAGECATEGORY = "легкие";
    private static final String AVERAGE_BAGGAGECATEGORY = "средние";
    private static final String HEAVY_BAGGAGECATEGORY = "тяжелые";
    private static final int LIGHT_BAGGAGELIMIT = 5;
    private static final int AVERAGE_BAGGAGEWEITH = 10;
    private static final int MINIMUM_FIELDS_COUNT = 2;
    private static final int WEITH_INDEX = 1;

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "luggage.csv";
        try (Scanner scanner = new Scanner(homework2.ex1.Runner.class.getClassLoader().getResourceAsStream(filename))) {
            // получаем результат HashMap
            HashMap<String, Integer> resultBagagge = readFile(scanner);
            // необязательно, но выводим на печать
            System.out.println(resultBagagge);
        }

    }

    private static HashMap<String, Integer> readFile(Scanner scanner) {
        scanner.nextLine();
        HashMap<String, Integer> allweith = new HashMap();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] fields = line.split(DELIMITER);
            if (fields.length == MINIMUM_FIELDS_COUNT) {
                if (Integer.valueOf(fields[WEITH_INDEX]) >= AVERAGE_BAGGAGEWEITH) {
                    allweith.put(HEAVY_BAGGAGECATEGORY, allweith.getOrDefault(HEAVY_BAGGAGECATEGORY, 0)
                            + Integer.valueOf(fields[WEITH_INDEX]));
                } else if (Integer.valueOf(fields[WEITH_INDEX]) >= LIGHT_BAGGAGELIMIT) {
                    allweith.put(AVERAGE_BAGGAGECATEGORY, allweith.getOrDefault(AVERAGE_BAGGAGECATEGORY, 0)
                            + Integer.valueOf(fields[WEITH_INDEX]));
                } else {
                    allweith.put(LIGHT_BAGGAGECATEGORY, allweith.getOrDefault(LIGHT_BAGGAGECATEGORY, 0)
                            + Integer.valueOf(fields[WEITH_INDEX]));
                }
            }
        }
        scanner.close();
        return allweith;
    }
}


