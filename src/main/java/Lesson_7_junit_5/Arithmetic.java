package Lesson_7_junit_5;

public class Arithmetic {
    // сложение
    public int add(int a, int b) {
        return a + b;
    }

    // вычитание
    public int subtract(int a, int b) {
        return a - b;
    }

    // умножение
    public int multiply(int a, int b) {
        return a * b;
    }

    // деление
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно!");
        }
        return (double) a / b;
    }
}