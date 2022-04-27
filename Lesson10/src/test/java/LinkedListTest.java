import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class LinkedListTest {
    @Test
    public void LinkedListItemsCountZero () {
        LinkedList linkedList = new LinkedList();

        int size = linkedList.size();

        Assertions.assertEquals(0, size);
    }

    @Test
    public void LinkedListItemsCountOne () {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        int size = linkedList.size();

        Assertions.assertEquals(1, size);
    }

    @Test
    public void LinkedListEmpty () {
        LinkedList linkedList = new LinkedList();

        boolean answer = linkedList.isEmpty();

        Assertions.assertTrue(answer);
    }

    @Test
    public void LinkedListNotEmpty () {
        LinkedList linkedList = new LinkedList();

        linkedList.add(100);

        boolean answer = linkedList.isEmpty();

        Assertions.assertFalse(answer);
    }

    @Test
    public void LinkedListContains () {
        LinkedList linkedList = new LinkedList();

        linkedList.add(100);

        boolean answer = linkedList.contains(100);

        Assertions.assertTrue(answer);
    }

    @Test
    public void LinkedListContains2 () {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(100);

        boolean answer = linkedList.contains(100);

        Assertions.assertTrue(answer);
    }

    @Test
    public void LinkedListNotContains () {
        LinkedList linkedList = new LinkedList();

        boolean answer = linkedList.contains(100);

        Assertions.assertFalse(answer);
    }

    @Test
    public void LinkedListResizeTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(100);

        boolean answer = linkedList.contains(100);

        Assertions.assertTrue(answer);
    }

    @Test
    public void LinkedListCanRemove () {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        boolean answer = linkedList.remove("c");
        Assertions.assertTrue(answer);

        answer = linkedList.remove("a");
        Assertions.assertTrue(answer);
    }

    @Test
    public void LinkedListCanNotRemove () {
        LinkedList linkedList = new LinkedList();

        boolean answer = linkedList.remove("a");

        Assertions.assertFalse(answer);
    }

    @Test
    public void LinkedListClearTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.clear();

        boolean answer = linkedList.isEmpty();

        Assertions.assertTrue(answer);
    }

    @Test
    public void LinkedListAddAtIndex () {
        LinkedList linkedList = new LinkedList();

        linkedList.add(0, "a");
        linkedList.add(1, "b");
        linkedList.add(1, "c");
        linkedList.add(0, "d");
        Assertions.assertEquals("LinKedList{itemsCount=4, " +
                "arr=[d, a, c, b]}", linkedList.toString());
        linkedList.clear();
    }

    @Test
    public void LinkedListSetTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.set(0, "a");
        linkedList.set(5, "b");
        linkedList.set(0, "c");
        Assertions.assertEquals("LinKedList{itemsCount=2, " +
                "arr=[c, b]}", linkedList.toString());
    }

    @Test
    public void LinkedListGetTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");

        linkedList.get(0);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(10));
    }

    @Test
    public void LinkedListIndexOfTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("d");

        Assertions.assertEquals(2, linkedList.indexOf("c"));
        Assertions.assertEquals(-1, linkedList.indexOf("e"));
    }

    @Test
    public void LinkedListLastIndexOfTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("d");

        Assertions.assertEquals(3, linkedList.lastIndexOf("c"));
        Assertions.assertEquals(-1, linkedList.lastIndexOf("e"));
    }

    @Test
    public void LinkedListRemoveTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.remove(2);
        linkedList.remove(0);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(10));
    }

    @Test
    public void LinkedListSubListTest () {
        List linkedList = new LinkedList();
        List correct = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");

        correct.add("b");
        correct.add("c");
        correct.add("d");

        Assertions.assertEquals(correct.toString(), linkedList.subList(1,4).toString());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.subList(5,6));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.subList(1,6));
    }

    @Test
    public void LinkedListIteratorTest () {
        LinkedList linkedList = new LinkedList();
        StringBuilder answer = new StringBuilder();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");

        for (Object obj: linkedList) {
            answer.append((String) obj);
        }
        Assertions.assertEquals("abcde", answer.toString());

        linkedList.iterator().remove();
        linkedList.iterator().remove();
        linkedList.iterator().remove();
        linkedList.iterator().remove();
        linkedList.iterator().remove();

        linkedList.add("a");

        linkedList.iterator().remove();
        linkedList.iterator().remove();
        Assertions.assertNull(linkedList.iterator().next());
    }

    @Test
    public void LinkedListGetNode () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertNull(linkedList.getFirstNode());
        Assertions.assertNull(linkedList.getLastNode());

    }

    @Test
    public void LinkedListRemoveLastTest () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertThrows(NoSuchElementException.class, linkedList::removeLast);

        linkedList.add("a");
        linkedList.add("b");
        Assertions.assertEquals("b", linkedList.removeLast());
        Assertions.assertEquals("a", linkedList.removeLast());
    }

    @Test
    public void LinkedListRemoveFirstTest () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst);

        linkedList.add("a");
        linkedList.add("b");
        Assertions.assertEquals("a", linkedList.removeFirst());
        Assertions.assertEquals("b", linkedList.removeFirst());
    }

    @Test
    public void LinkedListPollLastTest () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertNull(linkedList.pollLast());

        linkedList.add("a");

        Assertions.assertEquals("a", linkedList.pollLast());
    }

    @Test
    public void LinkedListPollFirstTest () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertNull(linkedList.pollFirst());

        linkedList.add("a");

        Assertions.assertEquals("a", linkedList.pollFirst());
    }

    @Test
    public void LinkedListGetLastTest () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertThrows(NoSuchElementException.class, linkedList::getLast);

        linkedList.add("a");
        linkedList.add("b");
        Assertions.assertEquals("b", linkedList.getLast());
    }

    @Test
    public void LinkedListGetFirstTest () {
        LinkedList linkedList = new LinkedList();

        Assertions.assertThrows(NoSuchElementException.class, linkedList::getFirst);

        linkedList.add("a");
        linkedList.add("b");
        Assertions.assertEquals("a", linkedList.getFirst());
    }

    @Test
    public void LinkedListAddLastTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.addLast("a");
        linkedList.addLast("b");
        Assertions.assertEquals("b", linkedList.getLast());
    }

    @Test
    public void LinkedListAddFirstTest () {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst("a");
        linkedList.addFirst("b");
        Assertions.assertEquals("b", linkedList.getFirst());
    }

}
