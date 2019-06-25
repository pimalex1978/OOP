package com.javalesson.collections.set;

import java.util.*;

//для проверки уникальности элементов в Сете нужно обязательно имплиментировать
//методы hashCode и equals
//HashSet<>() работает по принципк Hash-таблиц, где одна колонка это хеш-код(ключ), а
//вторая колонка - это наш объект
//методы hashCode и equals должны соответствовать некоторым требованиям:
//для equals():
//1. рефлексивность(reflexive): x.equals(x) - результат всегда должен быть true
//2. симметрия: если x.equals(y)=true, тогда и в обратную сторону должно быть y.exuals(x)=true
//3. транзитивность: a=b and b=c тогда a=c
//для hashCode():
//при одинаковых полях каждый вызов hashCode должен возвращать один и тот же результат
//иначе получив другой хеш-код мы не сможем найти наш объект в хеш-таблице  (по сути для
//этого мы и создавали наши поля, как final)
//и для обоих:
//если два объекта x.equals(y)=true то и их хеш-коды (hashCode) должны быть одинаковые обязательно
//а если хеш-коды равны, то это не значит что x.equals(y)=true, потому что всегда есть небольшая вероятность
//наступления коллизии, когда два абсолютно разных объекта сгенерировали одинакой хеш-код и были сохранены
//в хеш-сет в один и тот же бакет (bucket ведро)
//
//у HashSet, в основании которого лежит хеш-мап, есть loadFactor - =0,75 это коэффициент, когда надо расширять хеш-таблицу,
// т.е. если есть 100 элементов, то начальный размер хеш-таблицы будет (c.size()/0.75+1)=100/0,75+1=133+1=134.
// Если количество элементов будет достаточно мало, то дефолтный размер будет =16
//
//TreeSet - может хранить Коллекцию в отсортированном виде


