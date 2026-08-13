package lesson_4;

public class Triangle extends Figure implements Perimeter, Area {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        super(fillColor, borderColor);  // ← добавить!
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double calculatePerimeter() {
        return calculateTrianglePerimeter(side1, side2, side3);
    }

    @Override
    public double calculateArea() {
        double p = (side1 + side2 + side3) / 2;  // полупериметр
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Периметр: " + calculatePerimeter() + "\n" +
                "Площадь: " + calculateArea() + "\n" +
                "Цвет заливки: " + getFillColor() + "\n" +
                "Цвет границы: " + getBorderColor();
    }
}
