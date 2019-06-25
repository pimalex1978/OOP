package com.javalesson.inheritance;

public class Truck extends FuelAuto {

    private int cargoWeigt;//груз

    Truck(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int cargoWeigt) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.cargoWeigt = cargoWeigt;
        System.out.println("Constructing truck. Truck was initilized");

    }

    //методы отвечающие за загрузку и разгрузку нашего грузовика
    public void load() {
        System.out.println("Cargo loaded");
    }

    public void unload() {
        System.out.println("Cargo unloaded");
    }

    //реализация абстрактного метода из Auto
    //вызовем здесь метод унаследованый от FuelAuto, т.к. правило заправки в
    //нем уже прописано. Но мы можем добавить любую реализацию которая нам нужна
    @Override
    public void energize() {
        //заправляемся до полного
        fuelUp(getTankVolume() - getAvailablePetrol());
    }

    //переопределили метод start из Auto для Truck
    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);//установили начальную скорость отправив это в Auto
        System.out.println("Truck is starting");
    }

    //переопределим метод stop из Auto тоже для Truck

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);//Truck остановился, скорость 0
        System.out.println("Truck has stopped");
    }

    @Override
    public String toString() {
        return "Truck{" + "producer=" + getProducer() +
                ", model=" + getModel() +
                ", availablePetrol=" + getAvailablePetrol() +
                ", tankVolume=" + getTankVolume() +
                ", cargoWeigt=" + cargoWeigt +
                ", isRunning=" + isRunning +
                '}';
    }


}
