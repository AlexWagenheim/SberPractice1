import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void ArrayListItemsCountZero() {
        ArrayList arrayList = new ArrayList();

        int size = arrayList.size();

        Assertions.assertEquals(0, size);
    }

    @Test
    public void ArrayListItemsCountOne() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        int size = arrayList.size();

        Assertions.assertEquals(1, size);
    }

    @Test
    public void ArrayListEmpty() {
        ArrayList arrayList = new ArrayList();

        boolean answer = arrayList.isEmpty();

        Assertions.assertTrue(answer);
    }

    @Test
    public void ArrayListNotEmpty() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(100);

        boolean answer = arrayList.isEmpty();

        Assertions.assertFalse(answer);
    }

    @Test
    public void ArrayListContains() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(100);

        boolean answer = arrayList.contains(100);

        Assertions.assertTrue(answer);
    }

    @Test
    public void ArrayListContains2() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(100);

        boolean answer = arrayList.contains(100);

        Assertions.assertTrue(answer);
    }

    @Test
    public void ArrayListNotContains() {
        ArrayList arrayList = new ArrayList();

        boolean answer = arrayList.contains(100);

        Assertions.assertFalse(answer);
    }

    @Test
    public void ArrayListResizeTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(100);

        boolean answer = arrayList.contains(100);

        Assertions.assertTrue(answer);
    }

    @Test
    public void ArrayListCanRemove() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        boolean answer = arrayList.remove("b");

        Assertions.assertTrue(answer);
    }

    @Test
    public void ArrayListCanNotRemove() {
        ArrayList arrayList = new ArrayList();

        boolean answer = arrayList.remove("a");

        Assertions.assertFalse(answer);
    }

    @Test
    public void ArrayListClearTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        arrayList.clear();

        boolean answer = arrayList.isEmpty();

        Assertions.assertTrue(answer);
    }

    @Test
    public void ArrayListAddAtIndex() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(0, "a");
        arrayList.add(2, "b");
        Assertions.assertEquals("ArrayList{capacity=4, itemsCount=2, " +
                "arr=[a, null, b, null]}", arrayList.toString());
        arrayList.clear();

        arrayList.add(0, "a");
        arrayList.add(0, "b");
        arrayList.add(0, "c");
        Assertions.assertEquals("ArrayList{capacity=4, itemsCount=3, " +
                "arr=[c, b, a, null]}", arrayList.toString());
        arrayList.clear();

        arrayList.add(0, "a");
        arrayList.add(0, "b");
        arrayList.add(2, "c");
        Assertions.assertEquals("ArrayList{capacity=4, itemsCount=3, " +
                "arr=[b, a, c, null]}", arrayList.toString());
        arrayList.clear();
    }

    @Test
    public void ArrayListSetTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.set(1, "a");
        arrayList.set(0, "b");
        arrayList.set(1, "c");
        Assertions.assertEquals("ArrayList{capacity=2, itemsCount=2, " +
                "arr=[b, c]}", arrayList.toString());
        arrayList.clear();
    }

    @Test
    public void ArrayListGetTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("a");

        arrayList.get(0);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(1));
    }

    @Test
    public void ArrayListIndexOfTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("c");
        arrayList.add("d");

        Assertions.assertEquals(2, arrayList.indexOf("c"));
        Assertions.assertEquals(-1, arrayList.indexOf("e"));
    }

    @Test
    public void ArrayListLastIndexOfTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("c");
        arrayList.add("d");

        Assertions.assertEquals(3, arrayList.lastIndexOf("c"));
        Assertions.assertEquals(-1, arrayList.lastIndexOf("e"));
    }

    @Test
    public void ArrayListRemoveTest() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("a");

        arrayList.remove(0);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(1));
    }

    @Test
    public void ArrayListSubListTest() {
        ArrayList arrayList = new ArrayList();
        ArrayList correct = new ArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");

        correct.add("b");
        correct.add("c");
        correct.add("d");

        Assertions.assertEquals(correct.toString(), arrayList.subList(1, 4).toString());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.subList(5, 6));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.subList(1, 6));
    }

    @Test
    public void ArrayListIteratorTest() {
        ArrayList arrayList = new ArrayList();
        StringBuilder answer = new StringBuilder();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");

        for (Object obj : arrayList) {
            answer.append((String) obj);
        }
        Assertions.assertEquals("abcde", answer.toString());

        arrayList.clear();
        arrayList.add("a");

        arrayList.iterator().remove();
        arrayList.iterator().remove();
        Assertions.assertNull(arrayList.iterator().next());
    }
}
