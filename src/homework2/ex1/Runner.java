package homework2.ex1;

import java.io.FileNotFoundException;
import java.util.*;

public class Runner {
    private static final String DELIMITER = ";";
    private static final int MINIMUM_FIELDS_COUNT = 2;
    private static final int BAGGAGE_INDEX = 0;
    private static final int MAXIMUM_TAPE_LENGTH = 10;


    public static void main(String[] args) throws FileNotFoundException {
        //1. Задание: Грузчики в Болгарии
        //В аэропорт Болгарии прилетает самолет. В самолете багаж.
        //На выгрузной ленте может находиться не больше 10 чемоданов.
        //Задача: разгрузить багажное отделение самолета, загружая на ленту не более 10 чемоданов.
        //Примечание: багаж должен отдаваться в том же порядке, в котором попадал на ленту.

        //Т.е нужно создать функцию, в которую приходит имя файла(это прибывший багаж).
        //От туда будет считываться порциями по 10 штук багаж. Этот багаж перемещается на ленту.
        //Печатается: Начинается загрузка на ленту
        //После того как лента заполнена или больше нет чемоданов:
        //Печатается: Лента загружена, начинается выдача багажа.
        //Лента включается и с нее пропадают чемоданы.
        //Печатается на экран: {Номер багажа} - выдан
        //После окончания выдачи печатается: Лента пустая, закончена выдача багажа

        //Т.е. прибыл багаж (файл luggage.csv).
        //Там находится 20 чемоданов(номера от 1 до 20) . На экране будет выведено:
        //Начинается загрузка на ленту
        //Лента загружена, начинается выдача багажа
        //1 - выдан
        //2 - выдан
        //....
        //10 - выдан
        //Лента пустая, закончена выдача багажа
        //Начинается загрузка на ленту
        //Лента загружена, начинается выдача багажа
        //11 - выдан
        //12 - выдан
        //....
        //20 - выдан
        //Лента пустая, закончена выдача багажа

        //Протестировать функцию на файле luggage.csv.


        //Протестировать функцию на файле luggage.csv.
        //
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream("luggage.csv"))) {
            readFile(scanner);
        }
    }

    /*
    Считываем багаж из входящего файла
    */
    private static void readFile(Scanner scanner) {
        scanner.nextLine();
        //счетчик багажа
        int counter = 0;
        //Багажная лента
        Queue<String> tape = new LinkedList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] fields = line.split(DELIMITER);

            if (counter == 0) {
                System.out.println("Начинается загрузка ленты");
            }

            if (fields.length == MINIMUM_FIELDS_COUNT) {
                tape.add(fields[BAGGAGE_INDEX]);
                counter += 1;
            }
            // Если лента полна вызываем метод выдачи
            if (counter == MAXIMUM_TAPE_LENGTH) {
                baggageClaim(tape);
                counter = 0;
            }
        }
        // если количество багажа не кратно размеру ленты, то последние багажи останутся на ленте
        // и ее надо отправить на выгрузку
        if (!tape.isEmpty()) {
            baggageClaim(tape);
        }
        scanner.close();
    }

    /*
    Метод выдачи багажа с ленты
    */
    private static void baggageClaim(Queue<String> tapelist) {
        System.out.println("Лента загружена, начинается выдача.");
        while (!tapelist.isEmpty()) {
            System.out.println(String.format("багаж № %s выдан", tapelist.poll()));
        }
        System.out.println("Лента пустая, выдача закончена");
    }
}
