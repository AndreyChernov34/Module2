package homework3.ex2;

public class Runner {
    public static void main(String[] args) {
        //Задание №2: Поиск пары с помощью гадания
        //Создать функциональный интерфейс гадание, который на вход принимает аргумент любого типа,
        //на выход возвращает да/нет.
        //Создать с помощью лямбд выражений:
        //ромашку: принимает имя, возвращает да если в имени четное кол-во букв, нет если нечетное
        //бабку гадалку: принимает Человека(возраст, рост),
        //возвращает да - если (возраст + рост) больше 210, нет - если меньше или равно

        //гадание на ромашке по имени
        Divination<String> chamomile = (name) -> {
            if (name.toString().length() % 2 == 0) {
                return "Да";
            } else {
                return "Нет";
            }
        };
        //гадание бабкой по человеку
        Divination<Human> grandmaFortuneTeller = (human) -> {
            if (human.age + human.heith > 210) {
                return "Да";
            } else {
                return "Нет";
            }
        };
        // Проверка
        System.out.println(chamomile.prediction("Андрей"));
        System.out.println(grandmaFortuneTeller.prediction(new Human(23, 180)));

    }
}
