public class Triangle extends Figure {

    Triangle(Point[] points) {
        super(points);
    }

    private double getSideA(Point[] points) {
        return Math.sqrt(Math.pow((points[1].getX() - points[0].getX()), 2) + Math.pow((points[1].getY() - points[0].getY()), 2));
    }

    private double getSideB(Point[] points) {
        return Math.sqrt(Math.pow((points[2].getX() - points[1].getX()), 2) + Math.pow((points[2].getY() - points[1].getY()), 2));
    }

    private double getSideC(Point[] points) {
        return Math.sqrt(Math.pow((points[3].getX() - points[0].getX()), 2) + Math.pow((points[3].getY() - points[0].getY()), 2));
    }

    @Override
    public double area() {
        Point[] points = getPoints();
        double sideA = getSideA(points);
        double sideB = getSideB(points);
        double sideC = getSideC(points);
        double p = (sideA + sideB + sideC)/2;
        return Math.sqrt(p*(p - sideA)*(p - sideB)*(p - sideC));
    }

    @Override
    public double perimeter() {
        Point[] points = getPoints();
        return getSideA(points) + getSideB(points) + getSideC(points);
    }

    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Draw triangle in" + color);
    }
}
