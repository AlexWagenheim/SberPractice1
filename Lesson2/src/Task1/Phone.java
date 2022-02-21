package Task1;

public class Phone {
    private String number;
    private String model;
    private int weight; //Будем указывать в граммах

    Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0;
    }

    Phone() {
        this.number = "+79001234567";
        this.model = "UknownModel";
        this.weight = 0;
    }

    public void receiveCall(String name) {
        System.out.printf("Звонит %s%n", name);
    }

    public void receiveCall(String name, String number) {
        System.out.printf("Звонит %s (%s)%n", name, number);
    }

    public void sendMessage(String[] numbers) {
        System.out.println("sendMessage:");
        for (String s: numbers) {
            System.out.println(s);
        }
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return String.format("Номер: %s \nМодель: %s \nВес: %s \n",
                number, model, weight);
    }
}
