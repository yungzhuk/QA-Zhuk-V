package lesson_4;

public class Animal {
    protected String name;
    protected int maxRunLength;
    protected int maxSwimLength;
    static int animalCount = 0;

    public Animal(String name, int maxRunLength, int maxSwimLength) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance){
        if (distance <= maxRunLength) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance){
        if (distance <= maxSwimLength) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }
}
