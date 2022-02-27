public class Rectangle extends Figure {

    Rectangle(Point[] points) {
        super(points);
    }

    @Override
    public double area() {
        Point[] points = getPoints();
        double sideA = Math.sqrt(Math.pow((points[1].getX() - points[0].getX()), 2) + Math.pow((points[1].getY() - points[0].getY()), 2));
        double sideB = Math.sqrt(Math.pow((points[3].getX() - points[0].getX()), 2) + Math.pow((points[3].getY() - points[0].getY()), 2));
        return sideA*sideB;
    }

    @Override
    public double perimeter() {
        Point[] points = getPoints();
        double sideA = Math.sqrt(Math.pow((points[1].getX() - points[0].getX()), 2) + Math.pow((points[1].getY() - points[0].getY()), 2));
        double sideB = Math.sqrt(Math.pow((points[3].getX() - points[0].getX()), 2) + Math.pow((points[3].getY() - points[0].getY()), 2));
        return 2*(sideA + sideB);
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
        System.out.printf("Нарисован %s прямоугольник с вершинами в точках A%s, B%s, C%s, D%s \n", getColor(color), points[0], points[1], points[2], points[3]);
    }
}