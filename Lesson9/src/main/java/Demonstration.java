import java.util.NoSuchElementException;

public class Demonstration {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        System.out.println("\n" + "Тестирование ArrayList: ");
        System.out.println(arr);
        System.out.println("Проерка нахождения: \"e\" в ArrayList: " + arr.contains("e") +
                "; \"f\" в ArrayList: " + arr.contains("f"));
        arr.add("a");
        System.out.println("Добавили \"a\": " + arr);
        arr.remove("a");
        System.out.println("Удалили \"a\": " + arr);
        arr.clear();
        System.out.println("Удалили все элементы из ArrayList: " + arr);

        arr.add(0, "a");
        arr.add(0,"b");
        arr.add(0,"c");
        arr.add(0,"d");
        arr.add(0,"e");
        arr.add(0,"y");
        arr.add(0,"x");
        System.out.println("\n" + "Снова заполнили ArrayList: ");
        System.out.println(arr);
        arr.set(1, "b");
        System.out.println("Заменили элемент с индексом 1 на \"b\": " + arr);
        System.out.print("Получение элемента по индексу: ");
        try {
            System.out.println(arr.get(5));
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границы массива");
        }
        System.out.println("Первое появление \"b\": " + arr.indexOf("b"));
        System.out.println("Последнее появление \"b\": " + arr.lastIndexOf("b"));
        System.out.println("Первое появление \"f\": " + arr.indexOf("f"));
        System.out.print("Удаление элемента по индексу: ");
        try {
            System.out.println(arr.remove(2));
            System.out.println(arr);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границы массива");
        }
        System.out.print("Получение нового списка: ");
        try {
            System.out.println(arr.subList(1, 3));
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границы массива");
        }
        System.out.println("Вывод ArrayList с помощью итератора: ");
        for (Object obj: arr) {
            System.out.println(obj);
        }
        while (arr.iterator().hasNext()) {
            arr.iterator().remove();
        }
        System.out.println("Удаление всех элементов из ArrayList с помощью итератора: " + arr);

        //==============================================================================================================

        HashMap hashMap = new HashMap();
        hashMap.put("LADA", 750_000);
        hashMap.put("BMW", 2_000_000);
        hashMap.put("TOYOTA", 2_500_000);
        hashMap.put("SKODA", 2_100_000);
        hashMap.put("VOLKSWAGEN", 1_200_000);
        System.out.println("\n" + "Тестирование HashMap: ");
        System.out.println(hashMap);

        System.out.println("Проерка нахождения: \"LADA\" в HashMap: " + hashMap.containsKey("LADA") +
                "; \"VOLVO\" в HashMap: " + hashMap.containsKey("VOLVO"));


        hashMap.clear();
        System.out.println("Удалили все элементы из HashMap: " + hashMap);

        hashMap.put("LADA", 750_000);
        hashMap.put("BMW", 2_000_000);
        hashMap.put("TOYOTA", 2_500_000);
        hashMap.put("SKODA", 2_100_000);
        hashMap.put("VOLKSWAGEN", 1_200_000);
        System.out.println("\n" + "Снова заполнили HashMap: ");
        System.out.println(hashMap);
        hashMap.put("LADA", 850_000);
        System.out.println("Заменили значение элемента с ключом \"LADA\" на 850_000: " + hashMap);
        System.out.println("Проверка коллекции на наличие значения 850_000: " + hashMap.containsValue(850_000));
        System.out.println("Проверка коллекции на наличие значения 900_000: " + hashMap.containsValue(900_000));
        System.out.println("\n" + "Удалили из HashMap \"BMW\": ");
        hashMap.remove("BMW");
        System.out.println(hashMap);


        System.out.print("Получение списка значений: ");
        System.out.println(hashMap.values());

        System.out.print("Получение списка ключей: ");
        System.out.println(hashMap.keySet());
        System.out.print("Получение списка, состоящего из пар <key, value>: ");
        System.out.println(hashMap.entrySet());

        //==============================================================================================================

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
