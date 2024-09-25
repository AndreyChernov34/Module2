package homework4.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        //ИСПОЛЬЗОВАНИЕ FOR, WHILE ЗАПРЕЩЕНО В ЭТОЙ ДЗ! Только СТРИМЫ.

        //Задание №1 - Список спец номеров
        //Нам необходимо распечатать список номеров, которые принадлежат чиновникам
        //1. Создать класс машина. У машины есть номер.
        //2. Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
        //3. Создать 50 машин с номерами к0[01-50]се178 (где [01-50] - это все значения от 01 до 50)
        //4. Объединить машины в единый стрим
        //5. Оставить в объединенном стриме машины с номерами 04[0-9] - это номера, выдаваемые чиновникам
        //6. Получить из оставшихся машин номера.
        //7. Распечатать номера.
        //ожидаемый результат:
        // a040ан799
        // a041ан799
        // ...
        // k048се178
        // k049се178
        //формируем два списка исходных номеров
        List<Car> listNumbers1 = new ArrayList<>();
        List<Car> listNumbers2 = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            listNumbers1.add(new Car("a" + String.format("%03d", i) + "ан799"));
            listNumbers2.add(new Car("к" + String.format("%03d", i) + "се178"));
        }
        //объединяем стримы и записываем в общий лист
        List<Car> allcars = Stream.of(listNumbers1, listNumbers2).flatMap(e -> e.stream()).toList();

        // фильтруем по номеру, получаем номера и выводим на печать
        allcars.stream()
                .filter(e -> e.getNumber().substring(1, 3).equals("04"))
                .map(e -> e.getNumber())
                .forEach(e -> System.out.println(e));
    }
}
