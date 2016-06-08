package ru.makarov.tracker.start;

import ru.makarov.tracker.interfaces.Input;
import ru.makarov.tracker.models.Item;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Item addItem(Item item) {
         System.out.print("Введите имя заявки:         - ");
         item.setName(text());
         System.out.print("Введите описание заявки:    - ");
         item.setDescription(text());
         item.setDate();
         return item;
    }

    public String text(){
        return  scanner.nextLine();
    }
}
