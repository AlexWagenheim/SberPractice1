import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList implements List, Deque{

    private int itemsCount;
    private Node first;
    private Node last;

    LinkedList(){
        itemsCount = 0;
        first = null;
        last = null;

    }

    class Node {
        Object item;
        Node next;
        Node prev;

        Node() {
            item = null;
            next = null;
            prev = null;
        }
    }



    @Override
    public int size() {
        return itemsCount;
    }

    @Override
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    @Override
    public boolean contains(Object item) {
        Node ptr = first;
        while (ptr != null) {
            if (ptr.item.equals(item)) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        Node ptr = new Node();
        ptr.item = item;
        if (itemsCount == 0) {
            first = ptr;
            last = ptr;
        } else {
            last.next = ptr;
            ptr.prev = last;
            last = ptr;
        }
        itemsCount++;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        boolean found = false;
        Node ptr = first;
        while (ptr != null) {
            if (ptr.item.equals(item)) {
                if (ptr.prev == null) {
                    first = ptr.next;
                } else {
                    ptr.prev.next = ptr.next;
                }

                if (ptr.next == null) {
                    last = ptr.prev;
                } else {
                    ptr.next.prev = ptr.prev;
                }
                itemsCount --;
                found = true;
            }
            ptr = ptr.next;
        }
        return found;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        itemsCount = 0;
    }

    @Override
    public void addFirst(Object item) {
        Node ptr = new Node();
        ptr.item = item;
        if (itemsCount == 0) {
            add(item);
        } else {
            ptr.next = first;
            first.prev = ptr;
            first = ptr;
            itemsCount++;
        }
    }

    @Override
    public void addLast(Object item) {
        add(item);
    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public Object getLast() throws NoSuchElementException {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    @Override
    public Object pollFirst() {
        if (itemsCount == 0) {
            return null;
        }
        Node ptr = new Node();
        ptr = first;
        removeFirst();
        return ptr.item;
    }

    @Override
    public Object pollLast() {
        if (itemsCount == 0) {
            return null;
        }
        Node ptr = new Node();
        ptr = last;
        removeLast();
        return ptr.item;
    }

    @Override
    public Object removeFirst() {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        Node ptr = new Node();
        ptr = first;
        if (first.next != null) {
            first.next.prev = null;
        }
        first = first.next;
        itemsCount--;
        return ptr.item;
    }

    @Override
    public Object removeLast() {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        Node ptr = new Node();
        ptr = last;
        if (last.prev != null) {
            last.prev.next = null;
        }
        last = last.prev;
        itemsCount--;
        return ptr.item;
    }

    @Override
    public void add(int index, Object item) {
        Node inserted = new Node();
        inserted.item = item;
        if (itemsCount == 0) {
            add(item);
        } else {
            Node ptr = first;
            int i = 0;
            while ((ptr != null) && (i < index)) {
                ptr = ptr.next;
                i++;
            }
            if (ptr == null) {
                add(item);
            } else {
                if (ptr.prev != null) {
                    ptr.prev.next = inserted;
                } else {
                    first = inserted;
                }
                inserted.prev = ptr.prev;
                inserted.next = ptr.next;
                if (ptr.next != null) {
                    ptr.next.prev = inserted;
                } else {
                    last = inserted;
                }
                itemsCount++;
            }
        }
    }

    @Override
    public void set(int index, Object item) {
        if (itemsCount == 0) {
            add(item);
        } else {
            Node ptr = first;
            int i = 0;
            while ((ptr != null) && (i < index)) {
                ptr = ptr.next;
                i++;
            }
            if (ptr == null) {
                add(item);
            } else {
                ptr.item = item;
            }
        }
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (itemsCount == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node ptr = first;
            int i = 0;
            while ((ptr != null) && (i < index)) {
                ptr = ptr.next;
                i++;
            }
            if (ptr == null) {
                throw new IndexOutOfBoundsException();
            } else {
                return ptr.item;
            }
        }
    }

    @Override
    public int indexOf(Object item) {
        int i = 0;
        Node ptr = first;
        while (ptr != null) {
            if (ptr.item.equals(item)) {
                return i;
            }
            ptr = ptr.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        int i = itemsCount;
        Node ptr = last;
        while (ptr != null) {
            if (ptr.item.equals(item)) {
                return i;
            }
            ptr = ptr.prev;
            i--;
        }
        return -1;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index >= itemsCount) {
            throw new IndexOutOfBoundsException();
        } else {
            int i = 0;
            Node ptr = first;
            while (i < itemsCount) {
                ptr = ptr.next;
                i++;
            }
            if (ptr.prev == null) {
                first = ptr.next;
            } else {
                ptr.prev.next = ptr.next;
            }
            if (ptr.next == null) {
                last = ptr.prev;
            } else {
                ptr.next.prev = ptr.next;
            }
            itemsCount--;
            return ptr.item;
        }
    }

    @Override
    public List subList(int from, int to) throws IndexOutOfBoundsException {
        if ((from >= itemsCount) || (to - 1 >= itemsCount)) {
            throw new IndexOutOfBoundsException();
        } else {
            List subLinkedList = new LinkedList();
            Node ptr = first;
            int i = 0;
            while (ptr != null) {
                if ((i >= from) && (i < to)) {
                    subLinkedList.add(ptr.item);
                }
                ptr = ptr.next;
                i++;
            }
            return subLinkedList;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        List.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }
}
