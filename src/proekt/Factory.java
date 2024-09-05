package proekt;

import proekt.ex1.cars.car_components.*;

public class Factory {
    public Country country;

    public Factory(Country country) {
        this.country = country;
    }

    public Engine createEngine() {
        return new Engine(true);
    }

    public FuelTank createFueltank() {
        return new FuelTank(0);
    }

    public Electric createElectric() {
        return new Electric(true);
    }

    public Headlight createHeadlight() {
        return new Headlight(true);
    }

    public Wheel[] createWeels(WheelDiskEnum wheelDiskEnum, int counter) {
        Wheel wheels[] = new Wheel[counter];
        for (int i = 0; i < counter; i++) {
            wheels[i] = new Wheel(wheelDiskEnum);
        }
        return wheels;
    }

}
