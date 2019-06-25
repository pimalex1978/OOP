package com.javalesson.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    //объем двигателя, у каждой машины есть объем двигателя
    private double volume;
    private EngineType engineType;
    //мощность двигателя
    private int power;
    //количество поршней. Список поршней. Объявим его как Список, и сразу его инициализируем
    private List<Piston> pistons = new ArrayList<>();

    public Engine() {
    }

    //pistons будем генерировать прямо в конструкторе, а из параметров его уберем
    //т.обр. компонуем одни объекты из других объектов, это и есть Композиция
    public Engine(double volume, EngineType engineType, int power) {
        this.volume = volume;
        this.engineType = engineType;
        this.power = power;
        for (int i=0; i<=5; i++) //у нас 5 пистонов и заполняем их в цикле
        this.pistons.add(new Piston(0.3,i)); // таким образом инициализируем 5 Piston и сохраняем их в коллекцию
    }

    public double getVolume() {
        return volume;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }

    public List<Piston> getPistons() {
        return pistons;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volume=" + volume +
                ", engineType=" + engineType +
                ", power=" + power +
                ", pistons=" + pistons +
                '}';
    }
}
