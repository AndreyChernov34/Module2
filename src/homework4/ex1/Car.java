package homework4.ex1;

/*
Класс машина
 */
public class Car {
    private String number;

    public Car(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }
}
