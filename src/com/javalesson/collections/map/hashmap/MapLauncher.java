package com.javalesson.collections.map.hashmap;

import java.util.*;

public class MapLauncher {
    //будем считать сколько раз встречается то или иное слово в тексте.
    //тект вводим с консоли
    //и в конечном итоге отсортируем наши слова по убыванию

    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Please enter some text");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        //введеный string разделим на слова и сохраним в массив
        String[] tokens = string.split(" ");//в качестве разделителя используем пробел " "
        //преобразуем все слова в один регистр, например нижний, пройдемся по массиву в цикле
        for (String token : tokens) {
            String word = token.toLowerCase();

            //каждое слово word будем сохранять в Map
            //проверяем есть ли такое слово в Map
            Integer count = wordMap.get(word);
            if (count == null) {//если слова такого еще нет в Map, т.е. оно в первый раз встречается, то
                wordMap.put(word, 1);//сохраним слово в Map и присвоим ему значение 1
            } else {
                wordMap.put(word, count + 1);
            } //таким образом увеличиваем количество встречаний на 1
        }

        NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
        printSet(wordWrappers);



//        printMap(wordMap);

    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
        //будем итерироваться по wordWrappers и выводить каждое отдельное слово
        //и его counter
        for(WordWrapper wordWrapper : wordWrappers){
            System.out.println(wordWrapper);
        }

    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {

        //с помошью метода remove() можно удалять из Сета єлемент по значению или по ключу
        wordMap.remove("a");
        wordMap.remove("the", 9); //только в том случае если value(значение) будет совпадать, то Entry (объект)
                                    //будет удален

        //с помощью метода replace() можно произвести замену
        wordMap.replace("the", 0);//и counter изменится с имеющейся цифры на 0
        wordMap.replace("the",9, 0);//или же указывая старое значение 9 и новое 0.
                                                    //если старое совпадет с 9, то только тогда произведется замена на новое 0

        //создаем Сет для того чтоб в него записывать завернутые в WordWrapper ключи и значения
        //TreeSet хорошо для этого подойдет
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        //тоже итерируемся по коллекции Мар
        //используем для этого entrySet
        //т.обр. получаем Set всех наших Entry (Set пар Ключ и Значение)
        // в цикле будем создавать объект WordWrapper, заварачивать наши Ключи и Значения
        //и записывать в какой то Сет
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
            //т.обр. заполняем наш код
        }
        //после этого метода вернем wordSet
        return wordSet;
        //если хотим вернуть не изменяемую коллекцию, то ее надо преобразовать через
        // Collections.unmodifiableSet(wordSet); ля этого потом нужно сделать приведение типов конечно
    }

//    private static void printMap(Map<String, Integer> wordMap) {
//        //чтобы список был отсортированным в алф.порядке, нужно обернуть нашу HashMap в TreeMap
//        Map<String, Integer> wordTreeMap = new TreeMap<>(wordMap);
//        Set<String> keys = wordTreeMap.keySet();
//        //теперь поочереди итерируемся по Сету ключей и выводим результат на экран
//        for (String key : keys) {
//            System.out.printf("%-10s%-10s \n", key, wordMap.get(key));
//        }

}

