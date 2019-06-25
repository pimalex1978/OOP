package com.javalesson.inheritance;

//класс осуществляющий деятельность с заправкой авто
//объявляем его тоже abstract, а уже более низкие классы в иерархии Bus, electricCar, Truck
//будут его дальше наследовать
public abstract class FuelAuto extends Auto {

    private int availablePetrol; //сколько бензина в баке доступно
    private int tankVolume; // размер бака

    //конструктор наследует параметры из супер класса и добавляет свои
    FuelAuto(String producer, String model, Engine engine, int availablePetrol, int tankVolume) {
        super(producer, model, engine);
        this.availablePetrol = availablePetrol;
        this.tankVolume = tankVolume;
    }

    //метод который свойственнен только топливным двигателям
    //заправка топливом, но правда в нем нет проверки от переполнения бака топрливом
    public void fuelUp(int petrolVolume){
        availablePetrol+=petrolVolume;
        System.out.println("Adding fuel");

    }

    public int getAvailablePetrol() {
        return availablePetrol;
    }

    public void setAvailablePetrol(int availablePetrol) {
        this.availablePetrol = availablePetrol;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }
}

