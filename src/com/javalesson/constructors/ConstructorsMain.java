package com.javalesson.constructors;

/*для того чтобы получить доступ в нащем текущем пакете к Классу Employee, который из другого пакета
 * делаем import . У меня он настроен на автоматический режим*/
//import com.javalesson.domainmodel.Employee;
//производится импорт СТАТИЧЕСКИХ преременных и МЕТОДОВ

import com.javalesson.domainmodel.Employee;
//если не использовать import то нужно делать такие длинные и неудобочитаемые записи при создании объекта Класса Employee:
//com.javalesson.domainmodel.Employee employee = new com.javalesson.domainmodel.Employee();


import static java.lang.Math.*; //импортированны все статические методы класса Math
//после этого можем пользоваться МЕТОДАМИ sqrt,sin Класса Math
//без записи Math.sqrt(4); а просто, как будто они объявлены в нашем Классе ConstructorsMain
//sqrt(4); sin(0.235);

//import java.util.Date;
//import java.util.*; - таким образом можем импортировать все Классы из пакета java.util

public class ConstructorsMain {
    public static void main(String[] args) {

        //Date date = new Date ();
        /*например, нужно найти кв.корень из 4.
         * для этого Обращаемся к Классу Math (Класс Математических функций) вызываем МЕТОД sqrt,
         * результат записываем в переменную sqrt с типом double*/
        //double sqrt = Math.sqrt(4);
        double sqrt = sqrt(4);
        //потом мы снова хотим использовать корень квадратный. и результат сохраняем в переменную
        //double sqrt1 =  Math.sqrt(9);
        double sqrt1 = sqrt(9);
        //потом мы хотим использовать МЕТОД sin()-синус. сохраняем в переменную
        //double sin = Math.sin(0.235);
        double sin = sin(0.235);


        /*РАБОТА С КОНСТРУКОТРАМИ:*/

        Employee employee = new Employee();
        /*
         * здесь порядок сообщений будет следующий:
         * Constructor with 4 params called
         * Constructor with 3 params called
         * Employee{emploteeId=0, name='A', position='B', salary=1}
         * Empty constructor called
         *
         * Мы вызываем К-р с нашими 3 параметрами в нашем К-ре без параметров
         * попадаем в К-р с 3 параметрами. Вызываем К-р с 4 параметрами и фактически К-р, в к-ром у нас обновляется id
         * только после того, как все ПОЛЯ здесь
         * private int emploteeId;
         * private String name;
         * private String position;
         * private int salary;
         * private String department;
         * инициализированны
         * был выведен месседж "Constructor with 4 params called" и выполнение внутреннего private К-ра закончилось
         * только после этого мы выходим из строчки  this(name, position, salary, "IT"); (это К-р с 3 параметрами)
         * и выводим сообщение "Constructor with 3 params called"
         * потом соответственно попадаем в наш К-р без параметров м выводим последние сообщения :
         * ("Employee{emploteeId=0, name='A', position='B', salary=1}")
         * ("Empty constructor called");
         * И т.обр. мы знаем, что все наши ПОЛЯ к этому моменту проинициализированны
         * */
        /*создаем объект Класса Employee*/


/*
        Employee employee1 = new Employee("Alex", "developer", 150); //при использовании оператора new вызывается Конструктор
        Employee employee2 = new Employee("John", "developer", 200); //при использовании оператора new вызывается Конструктор
        Employee employee3 = new Employee("Nick", "developer junior", 100); //при использовании оператора new вызывается Конструктор
*/


        //если мы не указываем параметры в (), которые мы хотели бы передать нашему Конструктору
        //то мы попадаем в Конструктор без параметров, но
        //мы имеем не Дефолтный Конструктор (без параметров), а имеем с Параметрами public Employee(String name, String position, int salary)
        //поэтому сразу в параметрах записываем данные. Поэтому нам не пришлось применять сеттеры



/*
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
*/

        /*если мы не будем использовать МЕТОД toString описаный в Employee, то
         *в консоль будет выводиться такая запись: com.javalesson.domainmodel.Employee@1b6d3586
         *чтобы иметь такую запись: Employee{name='Alex', position='developer', salary=100}, нужно использовать МЕТОД toString
         *@Override     public String toString()
         * */



    }
}
