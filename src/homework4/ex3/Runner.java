package homework4.ex3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Runner {
    @SuppressWarnings("checkstyle:SeparatorWrap")
    public static void main(String[] args) {
        //Задание №3 - Небоскребы, небоскребы, а я...
        //1. Создать Класс Небоскреб - имя небоскреба, его высота в метрах.
        //2. Необходимо создать небоскребы:
        //Всемирный торговый центр - 541м
        //Шанхайская башня - 632м
        //Бурдж-Халифа - 828м
        //Международный финансовый центр Пинань - 599м
        //Абрадж аль-Бейт - 601м
        //Всемирный центр Лотте - 555м

        //3. Занести небоскребы в List! Дважды положить бурдж халифа в лист.

        //4. С помощью стримов:
        //4.1 Убрать дубликаты и сохранить в новый лист (далее работаем с этим листом).
        //(РАЗНЫЕ СТРИМЫ!)
        //4.2. Вывести только первые три небоскреба.
        //4.3. Вывести самый высокий небоскреб.
        //4.4. Вывести те небоскребы, которые выше километра.
        //Если выше километра нет, то вывести на экран: небоскреба выше километра - нет.
        Skyscraper skyscraper1 = new Skyscraper("Всемирный торговый центр", 541);
        Skyscraper skyscraper2 = new Skyscraper("Шанхайская башня", 632);
        Skyscraper skyscraper3 = new Skyscraper("Бурдж-Халифа", 828);
        Skyscraper skyscraper4 = new Skyscraper("Международный финансовый центр Пинань", 599);
        Skyscraper skyscraper5 = new Skyscraper("Абрадж аль-Бейт", 601);
        Skyscraper skyscraper6 = new Skyscraper("Всемирный центр Лотте", 1555);

        // помещаем небоскребы в лист
        List<Skyscraper> listSkyscreaper = new ArrayList<>(
                List.of(skyscraper1, skyscraper2, skyscraper3, skyscraper4, skyscraper5, skyscraper6, skyscraper3));
        //убираем дубликаты
        List<Skyscraper> resultlist = listSkyscreaper.stream().distinct().toList();
        //вывод на печать 3 первых
        resultlist.stream().limit(3).forEach(e -> System.out.println(e));
        System.out.println("___________________________");

        // выбираем самый высокий
        Optional<Skyscraper> maxheigth = resultlist.stream().max(Comparator.comparingInt(Skyscraper::getHeigth));
        System.out.println("Самый высокий: " + (maxheigth.isEmpty() ? "небоскребов нет" : maxheigth.get()));
        System.out.println("___________________________");

        // выбираем выше километра с выводом string name
        Optional<String> upKilometr = resultlist.stream().
                filter(e -> e.getHeigth() > 1000).
                map(e -> e.getName()).
                reduce((a, b) -> "%s, %s".formatted(a, b));
        System.out.println("Небоскребы выше 1км: " + upKilometr.orElse("таких небоскребов нет"));

        // выбираем выше километра с выводом Skyscreaoer
        System.out.print("Небоскребы выше 1км: ");
        List<Skyscraper> upKilometr2 = resultlist.stream().filter(e -> e.getHeigth() > 1000).toList();
        if (upKilometr2.isEmpty()) {
            System.out.println("таких небоскребов нет");
        } else {
            upKilometr2.forEach(e -> System.out.println(e));
        }
    }
}
