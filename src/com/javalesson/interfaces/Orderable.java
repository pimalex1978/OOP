package com.javalesson.interfaces;



//"способен быть заказан", т.е. вычисляем стоимость заказа

//с помощью аннотации @FunctionalInterface мы предупреждаем компилятор, и пользователей
//что это интерфейс функциональный и здесь больше не может быть абстрактных методов
@FunctionalInterface
public interface Orderable {
    int calcOrderPrice();
}
