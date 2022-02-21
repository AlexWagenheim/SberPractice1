package Task1;

public class PersonDriver {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone("+79999999999", "Samsung");
        Phone phone3 = new Phone("+79007777777", "DEXP", 100);

        System.out.printf("phone1:%n%s%n", phone1);
        System.out.printf("phone2:%n%s%n", phone2);
        System.out.printf("phone3:%n%s%n", phone3);

        System.out.printf("phone1: %s%n", phone1.getNumber());
        System.out.printf("phone2: %s%n", phone2.getNumber());
        System.out.printf("phone3: %s%n", phone3.getNumber());
        System.out.println();

        phone1.receiveCall("Ivan");
        phone1.receiveCall("Oleg", "+79115005577");
        System.out.println();

        phone3.sendMessage(new String[]{"+79007777777", "+79999999999"});
    }
}
