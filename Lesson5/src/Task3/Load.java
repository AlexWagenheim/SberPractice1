package Task3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("Lesson5/Files/save.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Car car = (Car) objectInputStream.readObject();
            System.out.println(car);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден");
        } catch (IOException exception) {
            System.out.println("Ошибка при работе с файлом");
        } catch (ClassNotFoundException exception) {
            System.out.println("Читаемый объект не найден");
        }
    }
}
