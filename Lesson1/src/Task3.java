import java.util.Scanner;

public class Task3 {
    public static void main(String[] args)  {
        Scanner console = new Scanner(System.in);
        System.out.println("Сколько членов последовательности сгенерировать?");
        int N = console.nextInt();
        for (int i = 1; i <= N; i++) {
            System.out.print(7*i + " ");
        }
    }
}
