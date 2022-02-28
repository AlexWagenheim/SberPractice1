public class Paint {
    public static void main(String[] args) {
        FigureUtil.draw(new Rectangle(new Point[]{new Point(0, 0), new Point(0, 2),
                new Point(5, 2), new Point(5, 0)}), Color.RED);

        FigureUtil.draw(new Triangle(new Point[]{new Point(0, 0), new Point(1, 3),
                new Point(2, 0)}), Color.GREEN);

        FigureUtil.draw(new Square(new Point[]{new Point(0, 0), new Point(0, 1),
                new Point(1, 1), new Point(1, 0)}), Color.BLUE);

        FigureUtil.draw(new Circle(new Point(0, 0), 5));
    }
}
