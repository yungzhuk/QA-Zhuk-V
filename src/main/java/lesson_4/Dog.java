package lesson_4;

public class Dog extends Animal {
    static int dogCoin = 0;

    public static int getDogCoin() {
        return dogCoin;
    }

    public Dog(String name) {
        super(name, 500, 10); // Собака может пробежать 500 м, проплыть 10 м
        dogCoin++;
    }
}
