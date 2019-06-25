package com.javalesson.collections.list;

//import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
//import java.util.List;

//Список задач на день
//Используются разные листы
//List - это ordered collection упорядоченная коллекция, каким элементом
//записаны, таким и получаете

public class ToDoList {

    //параметризированный список. Храним в нем наши задачи типа String
    //чтобы не показывать внешним пользователям наш toDoList, поэтому private
    //и мы спокойно сможем заменять имплиментацию
//    private List<String> toDoList = new ArrayList<>();

    //заменим  ArrayList на LinkedList
    private LinkedList<String> toDoList = new LinkedList<>();


    //методы List<>
    //добавление в список
    public void addToList(String task) {
//        toDoList.add(task);//addFirst - запись задания первым в очереди (это для LinkedList)
//                            //addLast - запись задания последним в очереди (это для LinkedList)
        addAlphabeticalOrder(task);
    }

    //пример использования методов ListIterator
    //этот метод будет добавлять наши задачи и вістраивать их в алфавитном порятке
    private boolean addAlphabeticalOrder(String task) {
        //получаем наш итератор
        ListIterator<String> listIter = toDoList.listIterator();
        //пока в нашем listIter есть элементы
        while (listIter.hasNext()) {
            //будем производить сравнение
            int compared = listIter.next().compareTo(task);//достаем из listIter элемент и сравниваем с task
            if (compared == 0) {//compareTo(task)-выдает 0 (есть совпадение) или -1 (нет совпадения)
                System.out.println("Task already exist in the list");
                return true;
            } else if (compared > 0) { //если >0 то элемент ставим на 1-ю позицию
                listIter.previous();
                listIter.add(task);
                return true;
            }
        }
        toDoList.add(task);//это строка нужна, т.к. когда лист еще пуст listIter.hasNext() будет возвращать falls
                                //и мы не разу не попадем в цикл while
        return true;
    }

    //есть набор задач,
    //хотим вписать на определенное место . Т.е. добавить в конкретную позицию
    //все остальные позиции списка сдвигаются вправо при этом
    //элемент, который был уже на этой позиции не потеряется, а сдвинется на одну позицию вправо
    public void addToListAtPosition(int position, String task) {
        toDoList.add(position, task);
    }

    //выводим все элементы toDoList на экран
    //метод без параметров. В цикле выводим все наши элементы
    public void printToDoList() {

        //чтобы выводить в виде нумерованного списка, используем обычный for
        //toDoList.size() - длина всех элементов
        //toDoList.get(i) - достает элемент по индексу

//        for(int i=0; i<toDoList.size();i++){
//            System.out.println(i+" - "+ toDoList.get(i)); //для LinkedList - если использовать getFirst, то вызываем Первый
//        }

        //сделаем вывод элементов списка LinkedList с помощью Итератора. Итерирование нашего листа.
        //в нашем случае лист итератор имплиментирует интерфейс Итератор. Это один из примеров использования итератора
        Iterator<String> iterator = toDoList.iterator();
        while (iterator.hasNext()) { //iterator.hasNext()-тип булеан
            //будем выводить элементы нашего листа. доступ к которым будет осуществлять
            //метод итератора next()
            System.out.println("Element " + iterator.next());
        }
    }

    //заменить задачу, мы хотим одну вычеркнуть, а другую на ее место вписать
    //т.е. перезаписать элемент в нашем списке
    //элемент находящиййся на этой позиции перезатрется
    public void changeTask(int index, String task) {
        toDoList.set(index, task);
    }

    //метод удаляющий задачи из нашего списка
    public void removeTask(String task) {
        //можно для удаления использовать индекс, по которому стоит задача
        //или название самой задачи
        toDoList.remove(task); //-используем просто задачу
    }

    //метод раставляющий задачи по приоритетам. Хотим получить индекс задачи
    public int getTaskPriority(String task) {
        return toDoList.indexOf(task); //-возвращает индекс нашей задачи
    }

}
