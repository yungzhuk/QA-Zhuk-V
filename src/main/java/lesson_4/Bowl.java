package lesson_4;

public class Bowl {
    private static int foodAmount = 0;

    // метод для добавления еды
    public static void addFood(int amount) {
        if(amount > 0){
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        } else {
            System.out.println("Ошибка: нельзя добавить " + amount + " еды (количество должно быть положительным)");
        }
    }

    // Метод для взятия еды из миски
    public static boolean takeFood(int amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: нельзя взять " + amount + " еды (количество должно быть положительным)");
            return false;
        }

        if (amount <= foodAmount) {
            // Еды достаточно - берем
            foodAmount -= amount;
            return true;
        } else {
            // Еды недостаточно - не берем
            System.out.println("В миске только " + foodAmount + " еды, а запрошено " + amount);
            return false;
        }
    }

    // метод для получения количества еды
    public static int getFood() {
        return foodAmount;
    }

    // метод для установки начального количества еды
    public static void setFood(int amount) {
        if (amount >= 0) {
            foodAmount = amount;
            System.out.println("В миске установлено " + foodAmount + " еды.");
        } else {
            System.out.println("Ошибка: нельзя установить отрицательное количество еды!");
        }
    }
}
