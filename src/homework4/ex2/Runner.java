package homework4.ex2;

import java.util.*;

public class Runner {
    private static final Character CHARACTER = 'о';

    public static void main(String[] args) {
        //Задание №2 - Сколько здесь "о" ?
        //1. Создать набор уникальных слов: "тон", "тополь", "боль", "рой", "стройка"
        //2. Создать стрим у набора
        //2.1 Посчитать количество букв "о" в одном слове
        //2.2 Посчитать сумму количества букв "о" во всех словах из набора
        //2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
        //
        //ожидаемый результат:
        //6

        HashSet<String> words = new HashSet<>(List.of("тон", "тополь", "боль", "рой", "стройка"));

        Optional<Integer> result = words.stream().map(e -> countchar(e)).reduce((a, b) -> a + b);
        System.out.println(result.orElse(0));
    }

    //функция подсчета вхождения символа в строку
    public static Integer countchar(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == CHARACTER) {
                count = count + 1;
            }
        }
        return count;
    }


}
