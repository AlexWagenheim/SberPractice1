import java.util.Locale;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        System.out.println("Отгадайте загадку");
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");

        Scanner console = new Scanner(System.in);
        String Answer;
        String CorrectAnswer = "ТРОЛЛЕЙБУС";
        String EndPhrase = "СДАЮСЬ";
        int AttemptsLeft = 3;
        boolean StopGame = false;

        while((AttemptsLeft > 0) && !StopGame) {
            System.out.println("Попыток осталось: " + AttemptsLeft);
            System.out.print("Ваш ответ: ");
            Answer = console.nextLine();
            if (Answer.toUpperCase(Locale.ROOT).equals(CorrectAnswer)) {
                StopGame = true;
                System.out.print("Правильно!");
            } else if (Answer.toUpperCase(Locale.ROOT).equals(EndPhrase)) {
                StopGame = true;
                System.out.print("Правильный ответ: " + CorrectAnswer);
            } else {
                AttemptsLeft--;
                if (AttemptsLeft == 0) {
                    System.out.println("К сожалению, Вы проиграли");
                } else {
                    System.out.println("Подумайте ещё");
                }
            }
        }

    }
}
