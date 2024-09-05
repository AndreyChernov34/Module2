package proekt.ex1.cars;

import proekt.ex1.cars.car_components.*;
import proekt.ex1.cars.abstract_cars.CargoVan;

import java.math.BigDecimal;

public class Dyna extends CargoVan {
    private static WheelDiskEnum DYNA_DISK_DEFAULT = WheelDiskEnum.R20;

    public Dyna(String color, Integer maxSpeed, KppTypeEnum kppTypeEnum, BigDecimal price, FuelTank fuelTank, Integer liftingCapacity) {
        super(color, maxSpeed, kppTypeEnum, DYNA_DISK_DEFAULT, price, fuelTank, liftingCapacity);
    }

    public void ChargePhone() {
        System.out.println("Телефон заряжается");
    }
}
