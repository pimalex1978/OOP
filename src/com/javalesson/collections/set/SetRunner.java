package com.javalesson.collections.set;

//рассмотрим работу интерфеса Set. Это не самая популярная Коллекция в java,
//но все же более популярная, чкм Qeueu or Deque
//Set - это обычное множество. Но это не упорядоченная Коллекция Unordered Collection
//Set не сохраняет порядок вставки элементов в отличие от List
//а в List в каком порядке запишем в таком и прочитаем
//Set хранит в себе Уникальные элементы (Коллекции HashSet и LinkedHashSet)
//а используя имплиментацию Коллекции TreeSet будем получать отсортированную коллекцию
//HashSet является наиболее быстрым


import java.util.*;

public class SetRunner {

    public static void main(String[] args) {

        String[]cars = {"Mini","Mercedes-Benz","Audi","VW","Smart","Toyota","Porshe"};
        String[]otherCars = {"Audi","Ford","GMC","Toyota","Chevrolet"};

        //Создаем два Set, две Коллекции типа Set. Он параметризирован.
        //наш массив cars передать в конструктор Seta, что позволит создать
        //Set из той коллекции которую передаем HashSet<>(Arrays.asList(cars))
        //Используем  имплиментацию: HashSet

        Set<String> carSet = new HashSet<>(Arrays.asList(cars));

        Set<String> otherCarSet = new HashSet<>(Arrays.asList(otherCars));

        //создадим еще один Сет Стрингов создав в его конструкторе такой же как carSet
        //и дополним его otherCarSet с помощью метода addAll()
        Set<String> uniqueCars = new HashSet<>(carSet);
        uniqueCars.addAll(otherCarSet);

        //сделаем вывод с помощью созданного метода print
        print(uniqueCars);
        //вывод будет таким: [VW, Mini, Toyota, Audi, Chevrolet, Porshe, Mercedes-Benz, Ford, GMC, Smart]
        //как видим в нем нет повторяющихся элементов. Но порядок вставки не сохраняется
        //машины выводятся в абсолютно случайном порядке

        //Теперь используем другую имплиментацию: LinkedHashSet
        Set<String> carSetLinked = new LinkedHashSet<>(Arrays.asList(cars));

        Set<String> otherCarSetLinked = new LinkedHashSet<>(Arrays.asList(otherCars));

        Set<String> uniqueCarsLinked = new LinkedHashSet<>(carSetLinked);
        uniqueCarsLinked.addAll(otherCarSetLinked);

        //и опять сделаем вывод
        print(uniqueCarsLinked);
        //вывод будет таким: [Mini, Mercedes-Benz, Audi, VW, Smart, Toyota, Porshe, Ford, GMC, Chevrolet]
        //т.е. порядок сохраняется: сначала cars + потом otherCars, но также нет повторяющихся элементов

        //Теперь используем другую имплиментацию: TreeSet
        Set<String> carSetTree = new TreeSet<>(Arrays.asList(cars));

        Set<String> otherCarSetTree = new TreeSet<>(Arrays.asList(otherCars));

        Set<String> uniqueCarsTree = new TreeSet<>(carSetTree);
        uniqueCarsTree.addAll(otherCarSetTree);

        print(uniqueCarsTree);
        //вывод будет таким: [Audi, Chevrolet, Ford, GMC, Mercedes-Benz, Mini, Porshe, Smart, Toyota, VW]
        //он отсортирован и также без повторений

    }

    //создадим метод для вывода на экран. Принимает он Сет Стрингов
    private static void print  (Set<String> cars){
        System.out.println(cars);
    }
}
