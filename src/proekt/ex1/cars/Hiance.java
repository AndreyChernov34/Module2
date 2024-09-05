package proekt.ex1.cars;

import proekt.ex1.cars.car_components.*;
import proekt.ex1.cars.abstract_cars.CargoVan;

import java.math.BigDecimal;

public class Hiance extends CargoVan {
    private static WheelDiskEnum HIANCE_DISK_DEFAULT = WheelDiskEnum.R17;
    private Wheel spareWheel;

    public Hiance(String color, Integer maxSpeed, KppTypeEnum kppTypeEnum, BigDecimal price, FuelTank fuelTank,
                  Integer liftingCapacity) {
        super(color, maxSpeed, kppTypeEnum, HIANCE_DISK_DEFAULT, price, fuelTank, liftingCapacity);
        this.spareWheel = new Wheel(HIANCE_DISK_DEFAULT);
    }
}
