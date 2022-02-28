public class FigureUtil {

    private FigureUtil() {

    }

    public static double area(Figure figure) {
        return figure.area();
    }

    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }

    public static void draw(Figure figure) {
        figure.draw();
    }

    public static void draw(Figure figure, Color color) {
        figure.draw(color);
    }

    public static String getColor(Color color) {
        switch (color) {
            case RED:
                return "красный";
            case GREEN:
                return "зелёный";
            case BLUE:
                return "синий";
            case WHITE:
                return "белый";
            default:
                return "чёрный";
        }
    }
}
