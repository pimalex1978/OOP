package com.javalesson.interfaces;

//ИНТЕРФЕЙСЫ МОГУТ ЭКСТЕНДИТЬ ДРУГ ДРУГА!!! в отличие от обычных классов


public class InterfaceRunner {
    public static void main(String[] args) {

        //тип для всех объектов можно указать Deliverable
        Priceable pizza = new Pizza("Neapolitana", 1, 20, Size.L);
        Priceable phone = new CellPhone("Motorola", "XT1575", 1, 250);
        Priceable fridge = new Fridge("LG", "E9090", 1, 300);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);
    }

    //вывод на печать стоимость доставки
    //и здесь мы использую интерфейс используем полиморфизм
    private static void printDeliveryPrice(Priceable del) {
        System.out.println("Delivery price " + del.calcDeliveryPrice());
        System.out.println("Order price " + del.calcOrderPrice());
        System.out.println("Full price " + del.calcPrice());
    }
}
