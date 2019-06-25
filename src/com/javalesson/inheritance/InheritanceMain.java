package com.javalesson.inheritance;

import sun.swing.SwingUtilities2;

import java.util.List;

public class InheritanceMain {
    public static void main(String[] args) {

/*
        //здесь с помощью Композиции создаем уже немного другой объект, который включает в себя
        //уже другие более сложные объекты, и их свойства доступны основному объекту.
        //Наследование в этом проигрывает Композиции. Композиция более гибкая
        //Но и у наследования и у композиции есть свои преимущества и недостатки

        //создаем двигатель
        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);

        //после того как создали двигатель truckEngine передаем его в Truck

        //создаем и инициализируем грузовик
        Truck truck = new Truck("Volvo", "VNL300", truckEngine, 300, 500, 10000);
        //поработаем с нашим грузовиком
        truck.start();
        truck.accelerate(40);
        truck.stop();
        truck.fuelUp(50);//здесь метод вызывается из суперкласса FuelAuto
        truck.load();
        truck.unload();

        System.out.println("\n");

        //сделаем тоже самое с нашим электромобилем
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", EngineType.ELECTRIC, 100500, 4);
        electricCar.start();
        electricCar.accelerate(50);
        electricCar.stop();
        electricCar.charge();

        System.out.println("\n");

        //создаем двигатель для автобуса
        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 150);

        //после того как создали двигатель busEngine передаем его в Bus

        //и для автобуса
        Bus bus = new Bus("Mersedec", "Sprinter", busEngine, 75, 100, 14);
        bus.fuelUp(); //здесь вызывается именно метод из класса Bus, Override метод, а не из суперкласса FuelAuto
        bus.pickUpPassengers(4);
        bus.start();
        bus.releasePassengers();

        System.out.println("\n");

        Engine engine = bus.getEngine();//при вызове getEngine мы получаем ссылку на объект Engine
        System.out.println(engine.getEngineType());
        List<Piston> pistons = engine.getPistons();//получаем список наших поршней
        System.out.println(pistons);

        System.out.println();
        System.out.println(truck);
        System.out.println(bus);

*/


        /*здесь приводится пример полиморфизма*/
        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);
        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 150);
        Auto truck = new Truck("Volvo", "VNL300", truckEngine, 300, 500, 10000);
        Auto bus = new Bus("Mersedec", "Sprinter", busEngine, 75, 100, 14);
        Auto electricCar = new ElectricCar("Tesla", "Model S", EngineType.ELECTRIC, 100500, 4);

        //создадим объект класса Auto, при модификаторе abstract это не возможно
        //Auto auto = new Auto("WV", "Polo", busEngine);//busEngine-передали, чтоб не заморачиваться

/*
        bus.start();//метод вывзывается из Bus а не из Auto, т.к. переопределен в Bus
        bus.stop();

        truck.start();
        truck.stop();
*/
        System.out.println("\n");

        //вызываем метод runCar и передаем ему Bus и Truck и electricCar
        runCar(bus);
        runCar(truck);
        runCar(electricCar);
        //runCar(auto);
    }

    /*в этом методе видим как работает полиморфизм: в зависимости от того какой объект
     * пришел в качестве параметра, у того объекта и будет вызван start & stop, не смотря на то что
     * в качестве параметра указан Auto , т.е родительский объект и все наши Bus, Truck, electricCar
     * имеют с ним отношение IS-A*/
    //создаем отдельный метод для запуска машины принимает параметр типа Auto
    //и у этого объекта Auto этот метод будет вызывать start & stop
    private static void runCar(Auto auto) {
        auto.start();
        auto.stop();
        auto.energize();
/*
закоментировали, т.к. добавили energize(), и в этом коде нет нужды, т.к. energize() точно делает соответствующую заправку
        //сделаем проверку на то что auto это Truck или Bus
        //и выполним приведение типов
        if (auto instanceof Truck || auto instanceof Bus) {//в это проверке мы УТВЕРЖДАЕМ что auto является типом Truck ил Bus
            FuelAuto fAuto = (FuelAuto) auto;//выполняем принудительное приведение птипов
            //после приведения типов, мы уже можем вызвать fuelUp
            fAuto.fuelUp(50);
        }
*/


    }

}
