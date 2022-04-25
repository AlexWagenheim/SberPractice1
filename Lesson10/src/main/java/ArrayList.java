import java.util.Iterator;

public class ArrayList implements List{

    private int capacity;
    private int itemsCount;
    private final int startCapacity = 2;
    private Object[] arr;

    ArrayList() {
        capacity = startCapacity;
        itemsCount = 0;
        arr = new Object[capacity];
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
        for (int i = 0; i < itemsCount; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    private void resize(){
        Object[] buffer = new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            buffer[i] = arr[i];
        }

        capacity = (capacity*3)/2 + 1;
        arr = new Object[capacity];
        for (int i = 0; i < buffer.length; i++) {
            arr[i] = buffer[i];
        }
    }

    private void moveRight(int x) {
        for (int i = itemsCount; i > x; i--) {
            arr[i] = arr[i - 1];
        }
    }

    @Override
    public boolean add(Object item) {
        if (itemsCount + 1 > capacity) {
            resize();
        }
        arr[itemsCount] = item;
        itemsCount++;
        return true;
    }

    private void moveLeft(int x) {
        for (int i = x; i + 1< itemsCount; i++) {
            arr[i] = arr[i + 1];
        }
    }

    @Override
    public boolean remove(Object item) {
        boolean found = false;
        for (int i = 0; i < itemsCount; i++) {
            if (arr[i].equals(item)) {
                moveLeft(i);
                itemsCount--;
                i--;
                found = true;
            }
        }
        return found;
    }

    @Override
    public void clear() {
        capacity = startCapacity;
        itemsCount = 0;
        arr = new Object[capacity];
    }

    @Override
    public void add(int index, Object item) {
        while ((index >= capacity) || (itemsCount + 1 > capacity)) {
            resize();
        }
        moveRight(index);
        arr[index] = item;
        itemsCount++;
    }

    @Override
    public void set(int index, Object item) {
        if (index < itemsCount) {
            arr[index] = item;
        } else {
            add(index, item);
        }
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index >= itemsCount) {
            throw new IndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < itemsCount; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = itemsCount - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index >= itemsCount) {
            throw new IndexOutOfBoundsException();
        } else {
            Object obj = arr[index];
            moveLeft(index);
            itemsCount--;
            return obj;
        }
    }

    @Override
    public List subList(int from, int to) throws IndexOutOfBoundsException {
        if ((from >= itemsCount) || (to - 1 >= itemsCount)) {
            throw new IndexOutOfBoundsException();
        } else {
            List subArrayList = new ArrayList();
            for (int i = from; i < to; i++) {
                subArrayList.add(arr[i]);
            }
            return subArrayList;
        }
    }

    class Pointer implements Iterator{
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < itemsCount;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                i += 1;
                return arr[i - 1];
            } else {
                return null;
            }
        }

        @Override
        public void remove() {
            if (i < itemsCount) {
                moveLeft(i);
                itemsCount--;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new Pointer();
    }

    private String writeElements(){
        String ans = "";
        for (int i = 0; i < itemsCount; i++) {
            ans += arr[i];
            if (i + 1 < itemsCount) {
                ans += ", ";
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return String.format("ArrayList{capacity=%s, itemsCount=%s, arr=[%s]}", capacity, itemsCount, writeElements());
    }
}
