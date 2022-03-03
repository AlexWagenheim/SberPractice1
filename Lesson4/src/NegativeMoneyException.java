public class NegativeMoneyException extends BankOnlineException {
    public NegativeMoneyException() {
    }

    public NegativeMoneyException(String message) {
        super(message);
    }
}
