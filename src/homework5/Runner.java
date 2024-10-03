package homework5;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        //Запрещено изменять модификаторы доступа!
        //Практически все будет через рефлексию
        //Создать банк с 1500 денег
        //Создать вора
        //Дописать метод stealMoney у вора так, чтобы он крал все деньги из банка себе
        //(увеличивал у себя деньги и обнулял деньги банка)
        //Вызвать здесь метод stealMoney
        //Распечатать вора и банк

        //Итог:
        //Вор - 1500 денег
        //Банк - 0 денег

        // создаем банк
        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> declaredConstructor = bankClass.getDeclaredConstructor(BigDecimal.class);
        declaredConstructor.setAccessible(true);
        Bank bank = declaredConstructor.newInstance(BigDecimal.valueOf(1500));

        //Создаем вора
        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> declaredConstructorThief = thiefClass.getDeclaredConstructor();
        declaredConstructorThief.setAccessible(true);
        Thief thief = declaredConstructorThief.newInstance();

        //вызываем метод воровства у вора, указываем банк
        Method methodStealmoney = thiefClass.getDeclaredMethod("stealMoney", Bank.class);
        methodStealmoney.setAccessible(true);
        methodStealmoney.invoke(thief, bank);

        System.out.println(bank);
        System.out.println(thief);
    }

}
