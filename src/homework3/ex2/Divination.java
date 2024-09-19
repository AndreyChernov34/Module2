package homework3.ex2;

/*
Класс гадание
 */


@FunctionalInterface
public interface Divination<Object> {
    // предсказание
    String prediction(Object object);

}
