package ru.makarov.start;


import ru.makarov.model.Choose;
import ru.makarov.model.Item;

import java.util.Scanner;

import java.util.Scanner;

public class ShowMenu
{
    private Choose choose;
    private Scanner sensor = new Scanner(System.in);

    public void showInfo(){
        System.out.println("        ЗАЯВКИ          ");
        System.out.println("   Версия альфа 1.0      ");
        System.out.println("-------------------------------------------- ");
        System.out.println("Описание:               ");
        System.out.println("-------------------------------------------- ");
        System.out.println("Программа позволяет добавлять, просматривать,");
        System.out.println("а так же править и удалять заявки.Ввод с консоли");
        System.out.println("осуществляется латинскими буквами.");
        System.out.println("-------------------------------------------- ");
        System.out.println("-------------------------------------------- ");
    }
    public void showChoose(){
        System.out.println("Введите значения для нужной операции:");
        System.out.println("-------------------------------------------- ");
        System.out.println("-------------------------------------------- ");
        System.out.println("ADDItem    ( - добавить заявку)                  - а");
        System.out.println("SHOWItems  (- посмотреть текущие заявки)         - b");
        System.out.println("EDITItem   (- править заявку)                    - c");
        System.out.println("REMOVEItem (- удалить заявку)                    - d");
        System.out.println("EXIT       (- выход, данные не сохраняются)      - e");
        System.out.println("-------------------------------------------- ");
        System.out.print("Введите команду:    - ");
    }

    public void showRemove(){
        System.out.println("Выбирите ID заявку  для удаления ");
        System.out.println("-------------------------------------------- ");
    }

    public void showEdit(){
        System.out.println("Выбирите ID заявки  для правки ");
        System.out.println("-------------------------------------------- ");
    }

    public String getScanner()
    {
        return sensor.nextLine();
    }

    public Choose getChoose()
    {
        showChoose();
        String result = getScanner();
        switch (result.charAt(0)){
            case 'a':
                choose = Choose.ADDITEM;
                break;
            case 'b':
                choose = Choose.SHOWITEMS;
                break;
            case 'c':
                choose = Choose.EDITITEM;
                break;
            case 'd':
                choose = Choose.REMOVEITEM;
                break;
            case 'e':
                choose = Choose.EXIT;
                break;
            default:
                System.out.println("Некорректный ввод :");
                getChoose();

        }
        return choose;
    }

    public void showItems(Item[] items){
        int position = 0 ;
        for(Item item : items ){
            if (items[position] == null){
                break;
            }
            position++;
            System.out.println("имя заявки: " + item.getName() + "." + "        описание: " + item.getDescription() + "."
                    + "         id-заявки ноиер  " + position + ": = " + item.getID() + "." +
            "        дата создания заявки: " + item.getDate());
        }
    }
}
