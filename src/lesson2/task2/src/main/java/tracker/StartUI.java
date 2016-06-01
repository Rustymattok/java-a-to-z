package ru.makarov.tracker;

import ru.makarov.tracker.start.*;
import ru.makarov.tracker.model.*;
import java.util.Date;

public class StartUI
{
    public static void main(String[] args)
    {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item("Продажа","продажа товара",new Date()));
        tracker.addItem(new Item("Покупка","покупка товара",new Date()));
        tracker.addItem(new Item("Обмен", "обмен товара", new Date()));
        tracker.showItems();
        String id = tracker.getItems()[0].getID();
        System.out.println("поиск по ID:" + id + ". Имя найденой заявки : " + tracker.findByID(id).getName());
        //tracker.findByID(id);//todo тестовый вариант убрать при финале
        tracker.editItem(id);
        tracker.showItems();
        tracker.removeItem(id);
        System.out.println();
        tracker.showItems();
    }
}