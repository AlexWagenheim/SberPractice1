package Task5;

import Task4.GenderType;

public class PizzaOrder {
    private String name;
    private SizeType size;
    private boolean needSauce;
    private String address;
    private boolean orderAccepted;

    PizzaOrder(String name, SizeType size, boolean needSauce, String address) {
        this.name = name;
        this.size = size;
        this.needSauce = needSauce;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public SizeType getSize() {
        return size;
    }

    public boolean getNeedSauce() {
        return needSauce;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public void setNeedSauce(boolean needSauce) {
        this.needSauce = needSauce;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String getSizeWriting() {
        String sizeInfo;
        if (size.equals(SizeType.SMALL)) {
            sizeInfo = "Маленькая";
        } else if (size.equals(SizeType.MEDIUM)) {
            sizeInfo = "Средняя";
        } else {
            sizeInfo = "Большая";
        }
        return sizeInfo;
    }

    private String getSauceWriting() {
        String sauceInfo;
        if (needSauce) {
            sauceInfo = "с соусом";
        } else {
            sauceInfo = "без соуса";
        }
        return sauceInfo;
    }

    public void order() {
        if (orderAccepted) {
            System.out.println("Заказ уже принят");
        }
        else {
            orderAccepted = true;
            System.out.printf("Заказ принят. %s пицца «%s» %s на адрес %s %n", getSizeWriting(), name, getSauceWriting(), address);
        }
    }

    public void cancel() {
        if (orderAccepted) {
            orderAccepted = false;
            System.out.println("Заказ отменён");
        } else {
            System.out.println("Заказ не был принят");
        }
    }

    private String getOrderStatus() {
        String orderInfo;
        if (orderAccepted) {
            orderInfo = "принят";
        } else {
            orderInfo = "не принят";
        }
        return orderInfo;
    }

    public String toString() {

        return String.format("Заказ\nНазвание пиццы: %s\nРазмер: %s\nСоус: %s\nАдрес доставки: %s\nСтатус заказа: %s",
                name, getSizeWriting(), getSauceWriting(), address, getOrderStatus());
    }
}