public class SetRunner2 {
    public static void main(String[] args) {

        //создадим два сета. параметризированных <Car>
        //это два дилера по аренде авто
        Set<Car> sixCars = new HashSet<>();
        //добавляем объекты типа Car в Set<Car> cars
        sixCars.add(new Car("VW", "Golf", 45));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VW", "Polo", 35));
        sixCars.add(new Car("BMW", "Z4", 120));
        sixCars.add(new Car("BMW", "440i", 200));

        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota", "Auris", 40));
        europaCars.add(new Car("Reno", "Clio", 30));
        europaCars.add(new Car("Reno", "Megan", 50));
        europaCars.add(new Car("VW", "Golf", 45));
        europaCars.add(new Car("VW", "Polo", 35));

        //создаем еще один Сет - Для объединения Сетов sixCars и europaCars
        Set<Car> uniqueCars = new HashSet<>(sixCars);
        uniqueCars.addAll(europaCars);

        //выведем все элементы на экран
        // print(uniqueCars);

        //примеры работы с сетами как с математическими множествами
        //*removeAll вычитаем одинаковые элементы
        //из начального sixCars вычитаем europaCars, и из нее удаляются все машины,
        //которые были в сети europaCars такие же
//        sixCars.removeAll(europaCars);
//        print(sixCars);
//        europaCars.removeAll(sixCars);
//        print(europaCars);

        //*пересечение - оставить в sixCars все элементы такие же как в europaCars
        //т.е. совпадающие
//        sixCars.retainAll(europaCars);
//        print(sixCars);
//        uniqueCars.retainAll(sixCars);
//        print(europaCars);

        //*симметрическая рвзность - удаляется то что есть общее в двух сетах и выводит
        //только те элементы, которые есть в одном экземляре
//        uniqueCars.removeAll(sixCars);
//        print(uniqueCars);

        //попрактикуемся с TreeSet, но предварительно нужно имплиментировать Comparable<Car>
        //в классе Car
        Set<Car> uniqueCarsTree = new TreeSet<>(sixCars);
        uniqueCarsTree.addAll(europaCars);
        print(uniqueCarsTree);

        //получаем вывод:
//        Car brand            Model                Price per day
//        Reno                 Clio                 30
//        VW                   Polo                 35
//        Toyota               Auris                40
//        VW                   Golf                 45
//        Reno                 Megan                50
//        Audi                 A3                   60
//        BMW                  Z4                   120
//        BMW                  440i                 200


        //т.к. TreeSet<> экстендит NavigableSet<E> запишем по другому
        NavigableSet<Car> uniqueCarsNavigableTree = new TreeSet<>(sixCars);
        uniqueCarsNavigableTree.addAll(europaCars);

        //метод headSet возвращает все элементы от головы до того элемента, который укажем
        //Ctrl-Alt-V - выделяем код и обличаем в переменную с помощью IDEA
        SortedSet<Car> cars = uniqueCarsNavigableTree.headSet(new Car("Toyota", "Auris", 40));
        print(cars);
        //получаем вывод: до Toyota Auris 40
//        Car brand            Model                Price per day
//        Reno                 Clio                 30
//        VW                   Polo                 35

        // метод tailSet возвращает все элементы от хвоста до того элемента, который укажем включительно
        SortedSet<Car> carsTail = uniqueCarsNavigableTree.tailSet(new Car("Toyota", "Auris", 40));
        print(carsTail);

        //получаем вывод: до Toyota Auris 40 включительно
//        Car brand            Model                Price per day
//        Toyota               Auris                40
//        VW                   Golf                 45
//        Reno                 Megan                50
//        Audi                 A3                   60
//        BMW                  Z4                   120
//        BMW                  440i                 200

        //метод subSet - выводит элементы от указанного, включительно, и до указанного, не включая его
        //а если добавим параметр true два раза, то будут включены и начальный и конечный
        SortedSet<Car> carsSubSet = uniqueCarsNavigableTree.subSet(new Car("Toyota", "Auris", 40),true, new Car("Audi", "A3", 60),true);
        print(carsSubSet);

        //получаем вывод: без true
//        Car brand            Model                Price per day
//        Toyota               Auris                40
//        VW                   Golf                 45
//        Reno                 Megan                50
        //получаем вывод: c true
//        Car brand            Model                Price per day
//        Toyota               Auris                40
//        VW                   Golf                 45
//        Reno                 Megan                50
//        Audi                 A3                   60

        //выведем еще раз отсортированный uniqueCarsNavigableTree и используем метод higher
        //он показывает какой идет следующий элемент за указанным
        print(uniqueCarsNavigableTree);
        System.out.println("Higher");
        System.out.println( uniqueCarsNavigableTree.higher(new Car("Toyota", "Auris", 40)));

        //получаем вывод:
//        Higher
//        VW Golf 45

        //вызовем метод lower, показывающий какой элемент идет перед указанным
        System.out.println("Lower");
        System.out.println( uniqueCarsNavigableTree.lower(new Car("Toyota", "Auris", 40)));

        //получаем вывод:
//        Lower
//        VW Polo 35

        //вызовем метод celling который выводит минимальный но следующий за указанным
        //изменяем цену на с 40 на 43
        System.out.println("Celling");
        System.out.println( uniqueCarsNavigableTree.ceiling(new Car("Toyota", "Auris", 40)));
        System.out.println("Celling");
        System.out.println( uniqueCarsNavigableTree.ceiling(new Car("Toyota", "Auris", 43)));

        //получаем вывод:
//        Celling
//        Toyota Auris 40
//        Celling
//        VW Golf 45

        //вызовем метод floor который выводит максимальное но следующий до указанного
        //изменяем цену на с 40 на 39
        System.out.println("Floor");
        System.out.println( uniqueCarsNavigableTree.floor(new Car("Toyota", "Auris", 40)));
        System.out.println("Floor");
        System.out.println( uniqueCarsNavigableTree.floor(new Car("Toyota", "Auris", 39)));

        //получаем вывод:
//        Floor
//        Toyota Auris 40
//        Floor
//        VW Polo 35






    }

    //создадим метод для вывода на экран. Принимает он Сет Стрингов
    //передаем патерн форматирования:-20 это отступ в право, s-тип того что надо печатать
    private static void print(Set<Car> cars) {
        System.out.printf("%-20s %-20s %-20s \n", "Car brand", "Model", "Price per day");
        //и в цикле выводим машины
        for (Car car : cars) {
            System.out.printf("%-20s %-20s %-20s \n", car.getCarBrand(), car.getModel(), car.getPricePerDay());
        }
    }

}
