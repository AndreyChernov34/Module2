package proekt.ex1.cars.abstract_cars;

import proekt.ex1.cars.car_components.*;

import java.math.BigDecimal;

public class CargoVan extends Car {
    protected Integer liftingCapacity;

    public CargoVan(String color, Integer maxSpeed, KppTypeEnum kppTypeEnum, WheelDiskEnum wheelDiskEnum, BigDecimal price, FuelTank fuelTank, Integer liftingCapacity) {
        super(color, maxSpeed, kppTypeEnum, wheelDiskEnum, price, fuelTank);
        this.liftingCapacity = liftingCapacity;
    }
}
