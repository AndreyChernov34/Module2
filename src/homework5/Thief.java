package homework5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Вор
 */
public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Class<Bank> bankClass = Bank.class;
        Field moneyBank = bankClass.getDeclaredField("money");
        moneyBank.setAccessible(true);
        Method setMoney = bankClass.getDeclaredMethod("setMoney", BigDecimal.class);
        setMoney.setAccessible(true);

        money = money.add((BigDecimal) moneyBank.get(bank));
        setMoney.invoke(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }
}
