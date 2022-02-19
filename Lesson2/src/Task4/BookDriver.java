package Task4;

public class BookDriver {
    public static void main(String[] args) {
        Author author = new Author("Толстой Лев Николаевич", GenderType.MALE, "tolstoy1828@yandex.ru");
        System.out.println(author);

        System.out.println();

        Book book1 = new Book("Война и мир", author, 1873);
        System.out.println(book1);

        System.out.println();

        Book book2 = new Book("Волшебный фонарь", new Author("Цветаева Марина Ивановна", GenderType.FEMALE, "tsvetaeva1892@yandex.ru"), 1912);
        System.out.println(book2);
    }
}
