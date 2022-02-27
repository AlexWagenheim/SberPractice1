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
        draw(Color.BLACK);
    }

    private String getColor(Color color) {
        if (color.equals(Color.RED)) {
            return "красный";
        } else if (color.equals(Color.GREEN)) {
            return "зелёный";
        } else if (color.equals(Color.BLUE)) {
            return "синий";
        } else if (color.equals(Color.WHITE)) {
            return "белый";
        } else {
            return "чёрный";
        }
    }

    @Override
    public void draw(Color color) {
        Point[] points = getPoints();
        System.out.printf("Нарисован %s круг с центром в точке O%s, радиуса %s \n", getColor(color), points[0], r);
    }
}
