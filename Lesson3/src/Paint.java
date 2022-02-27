public class Paint {
    public static void main(String[] args) {
        //Graphics f = Rectangle(0, 0, -1, -1);
        FigureUtil.draw(new Circle(new Point(0, 0), 5));
        System.out.println(FigureUtil.area(new Rectangle(new Point[]{new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0)})));
//        System.out.println();
    }
}
