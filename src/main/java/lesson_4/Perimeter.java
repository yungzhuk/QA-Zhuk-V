package lesson_4;

public interface Perimeter {
    double calculatePerimeter();

    // метод для треугольника
    default double calculateTrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
}
