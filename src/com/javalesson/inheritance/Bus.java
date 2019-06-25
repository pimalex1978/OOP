package com.javalesson.inheritance;

public class Bus extends FuelAuto {

    private int passengerNumber;

    Bus(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int passengerNumber) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.passengerNumber = passengerNumber;
        System.out.println("Constructing Bus. Bus was initilized");

    }

    //методы свойственные нащему автобусу
    //подобрать пассажиров и выпустить пассажиров
    public void pickUpPassengers(int passengerNum) {
        this.passengerNumber += passengerNum;
        System.out.println("Picking up " + passengerNum + " passengers");
    }

    //еще добавляем метод для заправки, переопределив его по отношению к родительскому классу
    //это оверлоадинг
    public void fuelUp() {
        int volume = getTankVolume() - getAvailablePetrol();
        fuelUp(volume);
    }

    //реализация абстрактного метода из Auto
    //вызовем здесь метод унаследованый от FuelAuto, т.к. правило заправки в
    //нем уже прописано. Но мы можем добавить любую реализацию которая нам нужна
    @Override
    public void energize() {
        //заправляемся до полного
        fuelUp(getTankVolume() - getAvailablePetrol());
    }


    //добавляем метод оверрайдинг, ctrl+O и потом исправляем метод

    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePetrol() + petrolVolume;
        //с помощью этой проверки мы заливаем бак до полного, но не переливаем его
        if (volume > getTankVolume()) {
            setAvailablePetrol(getTankVolume());//установливаем AvailablePetrol на значение возвращаемое getTankVolume
        }
        System.out.println("Adding DIESEL");
    }

    //переопределили метод start из Auto для Bus
    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);//установили начальную скорость отправив это в Auto
        System.out.println("Bus is starting");
    }

    //переопределим метод stop из Auto тоже для Bus

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);//автобкс остановился, скорость 0
        System.out.println("Bus has stopped");
    }

    public void releasePassengers() {
        //сначала проверим движется ли наш автобус
        if (isRunning) {//если движется, то
            stop();//останавливаем
        }
        passengerNumber = 0;//выпускаем всех пассажиров
        System.out.println("Passengers released");
    }

    @Override
    public String toString() {
        return "Bus{" +"producer=" + getProducer() +
                ", model=" + getModel() +
                ", availablePetrol=" + getAvailablePetrol() +
                ", tankVolume=" + getTankVolume() +
                ", passengerNumber=" + passengerNumber +
                ", isRunning=" + isRunning +
                '}';
    }
}
