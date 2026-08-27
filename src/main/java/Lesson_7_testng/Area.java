package Lesson_7_testng;

public class Area {
    public double calculate(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Числа должны быть положительные");
        }
        return 0.5 * base * height;
    }
}
