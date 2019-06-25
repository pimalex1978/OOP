package com.javalesson.collections.map.hashmap;

import com.javalesson.collections.set.Car;

import java.util.HashMap;
import java.util.Map;

//Map - это ничто иное, как ассоциативный массив, т.е. Коллекцияя которая помагает хранить ассоциацию между ключом и значением
//поэтому в Коллекции Мар есть пара Ключ-Значение
//Он параметризирован, и его параметры это ключ и значение
public class MapLauncherSimple {
    public static void main(String[] args) {

//        //создадим Map, выберем имплиментацию для Map<> HashMap<>()
//        //где String-ключ - и Ключи всегда Уникальные, Integer-значение
//        //при повторе ключа произойдет перезапись в Коллеккции
//        Map<String, Integer> numbers = new HashMap<>();
//        //сохраняем значения в numbers с помощью метода put
//        numbers.put("One", 1);
//        numbers.put("Two", 2);
//        numbers.put("Three", 3);
//
//        //доступ к значениям в Коллекции получаем по ключу
//        System.out.println(numbers.get("Two"));

        //для того чтобы в параметрах ключом был какой то объект Car, у этого класса должен быть имплиментирован
        //метод hashCode() и метод equals(). И тип Car должен быть не изменяемым final и private и чтоб нельзя было создавать
        // подклассы нашего Car (класс объявлен как final). В Car это все есть.
        //и если в полях хранится ссылка на другие объекты, то он тоже должен быть final
        //это сделано для того чтоб объект не смогли изменить,т.к. при изменении объкта мы не сможем найти его в Коллекции Map
        //потому что измениться хеш-код

        Map<Car, Integer> numbers = new HashMap<>();
        numbers.put(new Car("Toyota", "Corolla", 50),50);
        numbers.put(new Car("Audi", "A5", 50),51);
        numbers.put(new Car("Toyota", "Auris", 50),52);
        //выведем значение по ключу. В роли ключа выступает объект Car
        System.out.println(numbers.get(new Car("Audi", "A5", 50)));

    }
}
