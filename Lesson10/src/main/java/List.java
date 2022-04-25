public interface List extends Collection{
    void add(int index, Object item);
    void set(int index, Object item);
    Object get(int index) throws IndexOutOfBoundsException;
    int indexOf(Object item);
    int lastIndexOf(Object item);
    Object remove(int index) throws IndexOutOfBoundsException;
    List subList(int from, int to) throws IndexOutOfBoundsException;
}
