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
        System.out.println("Draw rectangle");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Draw rectangle in" + color);
    }
}
