import java.awt.*;

import javax.swing.*;

public class Circle extends Figure{
    private double r;

    Circle(Point point, double r) {
        super(new Point[]{point});
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI*r*r;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public void draw() {
        System.out.println("Draw circle");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Draw circle in" + color);
    }
}
