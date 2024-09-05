package proekt.ex1.cars.abstract_cars;

import proekt.ex1.cars.car_components.*;

import java.math.BigDecimal;

public abstract class Car {
    protected String color;
    protected Integer maxSpeed;
    protected KppTypeEnum kppTypeEnum;
    protected boolean movement;
    protected static int COUNT_WHEELS = 4;
    protected Wheel[] wheels;
    protected BigDecimal price;
    protected FuelTank fuelTank;
    protected Engine engine;
    protected Electric electric;
    protected Headlight headlight;

    public Car(String color, Integer maxSpeed, KppTypeEnum kppTypeEnum, WheelDiskEnum wheelDiskEnum, BigDecimal price, FuelTank fuelTank) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.kppTypeEnum = kppTypeEnum;
        this.wheels = new Wheel[COUNT_WHEELS];
        this.price = price;
        this.fuelTank = fuelTank;
        this.engine = new Engine(true);
        this.electric = new Electric(true);
        this.headlight = new Headlight(true);
    }

    public void headlightOn() {
        if (this.headlight.functional) {
            System.out.println("Фары включены");
        } else {
            System.out.println("Фары неисправны");
        }
    }

    public void Start() throws StartCarException {
        for (Wheel wheel : wheels) {
            if (wheel.isPuncture()) {
                throw new StartCarException("В машине пробито колесо");
            }
            if (wheel == null) {
                throw new StartCarException("В машине нет колеса");
            }
        }

        if (!electric.functional) {
            throw new StartCarException("В машине не работает электрика");
        }

        if (!engine.functional) {
            throw new StartCarException("В машине не работает двигатель");
        }

        if (fuelTank.fuel < 0) {
            throw new StartCarException("В машине нет топлива");
        } else {
            movement = true;
            System.out.println("Машина поехала");
        }

    }

    @Override
    public String toString() {
        return String.format(String.format("Car{" +
                "color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", kppTypeEnum=" + kppTypeEnum +
                ", movement=" + movement +
                ", wheels=" + wheels +
                ", price=" + price +
                ", engine=" + engine +
                ", fuelTank=" + fuelTank +
                ", electric=" + electric +
                ", headlight=" + headlight +
                '}'));
    }

//    public void setWheels(Wheel[] wheels) {
//        this.wheels = wheels;
//    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setGasTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setElectric(Electric electric) {
        this.electric = electric;
    }

    public void setHeadlight(Headlight headlight) {
        this.headlight = headlight;
    }

    public Engine getEngine() {
        return engine;
    }

    public Electric getElectric() {
        return electric;
    }

    public Headlight getHeadlight() {
        return headlight;
    }
}

      