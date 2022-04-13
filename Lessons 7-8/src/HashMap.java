import java.util.Arrays;

public class HashMap implements Map{

    private int size;
    private LinkedList[] buckets;
    private int itemsCount;

    class Entry{
        Object key;
        Object value;
        Entry next;
        Entry prew;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[key=" + key + ", value=" + value + ']';
        }
    }

    HashMap() {
        size = 16;
        buckets = new LinkedList[size];
        itemsCount = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return itemsCount==0;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucketNumber = Math.abs(key.hashCode() % size);
        LinkedList list = buckets[bucketNumber];
        if (list == null) {
            return false;
        }
        for (Object ptr: list) {
            Entry item = (Entry) ptr;
            if (item.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList list: buckets) {
            if (list != null) {
                for (Object obj : list) {
                    if (((Entry) obj).value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int bucketNumber = Math.abs(key.hashCode() % size);
        LinkedList list = buckets[bucketNumber];
        if (list == null) {
            return null;
        }
        for (Object ptr: list) {
            Entry item = (Entry) ptr;
            if (item.key.equals(key)) {
                return item.value;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int bucketNumber = Math.abs(key.hashCode() % size);
        LinkedList list = buckets[bucketNumber];
        if (list == null) {
            list = new LinkedList();
            list.addLast(new Entry(key, value));
            itemsCount++;
        }
        buckets[bucketNumber] = list;
        for (Object ptr: list) {
            Entry item = (Entry) ptr;
            if (item.key.equals(key)) {
                item.value = value;
                return item;
            }
        }
        list.addLast(new Entry(key, value));
        itemsCount++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        int bucketNumber = Math.abs(key.hashCode() % size);
        LinkedList list = buckets[bucketNumber];
        if (list == null) {
            return null;
        }
        for (Object ptr: list) {
            Entry item = (Entry) ptr;
            if (item.key.equals(key)) {
                list.remove(item);
                itemsCount--;
                buckets[bucketNumber] = list;
                return item.value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            buckets[i] = null;
        }
        itemsCount = 0;
    }

    @Override
    public Collection values() {
        Collection ans = new LinkedList();
        for (LinkedList list: buckets) {
            if (list != null) {
                for (Object obj : list) {
                    ans.add(((Entry) obj).value);
                }
            }
        }
        return ans;
    }

    @Override
    public Collection keySet() {
        Collection ans = new LinkedList();
        for (LinkedList list: buckets) {
            if (list != null) {
                for (Object obj : list) {
                    ans.add(((Entry) obj).key);
                }
            }
        }
        return ans;
    }

    @Override
    public Collection entrySet() {
        Collection ans = new LinkedList();
        for (LinkedList list: buckets) {
            if (list != null) {
                for (Object obj : list) {
                    ans.add((obj));
                }
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "size=" + size +
                ", buckets=" + Arrays.toString(buckets) +
                ", itemsCount=" + itemsCount +
                '}';
    }
}
