package lesson_4;

class Circle extends Figure implements Perimeter, Area {
    private double radius;
    private static final double PI = 3.141592653589793;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);  // ← добавить!
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;  // ← СВОЯ логика для круга
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Периметр: " + calculatePerimeter() + "\n" +
                "Площадь: " + calculateArea() + "\n" +
                "Цвет заливки: " + getFillColor() + "\n" +
                "Цвет границы: " + getBorderColor();
    }
}
