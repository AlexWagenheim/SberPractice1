public class Square extends Rectangle {

    Square(Point[] points) {
        super(points);
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
        System.out.printf("Нарисован %s квадрат с вершинами в точках A%s, B%s, C%s, D%s \n", getColor(color), points[0], points[1], points[2], points[3]);
    }

}
