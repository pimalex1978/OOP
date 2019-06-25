package com.javalesson.collections.arrays;

//имеем массив хранящий оценки

import java.util.Arrays;

public class GradeBook {
    public static void main(String[] args) {
        int[][] gradesArray = {{87, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 91, 82},
                {83, 65, 85},
                {78, 87, 65},
                {91, 94, 100},
                {76, 72, 84},
                {87, 93, 73}};

        //выведем наш результат минимума
        System.out.println("Minimal grade: " + calcMin(gradesArray));

        //запустим наш varArgs
        varArgs();

        //вызовем наш processArrays
        processArrays();
    }

    //посчитаем мин
    private static int calcMin(int[][] grades) {
        //локальная переменная хранящая в себе минимум, присвоим ей 100
        int min = 100;
        //для перебора используем foreach, итерируемся по нашим значениям
        //сначала берем строку, а это тоже массив: записали его в int[] row
        //а потом каждую строку int[] row просмотели
        for (int[] row : grades) {
            for (int i : row) {
                if (min > i) {
                    min = i;
                }
            }
        }
        return min;
    }

    //рассмотрим аргументы переменной длинны
    //тут присутствуют все свойства обычного массива
    private static void varArgs() {
        //создадим несколько перерменных типа дабл
        double a = 0.56;
        double b = 1.92;
        double c = 3.45;
        double d = 5.01;

        System.out.println("Average of 2 elements is " + calcAverage(a, b));
        System.out.println("Average of 3 elements is " + calcAverage(a, b, c));
        System.out.println("Average of 4 elements is " + calcAverage(a, b, c, d));


    }

    //создадим метод считающий среднее значение наших a,b,c,d
    //calcAvarage принимает неопределенное количество аргументов
    private static double calcAverage(double... args) {
        double sum = 0;
        //суммируем все элементы
        for (double i : args) {
            sum = sum + i;
        }

        //т.к. у наших args можно вызвать length, то и среднее значение легко получить
        //т.е. тут присутсвуют все сво-ва обычного массива
        return sum / args.length;
    }

    //рассмотрим пример использования Класса Arrays
    // создадим метод для обработки массивов
    private static void processArrays() {
        double[] doubleArray = {8.9, 5.65, 8.12, 45.0, 77.1};

        //выполняем сортировку с помощью sort()
        Arrays.sort(doubleArray);
        //выводим массив в консоль с помощью Arrays.toString(doubleArray)
        System.out.println(Arrays.toString(doubleArray));

        //метод fill() - заполнит массив определенным значением
        int[] filledArray = new int[7];
        Arrays.fill(filledArray, 7);
        System.out.println(Arrays.toString(filledArray));

        //копирование массива
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        int[] arrayCopy = new int[10];

        //для копирования используем класс System метод arraycopy
        //передаем первый массив, к-рый используем как источник,
        //указываем позицию с к-рой начнем передавать элементы
        //указываем тот массив - куда копируем и начиная с какого элемента
        //и указываем какую длину копируем
        System.arraycopy(intArray, 0, arrayCopy, 0, intArray.length);
        System.out.println(Arrays.toString(arrayCopy));

    }
}
