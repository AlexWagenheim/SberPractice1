import java.io.*;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        String fileName1 = "Lesson5/Files/listNames.txt";
        String fileName2 = "Lesson5/Files/CopylistNames.txt";

        try (FileWriter out = new FileWriter(fileName2);
             FileReader in = new FileReader(fileName1))
        {
            int b;
            String s = "";
            while ((b = in.read()) != - 1) {
                if (((char) b) != ' ') {
                    s += (char) b;
                }
            }
            String[] wordsArray = s.split(",");
            Arrays.sort(wordsArray);
            for (String name: wordsArray) {
                out.write(name);
                out.write("\n");
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Файл listNames.txt не найден");
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла listNames.txt");
        }
    }
}
