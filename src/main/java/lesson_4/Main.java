package lesson_4;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        Dog dogBobik = new Dog("Бобик");
        Cat catSharik = new Cat("Шарик");

        System.out.println("Тестирование собак:");
        dogBobik.run(150);
        dogBobik.run(600);
        dogBobik.swim(5);
        dogBobik.swim(15);

        System.out.println("Тестирование котов:");
        catSharik.run(150);
        catSharik.run(200);
        catSharik.run(201);
        catSharik.swim(1);
        catSharik.swim(10);

        System.out.println("Подсчет:");
        System.out.println("Всего создано животных: " + Animal.getAnimalCount());
        System.out.println("Всего создано собак: " + Dog.getDogCoin());
        System.out.println("Всего создано котов: " + Cat.getCatCoin());

        System.out.println("Сытость котов:");
        // создали миску с едой
        Bowl.setFood(30);
        System.out.println("В миске " + Bowl.getFood() + " еды.");

        // массив котов
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Васька"),
                new Cat("Рыжик"),
                new Cat("Снежок")
        };

        // аппетит котов
        int[] appetites = {15, 10, 20, 5, 10};

        // коты едят
        for (int i = 0; i < cats.length; i++) {
            cats[i].eatFromBowl(appetites[i]);
        }

        System.out.println("Информация о сытости:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " - " + (cat.isSatiety() ? "СЫТ" : "ГОЛОДЕН"));
        }

        System.out.println("Осталось еды в миске: " + Bowl.getFood());

        System.out.println("Добавляем еду:");
        Bowl.addFood(25);
        System.out.println("Теперь в миске: " + Bowl.getFood() + " еды");

        // Задание 2
        Circle circle = new Circle(5, "Желтый", "Черный");
        Rectangle rectangle = new Rectangle(4, 6, "Синий", "Красный");
        Triangle triangle = new Triangle(3, 4, 5, "Зеленый", "Оранжевый");

        System.out.println("Круг:");
        System.out.println(circle);

        System.out.println("Прямоугольник:");
        System.out.println(rectangle);

        System.out.println("Треугольник:");
        System.out.println(triangle);

    }
}
