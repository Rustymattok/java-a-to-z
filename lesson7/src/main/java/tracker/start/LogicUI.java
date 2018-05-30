package tracker.start;

import tracker.interfaces.Input;
import tracker.models.Choose;
import tracker.models.Item;

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
     * Choose type of active in menu.
     *
     * @return type of active.
     */
    public Choose getChoose() {
        boolean flag;
        Choose choose = null;
        do {
            menu.showChoose();
            String result = menu.getScanner();
            if (result != null && !result.isEmpty()) {
                switch (result.charAt(0)) {
                    case 'a':
                        choose = Choose.ADDITEM;
                        flag = false;
                        break;
                    case 'b':
                        choose = Choose.SHOWITEMS;
                        flag = false;
                        break;
                    case 'c':
                        choose = Choose.EDITITEM;
                        flag = false;
                        break;
                    case 'd':
                        choose = Choose.REMOVEITEM;
                        flag = false;
                        break;
                    case 'e':
                        choose = Choose.EXIT;
                        flag = false;
                        break;
                    default:
                        menu.showErrorOfEnter();
                        flag = true;
                }
            } else {
                menu.showErrorOfEnter();
                flag = true;
            }
        } while (flag);
        return choose;
    }

    /**
     * Method for choose action.
     */
    public void acton() {
        Choose choose = getChoose();
        switch (choose) {
            case ADDITEM:
                Item item = new Item();
                tracker.addItem(input.addItem(item));
                menu.createdItem(item.getID());
                acton();
                break;
            case EDITITEM:
                menu.showEdit();
                String idEdit = menu.getScanner();
                Item item1 = tracker.findByID(idEdit);
                if(item1.getName() == null){
                    menu.showNoItems();
                }else {
                    menu.showCommandForName();
                    String name = menu.getScanner();
                    item1.setName(name);
                    menu.showCommandForDescribe();
                    String description = menu.getScanner();
                    item1.setDescription(description);
                    tracker.updateItem(item1);
                }
                acton();
                break;
            case SHOWITEMS:
                menu.chooseToShowItem();
                String idShow = menu.getScanner();
                Item itemShow = tracker.findByID(idShow);
                if(itemShow.getName() == null){
                    menu.showNoItems();
                }else {
                    menu.showItem(itemShow);
                }
                acton();
                break;
            case REMOVEITEM:
                menu.showRemoveID();
                String idRemove = menu.getScanner();
                Item itemRemove = tracker.findByID(idRemove);
                if(itemRemove.getName() == null){
                    menu.showNoItems();
                }else {
                    tracker.deleteItem(idRemove);
                    menu.showRemovedItem();
                }
                acton();
                break;
            case EXIT:
                return;
        }
    }
}
