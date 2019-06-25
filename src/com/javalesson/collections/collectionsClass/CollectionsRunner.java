package com.javalesson.collections.collectionsClass;

import java.util.*;

public class CollectionsRunner {
    public static void main(String[] args) {
//        List<String> colors = new ArrayList<>();
//
//        colors.add("yellow");
//        colors.add("blue");
//        colors.add("green");
//        colors.add("black");
//        colors.add("red");
//
//        //выведем Коллекцию до сортировки
//        System.out.println("List before sorting " + colors);
//
//        //сортируем нашу Коллекцию. Это естественная сортировка
//        Collections.sort(colors);
//        System.out.println("List after sorting " + colors);

        //сгенерируем колоду карт в цикле и сохраним в deckOfCards
        List<Card> deckOfCards = new ArrayList<>();

        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

        //выведем нашу колоду на экран, разбивая ее на 4 колонки
        System.out.println("Original deck of cards");
        printOutput(deckOfCards);

        //перемешаем нашу колоду карт, используя метод shuffle(deckOfCards)
        Collections.shuffle(deckOfCards);

        //выведем нашу колоду на экран, после перемешивания
        System.out.println("\n\nCards after shuffle");
        printOutput(deckOfCards);

        //теперь отсортируем его опять, используя sort()
        //sort(List<>):void - просто принимает List
        //sort(List<>, Comparator<? super T>):void - принимает List и Comparator
        Collections.sort(deckOfCards);

        System.out.println("\n\nCards after sorting");
        printOutput((List<Card>) deckOfCards);

        //sort(List<>, Comparator<? super T>):void - принимает List и Comparator
        //с его помощью мы можем реализовать обратный порядок сортировки

        Collections.sort(deckOfCards, Collections.reverseOrder());

        System.out.println("\n\nCards after reverse sorting");
        printOutput(deckOfCards);

        //здесь будем использовать наш компаратор CardComparator для сортировки

        Collections.sort(deckOfCards, new CardComparator());

        System.out.println("\n\nCards after our Card Comparator sorting");
        printOutput(deckOfCards);

        System.out.println();

        //Рассмотрим БИНАРНЫЙ ПОИСК
        //БИНАРНЫЙ ПОИСК работает только если наша Коллекция отсортированна

        Collections.sort(deckOfCards);
        //он возвращает позицию нашей карты,т.е. номер элемента в нашей Коллекции
        //deckOfCards-источник где ищем, card - что ищем
        Card card = new Card(Card.Suit.SPADES, Card.Face.Queen);//создали карту Пиковая Дама
        int i = Collections.binarySearch(deckOfCards, card);//i будет хранить индекс нашей карты в Коллекции
        //делаем проверку,т.к. если i>=0, то этот элемент есть в Коллекции
        if (i >= 0) {
            System.out.println("Card was found at position " + i);
        } else {
            System.out.println("Card was not found");
        }
        System.out.println();

        //создадим еще один Лист для примеров методов copy и fill
        List<Card> cardList = new ArrayList<>(deckOfCards);//deckOfCards проинициализируем и cardList не пустой
        //заполним всю нашу колоду одной картой card
        Collections.fill(cardList, card);
        printOutput(cardList);
        System.out.println();

        List<Card> cardList2 = new ArrayList<>(deckOfCards);//deckOfCards проинициализируем и cardList не пустой
        Collections.copy(cardList2, deckOfCards);//cardList2 - цель, deckOfCards - источник
        printOutput(cardList2);
        System.out.println();

        //метод addAll. добавили еще 3 карты card
        Collections.addAll(cardList2, card, card, card);
        Collections.copy(cardList2, deckOfCards);
        printOutput(cardList2);
        System.out.println();

        //метод frequency ищет в источнике определенные элементы, т.е. сколько раз они встречаются
        int frequency = Collections.frequency(cardList2, card);
        System.out.println("Frequency of "+card+" is "+frequency);
        System.out.println();

        //выведем минимум и максимум из нашей колоды
        System.out.println("MIN : "+Collections.min(cardList2));
        System.out.println("MAX : "+Collections.max(cardList2));

    }

    //этот метод создали путем нажатия Ctrl-Alt-M т.е. обернули кусок повторяющегося кода в метод
    //вариант рефакторинга
    //передадим функцию, которая поможет отформатировать строку
    //("%-20s %s")-наш патерн по отступам
    //достаем карты по индексу deckOfCards.get(i)
    //((i+1)%4==0 ? "\n" : " ") - проверка, что пора переносить строку, т.е. если количество карт =4
    //то переносим, если нет то остаемся в ней

    private static void printOutput(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : "  ");
        }
    }

    //создадим еще один класс который будет являтся нашим Компаратором и который будет имплиментировать
    //соответствующий интерфейс Comparator, который будет параметризирован классом <Card>

}
