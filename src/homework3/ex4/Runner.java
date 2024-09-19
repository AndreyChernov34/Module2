package homework3.ex4;

public class Runner {
    public static void main(String[] args) {
        //Задание №4: универсальная линейка
        //Создать функциональный интерфейс линейка: принимает в себя любой тип, возвращает Integer
        //Создать класс животное (длина тела, длина хвоста)
        //Создать класс лодка(длина)
        //Создать с помощью лямбд выражений:
        //Измеритель лодок: на вход лодка, возвращает длину лодки
        //Измеритель животных: на вход животное, возвращает сумму длин тела и хвоста

        Straightedge<Boat> boatMeter = (boat) -> boat.lenght;
        Straightedge<Animal> animalMeter = (animal) -> animal.bodyLength + animal.tailLength;
        //проверка
        System.out.println(boatMeter.dimension(new Boat(5005)));
        System.out.println(animalMeter.dimension(new Animal(1500, 500)));


    }
}
