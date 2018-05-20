package tracker.start;

import tracker.models.Item;
import java.util.Scanner;
/**
 * Class for show game.interface .
 */
public class ShowMenu {
    private Scanner sensor = new Scanner(System.in);
    /**
     * Method for show main menu.
     */
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
    /**
     * Method for show choose menu.
     */
    public void showChoose(){
        System.out.println("Введите значения для нужной операции:");
        System.out.println("-------------------------------------------- ");
        System.out.println("-------------------------------------------- ");
        System.out.println("ADDItem    ( - добавить заявку)                  - а");
        System.out.println("SHOWItem  (- посмотреть текущие заявки)         - b");
        System.out.println("EDITItem   (- править заявку)                    - c");
        System.out.println("REMOVEItem (- удалить заявку)                    - d");
        System.out.println("EXIT       (- выход, данные не сохраняются)      - e");
        System.out.println("-------------------------------------------- ");
        System.out.print("Введите команду:    - ");
    }
    /**
     * Method for show text for delete.
     */
    public void showRemoveID(){
        System.out.println("Выбирите ID заявку  для удаления ");
        System.out.println("-------------------------------------------- ");
    }
    /**
     * Method for show text for choose.
     */
    public void showEdit(){
        System.out.println("Выбирите ID заявки  для правки ");
        System.out.println("-------------------------------------------- ");
    }
    /**
     * Method for show text for enter name.
     */
    public void showCommandForName(){
        System.out.print("Введите имя заявки:         - ");
    }
    /**
     * Method for show text for describe.
     */
    public void showCommandForDescribe(){
        System.out.print("Введите описание заявки:    - ");
    }
    /**
     * Method for show text for erroe of enter.
     */
    public void showErrorOfEnter(){
        System.out.println("Неверно введена команда, повторите ввод: ");
    }
    /**
     * Method for show text for created item.
     */
    public void createdItem(String s){
        System.out.printf("Заявка id - %s создана ", s);
        System.out.println();
    }
    /**
     * Method for show text for absent items.
     */
    public void showNoItems(){
        System.out.println("Заявок не существует  ");
    }
    /**
     * Method for enter text.
     */
    public String getScanner() {
        return sensor.nextLine();
    }
    /**
     * Method for show list of items.
     */
    public void chooseToShowItem(){
            System.out.println("Выбирите ID заявки  для просмотра ");
            System.out.println("-------------------------------------------- ");
    }
    /**
     * Method for show choosed Item.
     */
    public void showItem(Item item){
        System.out.printf("имя заяви: %s описание: %s id-заявки номер %s : дата создания заявки:  %s",
                   item.getName(), item.getDescription(), item.getID(), item.getDate());
        System.out.println();
    }
    /**
     * Method for show activities done.
     */
    public void showRemovedItem(){
        System.out.println("Выбранная заявка  удалена ");
        System.out.println("-------------------------------------------- ");
    }
}
