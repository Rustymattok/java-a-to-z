package ru.makarov.application.logicui;

import ru.makarov.application.logic.ValidationKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Class for Show interface.
 */
public class ShowInterface {
     final static String EXIT = "exit";

    public void showMenu(){
        System.out.println("Введите по указанному примеру для поиска");
        System.out.println("-d c:/ -n *.txt -m -o log.txt");
        System.out.println("Ключи");
        System.out.println("-d - директория в которая начинать поиск.");
        System.out.println("-n - имя файл, маска, либо регулярное выражение.");
        System.out.println("-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.");
        System.out.println("-o - результат записать в файл.");
        System.out.println(" - наберите exit для выхода из программы. ");
    }
    /**
     * Method for entering of text in console.
     * @return text.
     */
    public String enterText(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean flag = false;
            String text ="";
            while(!flag) {
                text = bufferedReader.readLine();
                if (text.equals(EXIT)){
                    flag = true;
                } else if (!(new ValidationKey(text)).checkText()) {
                    wrongText();
                }
                else {
                    flag = true;
                }
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void noFolder(){
        System.out.println("Указанная папка не существует");
    }

    public void wrongText(){
        System.out.println("Не корректный ввод текста.");
    }

    public void showFileAbsent(){
        System.out.println("файл отсутствует");
    }
}
