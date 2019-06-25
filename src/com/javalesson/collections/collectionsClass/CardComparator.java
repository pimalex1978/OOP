package com.javalesson.collections.collectionsClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {

    //сделаем сортировку только по номиналу карт, а масть сортировать не будем
    //получим список наших номиналов:
    List<Card.Face> faces = Arrays.asList(Card.Face.values());

    @Override
    //метод compare принимает два объекта (две карты)
    public int compare(Card card1, Card card2) {
        if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace())) {
            return +1;//-меняем -1 на +1, чтоб порядок сортировки шел в обратную сторону
        } else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace())) {
            return -1;
        } else if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace())) {
            return String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit()));//сортировка мастей в алф.порядке
            //CLUBS-DIMONDS-HEARTS-SPADES
            //если здесь будет return 0; то масти будут не отсортированы, а перемешаны
        }
        return 0;
    }
}
