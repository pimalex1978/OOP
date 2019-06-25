package com.javalesson.inheritance;

public class Piston {

    //у нашего поршня есть какой то объем
    private double volume;
    private int pistonNumber;//количество поршней

    Piston(double volume, int pistonNumber) {
        this.volume = volume;
        this.pistonNumber = pistonNumber;
    }

    //метод показывающий что поршень двигается
    public void movePiston() {
        System.out.println("Piston #" + pistonNumber + " is moving");
    }

    @Override
    public String toString() {
        return "Piston{" +
                "volume=" + volume +
                ", pistonNumber=" + pistonNumber +
                '}';
    }
}
