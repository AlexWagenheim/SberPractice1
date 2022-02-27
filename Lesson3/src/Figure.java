public abstract class Figure implements Drawable{
    private Point[] points;

    Figure(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public abstract double area();
    public abstract double perimeter();


}
