package Task3;

import Task3.Engine.Petrol106;
import Task3.Model.Granta;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {
    public static void main(String[] args) {
        Car car = new Car("XTA210930Y2696785");
        System.out.println(car);

        car.setEngine(new Petrol106());
        car.setModel(new Granta());
        car.setOwnersCount(1);

        System.out.println(car);

        try (FileOutputStream fileOutputStream = new FileOutputStream("Lesson5/Files/save.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(car);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден");
        } catch (IOException exception) {
            System.out.println("Ошибка при работе с файлом");
        }
    }
}
