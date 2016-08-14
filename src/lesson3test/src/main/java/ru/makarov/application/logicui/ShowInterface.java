package ru.makarov.application.logicui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Class for Show interface.
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
    /**
     * Method for entering of text in console.
     * @return text.
     */
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
