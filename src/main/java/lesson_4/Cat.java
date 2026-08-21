package lesson_4;

public class Cat extends Animal {
    static int catCoin = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        catCoin++;
        this.satiety = false;
    }

    public static int getCatCoin() {
        return catCoin;
    }

    public boolean isSatiety() {
        return satiety;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public void eatFromBowl(int amount) {
        // Пытаемся взять еду из миски
        if (Bowl.takeFood(amount)) {
            // Еды хватило - кот сыт
            satiety = true;
            System.out.println(name + " поел! Теперь он сыт.");
        } else {
            // Еды не хватило - кот голоден
            System.out.println(name + " не поел (в миске мало еды). Он остался голодным.");
        }
    }
}
