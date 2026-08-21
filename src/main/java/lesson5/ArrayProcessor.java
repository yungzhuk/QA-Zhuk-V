package lesson5;

public class ArrayProcessor {
    public static int sumArray(String[][] array)
        throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Не 4 строки: " + array.length);
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " не 4 элемента");
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Ошибка в [" + i + "][" + j + "]: " + array[i][j]
                    );
                }
            }
        }
        return sum;
    }

    static void testSum(String name, String[][] array) {
        System.out.print(name + ": ");
        try {
            int result = sumArray(array);
            System.out.println("Сумма = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ArrayIndexOutOfBoundsException ===");

        try {
            String[][] array = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };

            System.out.println(array[4][0]);  // Генерируем исключение

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Попытка доступа к несуществующему индексу массива");
            e.printStackTrace();
        }

        try {
            String[][] array = new String[4][4];
            System.out.println(array[5].length);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nВторое исключение: " + e);
        }
    }

    public static void main(String[] args) {
        // Тест 1. Корректный массив
        testSum("Корректный", new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        });

        // Тест 2. Неверный размер (3 строки)
        testSum("Неверный размер", new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        });

        // Тест 3. Нечисловые данные
        testSum("Нечисловые данные", new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "text", "8"},  // ← здесь ошибка
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        });

        demonstrateArrayIndexOutOfBounds();

    }

}
