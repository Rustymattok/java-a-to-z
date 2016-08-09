package ru.makarov.application.logicui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 Создать программу для поиска файла.
2. Программа должна искать данные в заданном каталоге и подкаталогах.
3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
Ключи
-d - директория в которая начинать поиск.
-n - имя файл, маска, либо регулярное выражение.
-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
-o - результат записать в файл.
5. Программа должна записывать результат в файл.
6. В программе должна быть валидация ключей и подсказка.
 */
public class ShowInterface {

    public void showMenu(){
        System.out.println("Введите по указанному примеру для поиска");
        System.out.println("-d c:/ -n *.txt -m -o log.txt");
        System.out.println("Ключи");
        System.out.println("-d - директория в которая начинать поиск.");
        System.out.println("-n - имя файл, маска, либо регулярное выражение.");
        System.out.println("-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.");
        System.out.println("-o - результат записать в файл.");
    }

    public String enterText(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = bufferedReader.readLine();
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showFileAbsent(){
        System.out.println("файл отсутствует");
    }
}
