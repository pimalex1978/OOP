package com.javalesson.collections.set;

import java.util.Objects;

//Comparable<> нужно имплиментировать, чтобы работать с TreeSet

public final class Car implements Comparable<Car> {

    //создадим не изменяемые поля (final). т.е. когда объект будет
    //создан, его carBrand, model, pricePerDay не смогут изменить
    private final String carBrand;
    private final String model;
    private final Integer pricePerDay; //-аренда машины в день, Integer для того чтобы можно
    //было сравниать с помощью метода equals()
    //если оставить int, то нужно будет сравнивать с помощью ==

    public Car(String carBrand, String model, int pricePerDay) {
        this.carBrand = carBrand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    //имплиментируем метод equals: переопределим метод из родительского класса
    //Ctrl-O

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        //если наш obj = null то возвращаем фолс
        //или если текущий объект this.getClass() (класс текущего объекта) не равен !=
        //obj.getClass() то тоже возвращаем фолс.
        // Т.к. класс текущего объекта и класс переданного объекта, то нет смысла продолжать сравнение
        //метод getClass() берет Класс и потом их можно сравнить
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        //дальше проверяем поля и здесь можем применять метод equals(),который имплиментирован
        //в типе Стринг
        //сперва сделаем приведение типов, класс Обжект приводим к типу Car
        Car car = (Car) obj;
        if (!this.carBrand.equals(car.getCarBrand())) {
            return false;
        }
        if (!this.model.equals(car.getModel())) {
            return false;
        }
        //если прошли две верхние проверки и они вернули true, то
        //можно сразу поставить проверку в return, и не писать еще один if()
        return this.pricePerDay.equals(car.getPricePerDay());
    }

    //имплиментируем hashCode()

    @Override
    public int hashCode() {
        //т.к. carBrand, model, pricePerDay это поля объектов,а у объектов есть свой метод hashCode()
        //поэтому просто вызываем у каждого из них hashCode, получаем int значение и потом просуммируем
        //есть смысыл домножить result на какое нибуть простое число(то которое делится на себя и 1)
        //13, 17, 31. Все это делается для того чтобы уменьшить количество возможных коллизий
        //коллизия - это когда два разных объекта возвращают один и тот же hashCode
        int result = carBrand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + pricePerDay.hashCode();
        return result;
    }

    //имплиментацию equals и hashCode, которая выше, закомментируем и сгенерируем это же с помощью java IDEA
    //и можем сравнить: нашу и java IDEA
    //при проверке, как работают имплиментированные методы (наш и IDEA) выявили,
    //что оба работают хорошо. Можно пользоваться и тем и тем

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return Objects.equals(carBrand, car.carBrand) &&
//                Objects.equals(model, car.model) &&
//                Objects.equals(pricePerDay, car.pricePerDay);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(carBrand, model, pricePerDay);
//    }


    //Ctrl-O и переопределим метод compareTo
    @Override
    public int compareTo(Car car) {
        //сортировать наши авто будем по возрастанию стоимости аренды
        //сравниваем pricePerDay и car.getPricePerDay у переданного объекта
        //если < то возвращаем -1
        if (pricePerDay < car.getPricePerDay()) {
            return -1;
        }
        if (pricePerDay > car.getPricePerDay()) {
            return +1;
        }
        //если объекты равны, то return 0
        return 0;
    }

    @Override
    public String toString() {
        return carBrand + " " + model + " " + pricePerDay;
    }
}

