package Task5;

public class PizzaOrderDriver {
    public static void main(String[] args) {
        PizzaOrder order = new PizzaOrder("Аль-Капчоне", SizeType.BIG, true, "Ярославская 101");

        System.out.println(order);

        System.out.println();
        order.order();

        System.out.println();
        order.order();

        System.out.println();
        order.cancel();

        System.out.println();
        order.cancel();
    }
}
