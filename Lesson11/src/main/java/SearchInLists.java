import java.util.ArrayList;
import java.util.List;

public class SearchInLists {
    public static <E> E findTheMost(List<E> list, Mapping <E> mapping) {
        E ans = list.get(0);
        double max = 0;
        for (E item: list) {
            if (mapping.getValue(item) > max) {
                max = mapping.getValue(item);
                ans = item;
            }
        }
        return ans;
    }

    @FunctionalInterface
    public interface Mapping <T> {
        double getValue(T obj);
    }
}
