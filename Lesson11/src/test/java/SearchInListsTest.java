import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchInListsTest {
    @Test
    public void NumbersTest1() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(0);
        numbers.add(-200);
        numbers.add(73);
        numbers.add(121);

        Assertions.assertEquals(121, SearchInLists.findTheMost(numbers,
                new SearchInLists.Mapping<Integer>() {
                    @Override
                    public double getValue(Integer obj) {
                        return obj;
                    }
                }));
    }

    @Test
    public void StringsTest1() {
        List<String> strings = new ArrayList<>();
        strings.add("LADA");
        strings.add("VOLKSWAGEN");
        strings.add("BMW");
        strings.add("SKODA");
        strings.add("TOYOTA");

        Assertions.assertEquals("VOLKSWAGEN", SearchInLists.findTheMost(strings,
                new SearchInLists.Mapping<String>() {
                    @Override
                    public double getValue(String obj) {
                        return obj.length();
                    }
                }));
    }

    @Test
    public void RectanglesTest1() {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(10, 20));
        rectangles.add(new Rectangle(5, 7));
        rectangles.add(new Rectangle(7, 17));
        rectangles.add(new Rectangle(10, 10));

        Assertions.assertEquals("Rectangle{width=10, height=20}",
                SearchInLists.findTheMost(rectangles, new SearchInLists.Mapping<Rectangle>() {
                    @Override
                    public double getValue(Rectangle obj) {
                        return obj.getHeight() * obj.getHeight();
                    }
                }).toString());
    }

    @Test
    public void TrianglesTest1() {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(3, 4, 5));
        triangles.add(new Triangle(10, 10, 10));
        triangles.add(new Triangle(12, 13, 5));
        triangles.add(new Triangle(9, 9, 9));
        triangles.add(new Triangle(7, 7, 5));

        Assertions.assertEquals("Triangle{a=10, b=10, c=10}",
                SearchInLists.findTheMost(triangles, new SearchInLists.Mapping<Triangle>() {
                    @Override
                    public double getValue(Triangle obj) {
                        return obj.getA() + obj.getB() + obj.getC();
                    }
                }).toString());
    }

    @Test
    public void NumbersTest2() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(0);
        numbers.add(-200);
        numbers.add(73);
        numbers.add(121);

        Assertions.assertEquals(121, SearchInLists.findTheMost(numbers,
                obj -> obj));
    }

    @Test
    public void StringsTest2() {
        List<String> strings = new ArrayList<>();
        strings.add("LADA");
        strings.add("VOLKSWAGEN");
        strings.add("BMW");
        strings.add("SKODA");
        strings.add("TOYOTA");

        Assertions.assertEquals("VOLKSWAGEN", SearchInLists.findTheMost(strings,
                (String obj) -> obj.length()));
    }

    @Test
    public void RectanglesTest2() {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(10, 20));
        rectangles.add(new Rectangle(5, 7));
        rectangles.add(new Rectangle(7, 17));
        rectangles.add(new Rectangle(10, 10));

        Assertions.assertEquals("Rectangle{width=10, height=20}",
                SearchInLists.findTheMost(rectangles,
                        (Rectangle obj) -> obj.getWidth()*obj.getHeight()).toString());
    }

    @Test
    public void TrianglesTest2() {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(3, 4, 5));
        triangles.add(new Triangle(10, 10, 10));
        triangles.add(new Triangle(12, 13, 5));
        triangles.add(new Triangle(9, 9, 9));
        triangles.add(new Triangle(7, 7, 5));

        Assertions.assertEquals("Triangle{a=10, b=10, c=10}",
                SearchInLists.findTheMost(triangles,
                        (Triangle obj) -> obj.getA() + obj.getB() + obj.getC()).toString());
    }

    @Test
    public void RectangleTest() {
        Rectangle rectangle = new Rectangle(0, 0);
        rectangle.setWidth(10);
        rectangle.setHeight(20);

        Assertions.assertEquals("Rectangle{width=10, height=20}", rectangle.toString());
    }

    @Test
    public void TriangleTest() {
        Triangle triangle = new Triangle(0, 0, 0);
        triangle.setA(12);
        triangle.setB(13);
        triangle.setC(5);

        Assertions.assertEquals("Triangle{a=12, b=13, c=5}", triangle.toString());
    }
}
