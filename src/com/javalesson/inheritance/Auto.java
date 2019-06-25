package com.javalesson.inheritance;

//если стоит модификатор abstract, то это значит что из этого класса нельзя создать объект
//и это говорит, о том, что это еще не полный класс и его функционал должен быть расширен
public abstract class Auto {
    private String producer;
    private String model;
    private Engine engine;
    private int currentSpeed;
    protected boolean isRunning;

    //инициализируем поля producer, model, engine с помощью конструктора
    //currentSpeed и isRunning устанавливаются(инициализируются) когда у нас используются методы
    //start, stop, accelerate

    Auto(String producer, String model, Engine engine) {
        this.producer = producer;
        this.model = model;
        this.engine = engine;
        System.out.println("Auto was initilized");
    }

    //добавим метод отвечающий за зарядку или электричеством или топливом
    //но каждый класс наследник реализует его по своему
    public  abstract void energize();

    public void start() {
        isRunning = true;
        currentSpeed = 10;//установили начальную скорость
        System.out.println("Auto is starting");
    }

    public void stop() {
        isRunning = false;
        currentSpeed = 0;//машина остановилась, скорость 0
        System.out.println("Auto has stopped");
    }

    public void accelerate(int kmPerHour) {
        currentSpeed += kmPerHour;
        System.out.println("Accelerating. Current speed is " + currentSpeed + " kmPerHour");
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", currentSpeed=" + currentSpeed +
                ", isRunning=" + isRunning +
                '}';
    }
}
