package com.javalesson.domainmodel;

/*Employee - сотрудник. Это схема для будущих Employee*/
public class Employee {

    private static int id;
    private int emploteeId; //добавили это ПОЛЕ, чтобы выводить id сотрудника, и дальше его будем использовать в нашем Контсрукторе
    private String name;
    private String position;
    private int salary;
    private String department;

    /*некоторые способы инициализации наших переменных в нашем Объекте*/
    /*БЛОКИ ИНИЦИАЛИЗАЦИИ*/
    /*статический*/
    static {
        id = 1005;
        System.out.println("Static init block called");
    }

    /*не статический*/ {
        //присваиваем department значение "IT"
        this.department = "IT";
        //мы вызвали нон-статик инициализейшен блок
        System.out.println("Non-static init block called");
    }

/*
    Если будем использовать БЛОКИ инициализации, то порядок вызова будет таким,
    как показано ниже по списку:
    1.Static init block called
    2.Non-static init block called
    3.Constructor with 4 params called
    4.Constructor with 3 params called
    5.Employee{emploteeId=1005, name='A', position='B', salary=1}
    6.Empty constructor called
*/
/*
    Сгенерерием Еще один Конструктор, но количество параметров не должно совпадать, т.к. это вызовет конфликт
     * то что они имеют одинаковое название , это не проблема.
     * использовать его не будем, это было для примера, поэтому закомментируем его
     * если мы не собираемся использовать Конструктор, то и создавать его не нужно
*/
/*
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
*/

    /*Создаем Конструктор, он похож на МЕТОД, но у него нет return type
     * имя должно совпадать с именем Класса. МЕТОДЫ нестоит называть так же как и Класс
     * а вот Конструкторы НУЖНО так называть*/
    public Employee() {
        //допустим мы хотим вызвать из этого Конструктора Конструктор с 3 параметрами
        this("A", "B", 1);
        System.out.println(toString());
        System.out.println("Empty constructor called");
    }

    /* Конструктор помагает нам Сконструировать наш новый Объект с помощью параметров,
     * которые мы передаем в ( ) и добавляя какие либо действия: счетчик, валидацию..
     * Конструктор может содержать параметры. Более того он может содержать параметры,
     * чтобы задавать параметры наших ПОЛЕЙ
     * имена наших параметров, как видим, абсолютно совпадают с именами ПОЛЕЙ в нашем Классе Employee
     * это не проблема, т.к. мы можем использовать ссылку на текущие объекты this.
     * и указывать, что мы у текущего объекта беерм ПОЛЕ name и ему присваиваем значение параметра name, которое мы передаем
     * здесь this. - это указатель на ПОЛЕ, ссылка на Объект */
    public Employee(String name, String position, int salary) {
        //вызываем Конструктор с 4-мя параметрами через название Класса: new Employee(name, position, salary, "IT");
        //new Employee(name, position, salary, "IT");
        this(name, position, salary, "IT");
        //но лучше вызывать наш Конструктор чеерез слово this (без '.')
        //т.к. это будет гарантировать, что все наши ПОЛЯ к этому моменту проинициализированны
        //В отом вся СУТЬ, что Объект должен быть иниицализирован полностью до того, как вы вызовите МЕТОД внутри вашего К-ра
        //хотя , в принципе, вызов МЕТОДА из К-ра считается довольно плохой практикой
        //К-ры отдельно, а МЕТОДЫ отдельно
        System.out.println("Constructor with 3 params called");


       /*в данном случае инициализацию ПОЛЕЙ можно убрать, потому что все онт будут инициализированны
       в следующем Конструкторе
       this.name = name;
       this.position = position;
       this.salary = salary;*/
    }

    /*можем вызывать один Конструктор из другого
     * изменим его public на private чтобы доступ к нему был только изнутри
     * перенесем в него emploteeId = id++;*/

    private Employee(String name, String position, int salary, String department) {
        emploteeId = id++; //изначально здесь была запись id=id+1, т.к. id имеет static то this. не нужно использовать
        //потом добавили еще ПОЛЕ  private int employeeId; и теперь используем employeeId= id++;
        //каждый раз при вызове нашего конструктора id будет увеличиваться на 1:id+1

        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
        System.out.println("Constructor with 4 params called");
    }



    /*создажим геттеры, чтобы прочитать содержание наших ПОЛЕЙ*/

    public int getEmploteeId() {
        return emploteeId;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    /*добавим МЕТОД toString , сгенерируем его с помощью ALT-Ins
     * этот метод будет использоваться тогда, когда мы захотим вывести содержание нашего Объекта в консоль, например
     * преобразовав его предварительно в строку String
     * можно добавить в него и id , если захотим, но будет проблемма в том,что id будет записан
     * из максимального количества, т.е. если записано 20 сотрудников, то выведет цифру 20, вне зависимости какой по списку сотрудник
     * id - это статическое поле относящееся к классу, и одинаковое для всех объектов, поэтому его не нужно добавлять сюда
     * а вот когда мы добавили private int emploteeId; то emploteeId нужно ставить toString, т.к. это уже нормальное поле объекта
     * */

    @Override
    public String toString() {
        return "Employee{" +
                "emploteeId=" + emploteeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
