package ru.makarov.tracker;

import ru.makarov.tracker.start.*;
import ru.makarov.tracker.model.*;
import java.util.Date;

public class StartUI
{
    public static void main(String[] args)
    {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item("�������","������� ������",new Date()));
        tracker.addItem(new Item("�������","������� ������",new Date()));
        tracker.addItem(new Item("�����", "����� ������", new Date()));
        tracker.showItems();
        String id = tracker.getItems()[0].getID();
        System.out.println("����� �� ID:" + id + ". ��� �������� ������ : " + tracker.findByID(id).getName());
        //tracker.findByID(id);//todo �������� ������� ������ ��� ������
        tracker.editItem(id);
        tracker.showItems();
        tracker.removeItem(id);
        System.out.println();
        tracker.showItems();
    }
}