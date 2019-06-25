package com.javalesson.collections.arrays;

/*примеры работы с массивами*/

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLauncher {

    //для работы с консолью, (System.in) - системный инпут (ввод)
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //инициализация массива с клавиатуры
        int[] myArray3 = new int[9];
        System.out.println("Please enter 8 int elements");
        for (int j = 0; j < myArray3.length; j++) {
            System.out.println("Next element");
            myArray3[j] = scanner.nextInt();
        }
        System.out.println("Полученный массив:");
        for (int i = 0; i < myArray3.length; i++) {
            System.out.println("Element #" + i + " = " + myArray3[i]);
        }
        System.out.println("Отсортированный массив:");
        int[] array = sort(myArray3);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element #" + i + " = " + array[i]);
        }



//        //самый простой вариант инициализации массива
//        int[] myArray1 = new int[10];
//        myArray1[0] = 0;
//        myArray1[1] = 100;
//        myArray1[2] = 200;
//        myArray1[3] = 300;
//        myArray1[4] = 400;
//        myArray1[5] = 500;
//        myArray1[9] = 900;
//
//        //другой вариант инициализации массива
//        int[] myArray2 = {0, 100, 200, 300, 400, 500};
//
//        System.out.println();
//        System.out.println("Element 4 = " + myArray2[4]);
//        for (int i = 0; i < myArray2.length; i++) {
//            System.out.println("Element #" + i + " = " + myArray2[i]);
//        }

    }


    //примеры создания копии массивов:
    //        //копируем массив. это не очень эффективный метод, но рабочий, для того кто не знает
//        //как копировать по другому
//        //создаем новый массив
//        int[] myNewArrya = new int[array.length];
//        for(int i=0; i<array.length; i++){
//            myNewArrya[i]=array[i];
//        }

//        //лучше копировать массивы так:
//        int[] myNewArrya = Arrays.copyOf(array, array.length);//так получаем еще одну копию массива


    //создадим метод для сортировки массива, метод Пузырька, он редко используется
    //т.к. количество итерраций это произведение внутр.цикла на внеш.цикл
    //при 4-х элементах массива = 12, 5 = 20, 6 = 30...
    //работаем с двумя вложенными массивами
    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                //выполняем проверку. Хотим отсортировать элементы от меньшего к большему
                if (array[j] > array[j + 1]) {
                    int temp = array[j];//сохраняем значение во временную переменную
                    array[j] = array[j + 1];//перезаписываем значение в массиве
                    array[j + 1] = temp;
                }
            }
        }
        //возвращаем наш результат работы
        return array;
    }

}
