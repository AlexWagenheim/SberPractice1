public class Rectangle extends Figure {

    Rectangle(Point[] points) {
        super(points);
    }

    private double getSideA(Point[] points) {
        return Math.sqrt(Math.pow((points[1].getX() - points[0].getX()), 2) +
                Math.pow((points[1].getY() - points[0].getY()), 2));
    }

    private double getSideB(Point[] points) {
        return Math.sqrt(Math.pow((points[3].getX() - points[0].getX()), 2) +
                Math.pow((points[3].getY() - points[0].getY()), 2));
    }

    @Override
    public double area() {
        Point[] points = getPoints();
        return getSideA(points) * getSideB(points);
    }

    @Override
    public double perimeter() {
        Point[] points = getPoints();
        return 2 * (getSideA(points) + getSideB(points));
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        Point[] points = getPoints();
        System.out.printf("Нарисован %s прямоугольник с вершинами в точках A%s, B%s, C%s, D%s \n", FigureUtil.getColor(color), points[0], points[1], points[2], points[3]);
    }
}
