package ru.makarov.tracker;

import ru.makarov.tracker.interfaces.Input;
import ru.makarov.tracker.models.Choose;
import ru.makarov.tracker.models.Item;
import ru.makarov.tracker.start.ConsoleInput;
import ru.makarov.tracker.start.ShowMenu;
import ru.makarov.tracker.start.Tracker;

public class StartUI {
    public static void main(String[] args) {
        ShowMenu menu = new ShowMenu();
        Tracker tracker = new Tracker();
        ConsoleInput input = new ConsoleInput();
        //StubInput input = new StubInput();
        menu.showInfo();
        StartUITest startUI = new StartUITest();
        startUI.acton(tracker,input,menu);
    }

    public void acton(Tracker tracker, Input input,ShowMenu menu){
        boolean flag = false;
        do
        {
            try
            {
                Choose choose = menu.getChoose();
                switch (choose)
                {
                    case ADDITEM:
                        Item item = new Item();
                        tracker.addItem(input.addItem(item));
                        System.out.println("Заявка id - " + item.getID() + " создана");
                        acton(tracker, input, menu);
                        break;
                    case EDITITEM:
                        //todo сделать редактирование - должен быть выбор списка.
                        menu.showItems(tracker.getItems());
                        menu.showEdit();
                        if (tracker.getItems()[0] == null)
                        {
                            System.out.println("Заявок не существует  ");
                        } else
                        {
                            System.out.print("ID заявки: ");

                            String idEdit = menu.getScanner();
                            Item item1 = tracker.findByID(idEdit);
                            if (item1.getID() != null)
                            {
                                tracker.updateItem(idEdit);
                                input.addItem(item1);
                            }
                            System.out.println("Заявка id - " + item1.getID() + " изменена");
                        }
                        menu.showItems(tracker.getItems());
                        acton(tracker, input, menu);
                        break;
                    case SHOWITEMS:
                        menu.showItems(tracker.getItems());
                        acton(tracker, input, menu);
                        break;
                    case REMOVEITEM:
                        //todo сделать удаление - должен быть выбор списка
                        menu.showItems(tracker.getItems());
                        menu.showRemove();
                        if (tracker.getItems()[0] == null)
                        {
                            System.out.println("Заявок не существует  ");
                        } else
                        {
                            System.out.print("ID заявки: ");
                            String id = menu.getScanner();
                            tracker.deleteItem(id);
                        }
                        menu.showItems(tracker.getItems());
                        acton(tracker, input, menu);
                        break;
                    case EXIT:
                        return;
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("Некорректный ввод :");
                flag = true;
            }
        }while(flag);
    }
}