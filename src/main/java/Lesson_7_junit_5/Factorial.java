package Lesson_7_junit_5;

public class Factorial {
    public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен!");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
