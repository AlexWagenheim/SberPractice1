public class BankOnlineDriver {
    public static void main(String[] args) {
        BankOnline bankOnline = new BankOnline();
        try {
            bankOnline.send("1111 1111 1111 1112", 10_000.00);
        } catch (InvalidCardNumberException exception) {
            System.out.println("Проверьте номер карты");
        } catch (BlockedCardException exception) {
            System.out.println("Попытка перевода на заблокированную карту");
        } catch (LimitMoneyException exception) {
            System.out.println("Превышен лимит перевода в 50 000₽");
        } catch (NegativeMoneyException exception) {
            System.out.println("Нельзя перевести отрицательную сумму");
        } catch (NullArgumentException exception) {
            System.out.println("Значение хотябы одного из аргуметов равно null");
        }
    }
}
