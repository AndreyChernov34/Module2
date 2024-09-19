package homework3.ex1;

public class Runner {
    public static void main(String[] args) {
        //Задание №1: Сад
        //Создать два класса, которые являются фруктами (намек на еще один класс): яблоко, абрикос.
        //(Без полей и методов).
        //Создать функциональный интерфейс сад, который умеет выращивать ФРУКТ и всех наследников фрукта.
        //Метод ничего не принимает.
        //Создать с помощью лямбд выражений 2 фермы: яблочная, абрикосовая.
        //Яблочная ферма должна отдавать яблоко(не фрукт!), абрикосовая - абрикос(не фрукт!).
        Garden appleFarm = () -> new Apple();
        Garden apricotFarm = () -> new Apricot();
        Fruits apple = appleFarm.grow();
        Fruits apricot = apricotFarm.grow();
        // Проверка
        System.out.println("Выращены " + apple + " и " + apricot);


    }

}
