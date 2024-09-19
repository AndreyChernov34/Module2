package homework.homework1;

import homework.homework1.ex1.Bird;
import homework.homework1.ex1.Dog;
import homework.homework1.ex1.Tiger;
import homework.homework1.ex1.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //Задание №1 Зоопарк
        //1. Создать три вида животных: Тигр - умеет рычать, Собака - умеет лаять, Птица - умеет летать.
        //Общий родитель - животное (никаких атрибутов и методов в нем нет).
        //2. Создать зоопарк, который может хранить в себе 3 животных любого типа.
        //Т.е. могут быть следующие зоопарки:
        // Зоопарк в котором Тигр, Тигр, Птица
        // Зоопарк в котором Собака, Собака, Собака
        // Зоопарк в котором Птица, Птица, Тигр.
        //3. Сделать геттеры на всех животных.
        //Сделать так, чтобы при получении животного, мы могли воспользоваться специфичным для него действием.
        //Т.е. создали зоопарк Тигр, Собака, Птица (положили в этот зоопарк животных  при создании).
        //Получили первое животное (тигра) - вызвали у него рык
        //Получили второе животное (собака) - вызвали у него лай
        //Получили первое животное (птица) - вызвали у него полет
        //Запрещено пользоваться instanceOf.

        Zoo<Tiger, Dog, Bird> zoo = new Zoo<>(new Tiger(), new Dog(), new Bird());

        Tiger tiger = zoo.getAnimalFirst();
        tiger.growl();
        Dog dog = zoo.getAnimalSecond();
        dog.bark();
        Bird bird = zoo.getAnimalThird();
        bird.fly();


        //Задание №2 Гидрометцентр
        //Создать две структуры данных, в которых будет статистика по дням (среднесуточная температура воздуха)
        //Январь: 0,-1,-1,-2,-5,-6,-7,-8,-9,-10,-5,-5,-2,-7,-3,-1,-8,-9,-8,-8,-18,-20,-23,-24,-25,-9,-8,-7,-6,-5,-1
        //Февраль: -8,-10,-12,-13,-15,-16,-12,-7,-8,-10,-10,-9,-8,-8,-8,-9,-10,-9,-5,-6,-8,-7,-8,-9,-6,-5,-3,-1
        //Объединить данные за январь и февраль, посчитать среднесуточную температуру воздуха за 2 месяца.
        //Запрещено использовать массивы.
        List<Integer> january = new ArrayList<>(List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10,
                -5, -5, -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1));
        List<Integer> february = new ArrayList<>(List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8, -10,
                -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1));

        List<Integer> sumDays = new ArrayList<>(january);
        sumDays.addAll(february);
        int sumTemperature = 0;
        for (int temperature : sumDays) {
            sumTemperature += temperature;
        }

        System.out.println("Среднесуточная температура = " + (sumTemperature / sumDays.size()));

        //Задание №3 Ресторанный гуру
        //Николай Петрович ходит по ресторанам. За 5 дней он был во множестве ресторанов.
        //Он обратился к вам, чтобы узнать в каком ресторане(ах) он был каждый день
        // (т.е. найти ресторан(ы) в которых он был и в понедельник, и во вторник, и в среду и тд).
        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1",
                "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        //Объединим дни в одну коллекцию ArrayList
        ArrayList<ArrayList<String>> alldays = new ArrayList<>(List.of(monday, tuesday, wednesday, thursday, friday));

        ArrayList<String> result = new ArrayList<>(alldays.get(0));

        for (ArrayList<String> day : alldays.subList(1, alldays.size())) {
            result.retainAll(day);
        }
        System.out.println("За пять дней каждый день посещалось: " + result);

    }
}
