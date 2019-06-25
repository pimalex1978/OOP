package com.javalesson.collections.collectionsClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//пример работы с внутренним классом. Игральные карты.
//они имеют масть и номинал.
//карты в колоде будут проходить сравнение, поэтому имплиментируем интерфейс Comparable
//и он параметризирован тем типом, который мы сравниваем
public class Card implements Comparable<Card> {

    //два enum типа будут представлять масти и номинал
    public enum Suit {
        SPADES, HEARTS, CLUBS, DIMONDS;
    }

    public enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;}
    //создаем две переменных, которые не будут менятся после того как карта была создана

    private final Suit suit; //переменная - масть
    private final Face face; //переменная - номинал

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }

    //имплементируем метод compareTo
    @Override
    public int compareTo(Card card) {
        //превратим наш Face в массив. values() возвращает массив перечисленных элементов
        Face[] values = Face.values();
        //преобразуем values в лист Стрингов, т.е. получим Список наших номиналов
        List<Face> faces = Arrays.asList(values);

        //будем сравнивать индексы наших элементов в списке, и у кого индекс меньше тот и будет стоять впереди
        //и возвращаем для этого -1. Если индекс больше, то карта должна переместиться на более
        //позднюю позицию и возвращаем +1. И в случае, если номиналы равны но разные масти
        //тогда выполним другое условие, будем сравнивать по мастям, которые отсортируем
        //в алфавитном порядке

        //indexOf(this.face)-возвращает нам индекс элемента из списка
        if (faces.indexOf(this.face) < faces.indexOf(card.getFace())) {
            return -1;
        } else if (faces.indexOf(this.face) > faces.indexOf(card.getFace())) {
            return +1;
        } else if (faces.indexOf(this.face) == faces.indexOf(card.getFace())) {
            //здесь карты равны и нужно сравнивать масти
            //масти сортируем в алф.порядке
            //String.valueOf(suit)-suit преобразовываем в строку и сравниваем с помощью compareTo с suit карты
            //которая пришла String.valueOf(card.getSuit())
            return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
        }
        return 0;//означает что две карты абсолютно одинаковы (масть и номинал) Такое при одной колоде не выполнится
    }


    //переопределим методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                face == card.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }

    @Override
    public String toString() {
        return face + " of " + suit;//выведется, например, Туз Пик
    }

}
