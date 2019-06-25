package com.javalesson.inheritance;

public class ElectricCar extends Auto{

    private int batteryVolume;//батарея аккумуляторная для электромобиля
    private int passengersNumber;//количество перевозимых людей

    ElectricCar(String producer, String model, EngineType engineType, int batteryVolume, int passengersNumber) {
        super(producer, model, new Engine());
        this.batteryVolume = batteryVolume;
        this.passengersNumber = passengersNumber;
        System.out.println("Constructing ElectricCar. ElectricCar was initilized");

    }

    //добавляем уникальное поведение свойственное этому классу
    //например заряжать батарею
    private void charge(){
        System.out.println("Battery is charging");
    }

    public int getBatteryVolume() {
        return batteryVolume;
    }

    public void setBatteryVolume(int batteryVolume) {
        this.batteryVolume = batteryVolume;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }


    //переопределили метод start из Auto для ElectricCar
    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);//установили начальную скорость отправив это в Auto
        System.out.println("ElectricCar is starting");
    }

    //переопределим метод stop из Auto тоже для ElectricCar

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);//автобкс остановился, скорость 0
        System.out.println("ElectricCar has stopped");
    }

    //реализация абстрактного метода из Auto
    //мы можем добавить любую реализацию которая нам нужна
    @Override
    public void energize() {
        charge();
    }

}
