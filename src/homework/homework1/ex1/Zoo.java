package homework.homework1.ex1;

public class Zoo<T1, T2, T3 extends Animal> {
    private T1 animalFirst;
    private T2 animalSecond;
    private T3 animalThird;

    public Zoo(T1 animalFirst, T2 animalSecond, T3 animalThird) {
        this.animalFirst = animalFirst;
        this.animalSecond = animalSecond;
        this.animalThird = animalThird;
    }

    public T1 getAnimalFirst() {
        return animalFirst;
    }

    public T2 getAnimalSecond() {
        return animalSecond;
    }

    public T3 getAnimalThird() {
        return animalThird;
    }
}
