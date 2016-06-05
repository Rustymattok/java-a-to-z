package ru.makarov.tracker;


import ru.makarov.interfaces.Input;
import ru.makarov.model.Choose;
import ru.makarov.model.Item;
import ru.makarov.start.ShowMenu;
import ru.makarov.start.StubInput;
import ru.makarov.start.Tracker;

public class StartUI
{
    public static void main(String[] args)
    {
        ShowMenu menu = new ShowMenu();
        Tracker tracker = new Tracker();
        //ConsoleInput input = new ConsoleInput();
        StubInput input = new StubInput();
        menu.showInfo();
        StartUI startUI = new StartUI();
        startUI.acton(tracker,input,menu);
    }

    public void acton(Tracker tracker, Input input,ShowMenu menu){
        Choose choose = menu.getChoose();
        switch (choose)
        {
            case ADDItem:
                Item item = new Item();
                tracker.addItem(input.addItem(item));
                System.out.println("Заявка id - " + item.getID() + " создана");
                acton(tracker,input,menu);
                break;
            case EDITItem:
                //todo сделать редактирование - должен быть выбор списка.
                tracker.showItems();
                menu.showEdit();
                if (tracker.getItems()[0] == null){
                    System.out.println("Заявок не существует  ");
                }else
                {
                    System.out.print("ID заявки: ");

                    String idEdit = menu.getScanner();
                    Item item1 = tracker.findByID(idEdit);
                    if (item1.getID() != null)
                    {
                        item1.setName("");
                        item1.setDescription("");
                        input.addItem(item1);
                    }
                    System.out.println("Заявка id - " + item1.getID() + " изменена");
                }
                    tracker.showItems();
                acton(tracker, input, menu);
                break;
            case SHOWItems:
                tracker.showItems();
                acton(tracker,input,menu);
                break;
            case REMOVEItem:
                //todo сделать удаление - должен быть выбор списка
                tracker.showItems();
                menu.showRemove();
                if (tracker.getItems()[0] == null){
                    System.out.println("Заявок не существует  ");
                }else
                {
                    System.out.print("ID заявки: ");
                    String id = menu.getScanner();
                    tracker.removeItem(id);
                }
                tracker.showItems();
                acton(tracker,input,menu);
                break;
            case EXIT:
                return;
            default:
                acton(tracker, input, menu);
        }
    }
}
