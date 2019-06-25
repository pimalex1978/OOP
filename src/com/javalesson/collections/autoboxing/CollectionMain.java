package com.javalesson.collections.autoboxing;

//продолжаем рассматривать Коллекции
//Коллекция - это структура данных, которая содержит в себе ссылки
//на другие объекты

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {


    List<String> list = new LinkedList<>();//в < > хранятся Стоки
    List<Integer> list2 = new LinkedList<>();//в < > хранятся числа типа int обернутые в обертку Integer
    list2.add(Integer.valueOf(1));//- valueOf уже делать не надо, т.к. java сама сделает autoboxing



    //так делается autoboxing
    Integer integ = 56;
    //так делается unboxing
    int n = integ;
    //int n = integ.intValue(); - так было раньше до java 8
    Double doub = 56.567;
    double d = doub;
    //double d = doub.doubleValue(); - так было раньше до java 8

        //рассмотрим как конвертировать Коллекции в Массивы toArray()
        String[] colors = {"yellow", "green", "blue"};

        //преобразуем его в LinkedList
        //это сделаем с помощью (Arrays.asList(colors)), asList()-возвращает нам список
        //фиксированного размера в основании которого лежит массив. Т.е. это не динамический массив
        //но т.к. мы его передаем в конструктор LinkedList, то мы получаем нормальный LinkedList
        LinkedList<String> ll = new LinkedList<String>(Arrays.asList(colors));

        //и мы можем в этот список добавить еще что-нибудь
        ll.add("black");

        //преобразуем LinkedList обратно в массив
        colors = ll.toArray(new String[ll.size()]);//инициализируем массив, в который будем сохранять наш LinkedList с размером size
        //т.обр. получаем массив фиксированного размера, такого же как LinkedList

        //выводим в цикле наши цвета
        for (int i=0; i<colors.length; i++){
            System.out.println(colors[i]);
        }


    }


}
