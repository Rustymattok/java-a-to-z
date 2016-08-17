package ru.makarov.tracker.start;

import ru.makarov.tracker.interfaces.Input;
import ru.makarov.tracker.models.Item;
import java.util.Scanner;
/**
 * Class for enter items using console.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    private ShowMenu menu = new ShowMenu();
    /**
     * This method add item using console.
     * @param item - init of item.
     * @return added item.
     */
    public Item addItem(Item item) {
         menu.showCommandForName();
         item.setName(text());
         menu.showCommandForDescribe();
         item.setDescription(text());
         item.setDate();
         return item;
    }
    /**
     * This method add to item text.
     * @return added text to item.
     */
    public String text(){
        return  scanner.nextLine();
    }
}
