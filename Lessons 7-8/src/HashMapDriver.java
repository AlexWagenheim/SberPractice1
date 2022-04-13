public class HashMapDriver {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("LADA", 750_000);
        hashMap.put("BMW", 2_000_000);
        hashMap.put("TOYOTA", 2_500_000);
        hashMap.put("SKODA", 2_100_000);
        hashMap.put("VOLKSWAGEN", 1_200_000);
        System.out.println("\n" + "Тестирование HashMap: ");
        System.out.println(hashMap);

        System.out.println("Проерка нахождения: \"LADA\" в HashMap: " + hashMap.containsKey("LADA") + "; \"VOLVO\" в HashMap: " + hashMap.containsKey("VOLVO"));


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
    }
}
