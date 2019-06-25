package com.javalesson.collections.map.treemap;

//этот класс для того чтоб объект на его основе хранил название предмета
//и средний бал. Шаблон для наших оценок

import java.util.Objects;

public class SubjectGrade {
    private final String subject;
    private final int grade;

    public SubjectGrade(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }

    //т.к. этот объект будет сохранятся в коллекцию, то нужны hashCode & equals
    //такая реализация была у преподавателя (работает одинаково)

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SubjectGrade grade1 = (SubjectGrade) o;
//        if (grade != grade1.grade) return false;
//        return subject != null ? subject.equals(grade1.subject) : grade1.subject == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = subject != null ? subject.hashCode() : 0;
//        result = 31 * result + grade;
//        return result;
//    }

    //такую реализацию сгенерировала IDEA (работает одинаково)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectGrade that = (SubjectGrade) o;
        return grade == that.grade &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, grade);
    }

    @Override
    public String toString() {
        return "Subject: " + subject + " Grade: " + grade;
    }
}
