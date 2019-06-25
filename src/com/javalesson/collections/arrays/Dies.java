package com.javalesson.collections.arrays;

import java.security.SecureRandom;

//рассматриваем пример с двумерным массивом (multidimArrayLauncher) и
//пример когда индексы не являются простыми числами, а являются результатом
//каких лтбо вычислений (frequency)
public class Dies {
    public static void main(String[] args) {

        //с помощью SecureRandom получаем рандомные значения
        SecureRandom random = new SecureRandom();
        //массив в котором ьудем хранить значения которые выпадают на кубике
        int[] frequency = new int[7];
        //бросаем кубик 1000 раз
        for (int i = 0; i < 1000; i++) {
            //в frequency в качестве индекса передаем random.nextInt и ограничиваем значение 6-тью
            //и соответсвенно, чтоб не было никогда "0", а значение было от 0 до 6
            //ставим 1+random.nextInt(6)
            //т.к. мы хотим при каждом бросании кубика увеличивать значение в элементе
            //массива, и мы увеличиваем элемент, который находится в поле с таким индексом
            //на 1 : ++frequency[1+random.nextInt(6)]
            ++frequency[1 + random.nextInt(6)];
        }

        //выводим что получилось.
        //говорится, что сторона i выпала frequency[i] раз
        System.out.println("Вывод значений с помощью for:");

        for (int i = 1; i < frequency.length; i++) {
            System.out.println("Side " + i + " : " + frequency[i]);
        }

        System.out.println();
        System.out.println("Вывод элементов массива с помощью foreach:");

        //при таком выводе получаем уже готовый элемент массива, а не индекс массива
        //правда не совсем корректный вывод, как это можно увидеть в консоли
        for (int i : frequency) {
            System.out.println("Side " + i);
        }


        System.out.println();
        System.out.println("Вывод двумерного массива:");
        multidimArrayLauncher();
    }

    //рассмортим двумерные массивы
    private static void multidimArrayLauncher() {
        // arr[0][0], arr[0][1], arr[0][2]
        // arr[1][0], arr[1][1], arr[1][2]
        // arr[2][0], arr[2][1], arr[2][2]

        int[][] a = {{1, 2},
                {3, 4},
                {5, 6, 7, 8, 9}};

        int[][] b = new int[3][3];

        int[][] c = new int[2][];
        c[0] = new int[2];
        c[1] = new int[4];

        //вывод элементов массива
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
