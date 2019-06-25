package com.javalesson.collections.StackQueue;

import com.javalesson.collections.collectionsClass.Card;
import com.javalesson.collections.collectionsClass.CardComparator;

import java.util.*;

//Пример использования Стека
//Stack - это Коллекция,к-рая работает по принципу FILO (first in last out)
//т.е. кто первым вошел, выходит последним
//Stack не очень популяная коллекция в java, но может пригодится когда храним какие то
//объекты и обработать их нужно один раз, они будут храниться в стеке и когда вы будете
//приходить за новым объектом, старого уже не будет, т.к. он будет удаляться из стека

//также рассмотрим пример интерфеса Queue - очередь - это подинтерфейс Collection: добавление элементов происходит в конце,
//а чтение(или удаление) в начале. FIFO (first in first out)

//также рассмотрим Deque - двухстороняя Queue


public class StackQueueLauncher {
    public static void main(String[] args) {
//        passengerProcessing();

        //создадим Priority Queue который будет хранить карты (из CollectionsClass)
        //PriorityQueue так же автоматически сортирует очередь

//        Queue<Integer> q = new PriorityQueue<>();
//        //выполним offer() - добавление в очередь элементов
//        q.offer(4);
//        q.offer(5);
//        q.offer(23);
//        q.offer(1);
//
//        System.out.println(q.poll());
//        System.out.println(q.poll());


        System.out.println("\nWork with Queue");

//        Queue<Card> cardDeck = new PriorityQueue<>();
        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());
        //можно использовать компаратор, у нас он сделан чтоб
        //элементы шли от большего вниз

        //теперь в цикле заполним колоду карт
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        //выведем первые N карты, они  будут по старшинству (в порядке сортировки)
        //метод poll() будет выводить и удалять карты, когда мы его вызываем
        for (int i = 0; i < 10; i++) {
            System.out.println(cardDeck.poll());
        }
        System.out.println("Deck size is " + cardDeck.size());

        //метод peek() - вычитывает элементы из очереди но не удаляет их
        System.out.println(cardDeck.peek());
        System.out.println(cardDeck.peek());

        //clear()-удаляет все элементы в очереди и после этого наша
        //коллекция будет пустой
        cardDeck.clear();
        System.out.println("Deck size is " + cardDeck.size());


        //поработаем с Deque. Создадим еще один объект типа Deque
        // Имплиментацию выбираем ArrayDeque
        //Он тоже хранит Карты Card
        System.out.println("\nWork with Deque:");
        Deque<Card> cards = new ArrayDeque<>();
        //теперь в цикле заполним колоду карт
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        //вычитаем наши карты из cardDeck = new PriorityQueue<> c помощью метода poll()
        // и запишем в cards = new ArrayDeque<> c помощью offerFirst()
        for (int i = 0; i < 10; i++) {
            //каждый раз будем добавлять элемент в конец списка
            //а используя offerFirst их можно записывать в начало
            cards.offerLast(cardDeck.poll());
        }

        //и сделаем в цикле вывод наших элементов
        for (int i = 0; i < 10; i++) {
            //теперь вычитываем элементы из Deque<Card> cards
            //будем их вычитывать с конца
            //а используя pollFirst их можно вычитывать из начала Коллекции
            System.out.println(cards.pollLast());
        }

        System.out.println();

        //создадим карту Пиковую Десятку
        Card card = new Card(Card.Suit.SPADES, Card.Face.Ten);
        cards.removeFirstOccurrence(card);
        cards.removeLastOccurrence(card);





//        //получим из нашего cardDeck получим Итератор
//        //это для примера
//        Iterator<Card> iterator = cardDeck.iterator();
//        //итератор не гарантирует, что будет возвращать элементы коллекции
//        //в определенном порядке (когда мы итерируемся с его помощью по коллекции)
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }

    private static void passengerProcessing() {

        //создаем пассажиров и записываем в наш bus
        //и для того чтобы кто то вышел, нужно чтобы сначала вышли те кто у двери
        Stack<Passenger> bus = new Stack<>();
        Passenger passenger = new Passenger("Katerina", "Ivanova");
        //push - метод для сохранения объекта в стек
        bus.push(new Passenger("Alex", "Vasko"));
        bus.push(new Passenger("Victor", "Mikhailov"));
        bus.push(new Passenger("Dmitrii", "Petrov"));
        bus.push(passenger);
        bus.push(new Passenger("Ivan", "Ivanov"));

        //найдем нашего пассжира, который был записан в стек с помощью прерменной passenger
        //метод search() - возвращает позицию элемента по счету начиная сверху вниз
        System.out.println("Passenger found at position "+bus.search(passenger));


        //проверка кто зашел последним, метод peek()
        System.out.println("Last entered passenger is: " + bus.peek());

        //вывод элемента из стека, удаляя элемент при этом. pop()
        //проверка что в стеке нет никого, empty()
        while (!bus.empty()){
            System.out.println("Passenger : "+bus.pop());
            //после этого цикла наш стек останется пустым
        }




    }

    private static class Passenger {

        private static int number = 1;//статическое поле, в конструкторе мы при создании объекта Пасажира мы его увеличиваем на 1
        private String name;
        private String surname;

        public Passenger(String name, String surname) {

            number++;
            this.name = name;
            this.surname = surname;
        }

        public static int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passenger " +
                    " " + name +
                    " " + surname;
            //если мы будем выводить +number+, то он будет для каждого
            //пассажира свой. Но и остановится на максимуме, т.к. он number сквозной
        }
    }
}
