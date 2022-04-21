public class ArrayListDriver {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        System.out.println("\n" + "Тестирование ArrayList: ");
        System.out.println(arr);
        System.out.println("Проерка нахождения: \"e\" в ArrayList: " + arr.contains("e") + "; \"f\" в ArrayList: " + arr.contains("f"));
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
    }
}