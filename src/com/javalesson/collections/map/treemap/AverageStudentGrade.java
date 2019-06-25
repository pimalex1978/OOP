package com.javalesson.collections.map.treemap;

//этот класс будет у нас в качестве ключа в TreeMap
//будем по нему сортировать студентов

public class AverageStudentGrade implements Comparable<AverageStudentGrade> {
    private final String name;
    private final float averageGrade;//средний бал

    public AverageStudentGrade(String name, float averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    //Ctrl-O и оверайдим compareTo. И реализуем его.
    //и сравнивать в первую очередь будем по оценкам
    @Override
    public int compareTo(AverageStudentGrade that) {
        if (this.averageGrade < that.getAverageGrade()) {
            return -1;
        }
        if (this.averageGrade > that.getAverageGrade()) {
            return 1;
        }
        return name.compareTo(that.getName());
    }

    @Override
    public String toString() {
        return "Students name: " + name + " Grade: " + averageGrade;
    }
}
