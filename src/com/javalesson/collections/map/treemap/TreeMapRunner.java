package com.javalesson.collections.map.treemap;

//Пример: у нас есть группа студентов. И у студентов оценки по разным дисциплинам.
//расчитаем среднюю оценку для каждого студента и выстроим студентов по порядку в зависимости
//от среднего бала. Еще пару моментов. Это все будем разбирать на примере TreeMap

import java.util.*;

public class TreeMapRunner {
    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrades(grades, true);//если ставим true, то полный вывод информации
        System.out.println("\nOnly keys:");
        printGrades(grades, false);//если ставим false, то вывод только ключей

        //хотим отделить тех студентов, которые заслуживают стипендию
        //определим границу border
        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 80));
        //далее берем метод  чтобы выдеоить тех студентов, которые больше 80,т.е. те которые заслуживают стипендию scholarshipStudents
        //SortedMap<> делает сортировку от меньшего к большему.

//        SortedMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = grades.tailMap(border);
        //Используем NavigableMap, что сделать реверс сортировки и показать результат от большего к меньшему, также
        //нужно сделать cast(приведение типов): (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);-Alt-Enter->cast
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Scolarship students");
        // и вызываем метод descendingMap, чтобы получить нашу коллекцию в обратном порядке
        printGrades(scholarshipStudents.descendingMap(), false);//false, т.к. мы не хотим выводить value-значение
        //получим вывод:
//        Scolarship students
//        Students name: Antony Grade: 86.4
//        Students name: Alina Grade: 83.0
//        Students name: Alex Grade: 82.8

        //выведем претендета на стипендию, Contender-претендент
        //т.е. тот кто самый ближайший к порогу border 80
        System.out.println("Contender");
        AverageStudentGrade contender = grades.lowerKey(border);
        System.out.println(contender);

        //получим вывод:
//        Scolarship students
//        Students name: Antony Grade: 86.4
//        Students name: Alina Grade: 83.0
//        Students name: Alex Grade: 82.8
//        Contender
//        Students name: James Grade: 72.0

        //выведем студента с наивысшей и с наинизшей оценкой
        System.out.println("Highest grade student");
        //System.out.println(scholarshipStudents.lastEntry()); - или ->
        System.out.println(scholarshipStudents.descendingMap().firstEntry());

    }

    //метод для вывода на печать
    private static void printGrades (Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue){
        Set<AverageStudentGrade> averageGrades = grades.keySet();
        for(AverageStudentGrade gr : averageGrades){
            System.out.println(gr);//выводим ключ
            if(printValue){
                System.out.println(grades.get(gr));//по ключу получаем значение
            }
        }
    }

    private static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {

        //наши студенты с оценками
        Set<SubjectGrade> alexGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 89));
        alexGrades.add(new SubjectGrade("Physics", 65));
        alexGrades.add(new SubjectGrade("History", 95));
        alexGrades.add(new SubjectGrade("Literature", 90));
        alexGrades.add(new SubjectGrade("Chemistry", 75));

        Set<SubjectGrade> jamesGrades = new HashSet<>();
        jamesGrades.add(new SubjectGrade("Mathematics", 75));
        jamesGrades.add(new SubjectGrade("Physics", 80));
        jamesGrades.add(new SubjectGrade("History", 55));
        jamesGrades.add(new SubjectGrade("Literature", 70));
        jamesGrades.add(new SubjectGrade("Chemistry", 80));

        Set<SubjectGrade> antonyGrades = new HashSet<>();
        antonyGrades.add(new SubjectGrade("Mathematics", 93));
        antonyGrades.add(new SubjectGrade("Physics", 91));
        antonyGrades.add(new SubjectGrade("History", 82));
        antonyGrades.add(new SubjectGrade("Literature", 78));
        antonyGrades.add(new SubjectGrade("Chemistry", 88));

        Set<SubjectGrade> victorGrades = new HashSet<>();
        victorGrades.add(new SubjectGrade("Mathematics", 73));
        victorGrades.add(new SubjectGrade("Physics", 65));
        victorGrades.add(new SubjectGrade("History", 75));
        victorGrades.add(new SubjectGrade("Literature", 66));
        victorGrades.add(new SubjectGrade("Chemistry", 50));

        Set<SubjectGrade> alinaGrades = new HashSet<>();
        alinaGrades.add(new SubjectGrade("Mathematics", 90));
        alinaGrades.add(new SubjectGrade("Physics", 70));
        alinaGrades.add(new SubjectGrade("History", 78));
        alinaGrades.add(new SubjectGrade("Literature", 88));
        alinaGrades.add(new SubjectGrade("Chemistry", 89));


        //чтобы построить наших студентов по порядку, сохраним их в TreeMap
        //используем интерфейс NavigableMap<>. Он будет параметризирован AverageStudentGrade (ключ)
        //и другой коллекцией Set<SubjectGrade> (значение-value).
        //лучше конечно не использовать в качестве параметра другую коллекцию, а
        //лучше ее оборачивать и использовать объект-обертку. Но для примера оставим так.
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        //заполним наш мар: где в качестве ключа new AverageStudentGrade()
        //и в качестве значения alexGrades, jamesGrades, antonyGrades, victorGrades
        map.put(new AverageStudentGrade("Alex", calcAverage(alexGrades)), alexGrades);
        map.put(new AverageStudentGrade("James", calcAverage(jamesGrades)), jamesGrades);
        map.put(new AverageStudentGrade("Antony", calcAverage(antonyGrades)), antonyGrades);
        map.put(new AverageStudentGrade("Victor", calcAverage(victorGrades)), victorGrades);
        map.put(new AverageStudentGrade("Alina", calcAverage(alinaGrades)), alinaGrades);

        return map;//чтобы создать return map, пишем этот код и нашимаем Alt-Enter и создает IDEA
    }

    //метод для расчета среднего бала
    private static float calcAverage(Set<SubjectGrade> grades) {
        float sum = 0f;
        for (SubjectGrade sg : grades) {
            sum += sg.getGrade();
        }
        return sum / grades.size();
    }
}
