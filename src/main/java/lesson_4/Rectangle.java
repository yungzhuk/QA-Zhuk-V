package lesson_4;

public class Rectangle extends Figure implements Perimeter, Area {
    private double length;
    private double width;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        super(fillColor, borderColor);  // ← добавить!
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return (length + width) * 2;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Периметр: " + calculatePerimeter() + "\n" +
                "Площадь: " + calculateArea() + "\n" +
                "Цвет заливки: " + getFillColor() + "\n" +
                "Цвет границы: " + getBorderColor();
    }

}
