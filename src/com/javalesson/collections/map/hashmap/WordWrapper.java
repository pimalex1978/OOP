package com.javalesson.collections.map.hashmap;

import java.util.Objects;

//создадим класс обуртку для нашего слова. И этот класс будем использовать для сортровки
//поэтому имплиментируем Comparable
public class WordWrapper implements Comparable<WordWrapper> {
    //создаем два поля
    private final String word;
    private final Integer count;

    public WordWrapper(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public int compareTo(WordWrapper thatWord) {
        //сравнивать будем по count
        if (count < thatWord.getCount()) {
            return -1;//-1 т.к. хотим чтоб то что больше было вверху списка
                        //-1 выбрали следуя спецификации
        }
        if (count > thatWord.getCount()) {
            return 1;
        }
        //сравниваем поля word, а не только их индексы
        //если оставить return 0; - то это будет грубая логическая ошибка
        return word.compareTo(thatWord.getWord());
    }

    @Override
    public String toString() {
        return word + " -> " + count;
    }

    //сгенерируем equals и hashCode с помощью Alt-Ins
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWrapper that = (WordWrapper) o;
        return Objects.equals(word, that.word) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }
}
