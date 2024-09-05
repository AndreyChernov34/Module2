package proekt;

import proekt.ex1.cars.Camry;
import proekt.ex1.cars.car_components.KppTypeEnum;

import java.math.BigDecimal;

public class AssemblyLine {
    public Country country;
    private KppTypeEnum CAMRY_KPP = KppTypeEnum.AUTOMAT;
    private Factory factory;

    public AssemblyLine(Country country, Factory factory) throws CountryFactoryNotEqualException {
        if (factory.country != country) {
            throw new CountryFactoryNotEqualException("Страна фабрики компонент " + factory.country +
                    " не совпадает со станой сборочного конвейера " + country);
        }
        this.country = country;
        this.factory = factory;
    }

    public void createCamry(String color, BigDecimal price) {

        // Camry camry = new Camry(color,CAMRY_KPP, price);
        //return camry;
    }
}
