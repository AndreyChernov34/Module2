package proekt.ex1.cars.abstract_cars;

import proekt.ex1.cars.car_components.*;

import java.math.BigDecimal;

public abstract class Cabriolet extends Car {
    boolean roofClose;

    public Cabriolet(String color, Integer maxSpeed, KppTypeEnum kppTypeEnum, WheelDiskEnum wheelDiskEnum,
                     BigDecimal price, FuelTank fuelTank) {
        super(color, maxSpeed, kppTypeEnum, wheelDiskEnum, price, fuelTank);
        this.roofClose = true; //по умолчанию крыша закрыта (поднята)
    }

    protected void roofChange() {
        roofClose = !roofClose;
        System.out.println("Крыша " + (roofClose ? "поднята" : "открыта"));
    }
}
