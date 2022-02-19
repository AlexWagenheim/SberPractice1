package Task2;

public class Circle {
    private double radius;
    private String color;

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI*radius*radius;
    }

    public double perimeter() {
        return 2*Math.PI*radius;
    }

    public String toString() {
        return String.format("Радиус: %s \nЦвет: %s \nПлощвдь: %s \nПериметр: %S",
                radius, color, this.area(), this.perimeter());
    }
}
