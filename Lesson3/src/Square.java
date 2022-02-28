public class Square extends Rectangle {

    Square(Point[] points) {
        super(points);
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        Point[] points = getPoints();
        System.out.printf("Нарисован %s квадрат с вершинами в точках A%s, B%s, C%s, D%s \n", FigureUtil.getColor(color), points[0], points[1], points[2], points[3]);
    }

}
