package com.javalesson.collections.list;

//Рассматриваются Динамические массивы ArrayList
//Используются разные листы

import java.util.Scanner;

public class ListRunner {

    //объявим сканнер
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        printOut();

        //для работы приложения используем цикл while
        //пока param != 0 , мы в цикле продолжаем решать задачи
        int param = scanner.nextInt();
        while (param != 0) {

            //чтобы выбирать различные действия, в зависимости от того
            //какой param введен используем switch-case
            switch (param) {
                case 1:
                    System.out.println("Please enter a task to add");
                    scanner.nextLine();//-вводим строку с консоли, ввод задачи
                    String task1 = scanner.nextLine();
                    list.addToList(task1);
                    System.out.println("Please choose an action by typing [0 - 6]");
                    param = scanner.nextInt(); // - чтобы считать то что введено по запросу
                    break;
                case 2:
                    System.out.println("Printing out ToDoList");
                    list.printToDoList();

                    System.out.println("Please choose an action by typing [0 - 6]");
                    param = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Please an item to update");
                    scanner.nextLine();
                    int i = scanner.nextInt();
                    System.out.println("Please enter a new task");
                    scanner.nextLine();
                    String task3 = scanner.nextLine();
                    list.changeTask(i, task3);
                    System.out.println("Please choose an action by typing [0 - 6]");
                    param = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Please enter a task to remove");
                    scanner.nextLine();
                    String task4 = scanner.nextLine();
                    list.removeTask(task4);//удаляем задачу по ее имени
                    System.out.println("Please choose an action by typing [0 - 6]");
                    param = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Please enter a task to get priority (number)");
                    scanner.nextLine();
                    String task5 = scanner.nextLine();
                    System.out.println("Priority of the task is: " + list.getTaskPriority(task5));
                    System.out.println("Please choose an action by typing [0 - 6]");
                    param = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Please enter a number of position for the task");
                    scanner.nextLine();
                    int index = scanner.nextInt();
                    System.out.println("Please enter a new task");
                    scanner.nextLine();
                    String task6 = scanner.nextLine();
                    list.addToListAtPosition(index, task6);
                    System.out.println("Please choose an action by typing [0 - 6]");
                    param = scanner.nextInt();
                    break;
                default:
                    param = 0; //усли пользователь ввел не правильную цифру с
                    //клавиатуры, мы выходим. Это упрощенно.
            }

        }
    }

    //наша справка, наших опций
    private static void printOut() {
        System.out.println("Please choose an action. Press :\n"
                + "1 to add a new item into ToDoList\n"
                + "2 to print out the list \n"
                + "3 to update an existing item\n"
                + "4 to remove an item from the list\n"
                + "5 to get task priopity or number in the list\n"
                + "6 to add a new item at specific position\n"
                + "press 0 for exit\n\n"
                + "AFTER CHOOSING AN OPTION PLEASE PRESS ENTER");
    }
}
