package com.javalesson.strings.bufferANDbuilder;

//рассматриваются примеры StringBuffer & StringBuilder

public class StringRunner {

    //при работе со String мы знаем, что это не изменяемый объект. И во время изменения строки (String), он не
    //не изменяется, а создается новый, а старый потом уборщиком мусора будет удален. Но при огромных количествах
    //таких объектов (например миллионы), от этого будет большой перерасход памяти.
    //Для этого были созданы подклассы String - StringBuilder и StringBuffer,
    //это такие же String, но с возможностью изменения объекта, а не создании нового.
    //единственное их отличие StringBuilder и StringBuffer, в том что,
    //StringBuffer
    //потокобезопасный, синхронизирован, для многопоточных сред,
    //а StringBuilder
    //непотокобезопасный, несинхронизирован, для однопоточных сред

    //StringBuffer и StringBuilder позволяет работать, как со String, но при этом не создает новый объект String, а
    //изменяет старый. Памяти для этого расходуется меньше

    //StringBuffer
    //потокобезопасный, синхронизирован, для многопоточных сред
    //StringBuffer()
    //StringBuffer(int capacity)
    //StringBuffer(String str)
    //StringBuffer(CharSequence chars)

    //StringBuilder
    //непотокобезопасный, несинхронизирован, для однопоточных сред
    //StringBuilder()
    //StringBuilder(int capacity)
    //StringBuilder(String str)
    //StringBuilder(CharSequence chars)

    public static void main(String[] args) {


        String str = "Java";
        StringBuffer stringBuffer = new StringBuffer(str);

        System.out.println(stringBuffer.toString());

        System.out.println("Емкость: " + stringBuffer.capacity());

        //увеличим нашу емкость с помощью метода ensureCapacity
        stringBuffer.ensureCapacity(32);
        System.out.println("Емкость после ensureCapacity(32): " + stringBuffer.capacity());

        StringBuffer stringBuffer2 = new StringBuffer("Hi, Java");

        //выделим символ под номером 1
        char c = stringBuffer2.charAt(1);
        System.out.println(c);

        //установим вмето одного символа другой на 0 позицию, т.е. конкретная позиция
        stringBuffer2.setCharAt(0, 'w');
        System.out.println(stringBuffer2.toString());

        //или так
        stringBuffer2.setCharAt(5, c);
        System.out.println(stringBuffer2.toString());

        //получим символы в диапазоне
        StringBuffer stringBuffer3 = new StringBuffer("Hi, good Java");
        int startIndex = 1;
        int endIndex = 11;
        //куда это все запишем
        char[] buffer = new char[endIndex - startIndex];
        stringBuffer3.getChars(startIndex, endIndex, buffer, 0);
        System.out.println(buffer);

        //метод append() - добавление подстроку в конец
        StringBuffer stringBuffer4 = new StringBuffer("hello my friend");
        stringBuffer4.append(" world");
        System.out.println(stringBuffer4);

        //метод insert() добавляет подстроку по определенному индексу
        //на 3 позицию ставим L
        System.out.println( stringBuffer4.insert(3, "LOVE"));

        //indexOf() - возвращает индекс какого либо элемента в строке
        int index = stringBuffer4.indexOf("e");
        System.out.println("<e> имеет "+ index+" позицию");

        //delete() удаление символов: с какого по какой
        StringBuffer deleteChar = stringBuffer4.delete(3, 7);
        System.out.println(deleteChar);

        //deleteCharAt() - удаляет 1 символ по определенному индексу
        System.out.println( stringBuffer4);
        stringBuffer4.deleteCharAt(8);
        System.out.println(stringBuffer4);

        //обрезка строки, до какого то индекса или с какого то и до какого то,
        //и выводит то что осталось или то что вырезал
        StringBuffer stringBuffer5 = new StringBuffer("My big nice cat!");
        System.out.println(stringBuffer5);
        String substring1 = stringBuffer5.substring(6);
        System.out.println(substring1);
        String substring2 = stringBuffer5.substring(2,8);
        System.out.println(substring2);

        //изменяем длину строки: добавляет пустые символы в конце
        // или наоборот может орезать по установленной цифре
        stringBuffer5.setLength(25);
        System.out.println(stringBuffer5);

        //replace() замена подстроки
        StringBuffer stringBuffer6 = new StringBuffer("My lovely mum");
        System.out.println(stringBuffer6);
        System.out.println( stringBuffer6.replace(3,9,"nice"));

        //reverse () - меняет порядок на обратный
        StringBuffer stringBuffer7 = new StringBuffer("My lovely java");
        System.out.println(stringBuffer7);
        System.out.println(stringBuffer7.reverse());







    }
}
