public class TreeMap implements Map{

    private Node rootNode;
    private int size;

    TreeMap(){
        size = 0;
        rootNode = null;
    }

    class Entry{
        Object key;
        Object value;
        HashMap.Entry next;
        HashMap.Entry prew;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    class Node{
        Entry item;
        Node left;
        Node rigth;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
//        Node ptr = rootNode;
//        while (ptr.item.key != key) {
//            if (key < ptr.item.key) {
//                ptr = ptr.left;
//            } else {
//                ptr = ptr.rigth;
//            }
//            if (ptr == null) {
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Collection keySet() {
        return null;
    }

    @Override
    public Collection entrySet() {
        return null;
    }
}
