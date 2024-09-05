package proekt.ex1.cars;

import proekt.ex1.cars.car_components.*;
import proekt.ex1.cars.abstract_cars.Cabriolet;

import java.math.BigDecimal;

public class Solara extends Cabriolet {
    private static WheelDiskEnum SOLARA_DISK_DEFAULT = WheelDiskEnum.R16;

    public Solara(String color, Integer maxSpeed, KppTypeEnum kppTypeEnum, BigDecimal price, FuelTank fuelTank) {
        super(color, maxSpeed, kppTypeEnum, SOLARA_DISK_DEFAULT, price, fuelTank);
    }

    public void freeze() {
        System.out.println("Холодильник охдаждает");
    }
}

