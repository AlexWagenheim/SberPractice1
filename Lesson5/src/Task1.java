import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        String fileName1 = "Lesson5/Files/Borodino.txt";
        String fileName2 = "Lesson5/Files/CopyBorodino.txt";

        try (FileWriter out = new FileWriter(fileName2);
             FileReader in = new FileReader(fileName1))
        {
            int b;
            char previous = 0;
            while ((b = in.read()) != - 1) {
                if ((((char) b) != ' ') || (previous != ' ')) {
                    out.write(b);
                }
                previous = (char) b;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Файл Borodino.txt не найден");
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла Borodino.txt");
        }
    }
}
