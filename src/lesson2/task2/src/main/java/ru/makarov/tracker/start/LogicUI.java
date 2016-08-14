package ru.makarov.tracker.start;

import ru.makarov.tracker.interfaces.Input;
import ru.makarov.tracker.models.Choose;
import ru.makarov.tracker.models.Item;
/**
 * Class for logic methods.
 */
public class LogicUI {
    private Tracker tracker;
    private Input input;
    private ShowMenu menu;

    public LogicUI(Tracker tracker, Input input, ShowMenu menu) {
        this.tracker = tracker;
        this.input = input;
        this.menu = menu;
    }
    /**
     * Method for choose action.
     */
    public void acton() {
        Choose choose = tracker.getChoose();
        switch (choose) {
            case ADDITEM:
                Item item = new Item();
                tracker.addItem(input.addItem(item));
                menu.createdItem(item.getID());
//                System.out.println("Заявка id - " + item.getID() + " создана");
                acton();
                break;
            case EDITITEM:
                //todo сделать редактирование - должен быть выбор списка.
                menu.showItems(tracker.getItems());
                menu.showEdit();
                if (tracker.getItems()[0] == null) {
                    menu.showNoItems();
                } else {
                    menu.showTextIdNumber();
                    String idEdit = menu.getScanner();
                    Item item1 = tracker.findByID(idEdit);
                    if (item1.getID() != null) {
                        tracker.updateItem(idEdit);
                        input.addItem(item1);
                    }
                    menu.showModifyItems(item1.getID());
                }
                menu.showItems(tracker.getItems());
                acton();
                break;
            case SHOWITEMS:
                menu.showItems(tracker.getItems());
                acton();
                break;
            case REMOVEITEM:
                //todo сделать удаление - должен быть выбор списка
                menu.showItems(tracker.getItems());
                menu.showRemove();
                if (tracker.getItems()[0] == null) {
                    menu.showNoItems();
                } else {
                    menu.showTextIdNumber();
                    String id = menu.getScanner();
                    tracker.deleteItem(id);
                }
                menu.showItems(tracker.getItems());
                acton();
                break;
            case EXIT:
                return;
        }
    }
}
