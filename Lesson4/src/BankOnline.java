import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BankOnline {

    private String[] blockedCards;

    private String[] addItem(String[] a, String s) {
        String[] arr = new String[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        arr[a.length] = s;
        return arr;
    }

    private String makeCardNumber(String number) throws InvalidCardNumberException {
        number = number.replaceAll(" ", "");
        boolean correct = true;
        char ch;
        for (int i = 0; i < number.length(); i++) {
            ch = number.charAt(i);
            correct = correct && ((ch >= '0') && (ch <= 57));
        }

        if (!correct || (number.length() != 16)) {
            throw new InvalidCardNumberException("Некорректный номер карты");
        }
        return number;
    }

    private String[] addCardNumber(String[] blockedCards, String s) {
        try {
            blockedCards = addItem(blockedCards, makeCardNumber(s));
        } catch (InvalidCardNumberException exception) {
            System.out.println("Проверьте корректность заблокированного номера катры");
        }

        return blockedCards;
    }

    private String[] readCards() {
        String s;
        try (FileInputStream fis = new FileInputStream("Lesson4/Files/BlackList.txt")) {
            int i = -1;
            s = "";
            while ((i = fis.read()) != -1) {
                if (i == 13) {
                    blockedCards = addCardNumber(blockedCards, s);
                    s = "";
                } else if (i != 10) {
                    s += (char) i;
                }
            }
            blockedCards = addCardNumber(blockedCards, s);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден");
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла");
        }

        return blockedCards;
    }

    public BankOnline() {
        blockedCards = new String[0];
        blockedCards = readCards();
    }

    private boolean isBlocked(String cardNumber) {
        boolean blocked = false;
        for (String item : blockedCards) {
            if (item.equals(cardNumber)) {
                blocked = true;
            }
        }
        return blocked;
    }

    public void send(String cardNumber, Double money) throws InvalidCardNumberException,
            BlockedCardException, NegativeMoneyException, LimitMoneyException, NullArgumentException {

        if ((cardNumber == null) || (money == null)) {
            throw new NullArgumentException("Значение хотябы одного из аргуметов равно null");
        }
        String number = makeCardNumber(cardNumber);
        if (isBlocked(number)) {
            throw new BlockedCardException("Попытка перевода на заблокированную карту");
        }
        if (money < 0) {
            throw new NegativeMoneyException("Попытка перевода отрицательной суммы");
        }
        if (money > 50_000) {
            throw new LimitMoneyException("Превышен лимит перевода");
        }
        System.out.printf("На карту № %s успешно переведено %s ₽%n", cardNumber, money);
    }
}
