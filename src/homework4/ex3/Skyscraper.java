package homework4.ex3;

/*
класс Небоскреб
 */
public class Skyscraper {
    private String name;
    private Integer heigth;

    public Skyscraper(String name, Integer heigth) {
        this.name = name;
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return name + ", высота=" + heigth;
    }

    public Integer getHeigth() {
        return heigth;
    }

    public String getName() {
        return name;
    }
}
