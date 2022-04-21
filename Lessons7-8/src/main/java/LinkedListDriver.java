import java.util.NoSuchElementException;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        System.out.println("\n" + "Тестирование LinkedList: ");
        System.out.println(linkedList);
        System.out.println("Проерка нахождения: \"e\" в LinkedList: " + linkedList.contains("e") + "; \"f\" в LinkedList: " + linkedList.contains("f"));
        linkedList.add("a");
        System.out.println("Добавили \"a\": " + linkedList);
        linkedList.remove("a");
        System.out.println("Удалили \"a\": " + linkedList);
        linkedList.clear();
        System.out.println("Удалили все элементы из LinkedList: " + linkedList);

        linkedList.add(0, "a");
        linkedList.add(0,"b");
        linkedList.add(0,"c");
        linkedList.add(0,"d");
        linkedList.add(0,"e");
        linkedList.add(0,"y");
        linkedList.add(0,"x");
        System.out.println("\n" + "Снова заполнили LinkedList: ");
        System.out.println(linkedList);
        linkedList.set(1, "b");
        System.out.println("Заменили элемент с индексом 1 на \"b\": " + linkedList);
        System.out.print("Получение элемента по индексу: ");
        try {
            System.out.println(linkedList.get(5));
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границы массива");
        }
        System.out.println("Первое появление \"b\": " + linkedList.indexOf("b"));
        System.out.println("Последнее появление \"b\": " + linkedList.lastIndexOf("b"));
        System.out.println("Первое появление \"f\": " + linkedList.indexOf("f"));
        System.out.print("Удаление элемента по индексу: ");
        try {
            System.out.println(linkedList.remove(2));
            System.out.println(linkedList);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границы писка");
        }
        System.out.print("Получение нового списка: ");
        try {
            System.out.println(linkedList.subList(1, 3));
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границы списка");
        }
        System.out.println("Вывод LinkedList с помощью итератора: ");
        for (Object obj: linkedList) {
            System.out.println(obj);
        }
        while (linkedList.iterator().hasNext()) {
            linkedList.iterator().remove();
        }
        System.out.println("Удаление всех элементов из LinkedList с помощью итератора: " + linkedList);

        System.out.println("\nТестирование реализации интерфейса Deque. Получение нового списка: ");
        linkedList.addFirst("a");
        linkedList.addLast("b");
        linkedList.addFirst("c");
        linkedList.addLast("d");
        System.out.println(linkedList);
        System.out.println("Первый элемент: " + linkedList.getFirst());
        System.out.println("Последний элемент: " + linkedList.getLast());
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Удаление первого и последнего элементов");
        System.out.println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Удаление оставшихся элементов");
        System.out.println(linkedList);
        System.out.println("Применение pollFirst(): " + linkedList.pollFirst());
        System.out.print("Попытка получения последнего элемента: ");
        try {
            System.out.println(linkedList.getLast());
        } catch (NoSuchElementException exception) {
            System.out.println("Обращение к пустому списку");
        }
    }
}
