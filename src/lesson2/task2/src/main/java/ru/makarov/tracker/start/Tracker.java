package ru.makarov.tracker.start;

import ru.makarov.tracker.models.Choose;
import ru.makarov.tracker.models.Item;
import java.util.Date;
import java.util.Random;
/**
 * Logic of tracker.
 */
public class Tracker {
    /**
     * @param items - list of items.
     * @param position - index of items.
     * @param random - activate random methods.
     * @param menu - activate for show methods.
     */
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random random = new Random();
    private ShowMenu menu = new ShowMenu();
    /**
     * Add items
     * @param item - item wich you need to add to list.
     * @return list of items.
     */
    public Item addItem(Item item) {
        item.setID(generateID());
        this.items[position++] = item;
        return item;
    }
    /**
     * Find item using ID.
     * @param id - index for searching.
     * @return item by index.
     */
    public Item findByID(String id) {
        Item result = null;
        for (Item item : items)
        {
            if (item != null && item.getID().equals(id))
            {
                result = item;
            }
        }
        return result;
    }
    /**
     * Find item by description.
     * @param description - parameter for searchind.
     * @return item by description.
     */
    public Item findByDec(String description){
        Item result = null;
        for(Item item : items ){
            if(item != null && item.getDescription().equals(description)){
                result = item;
            }
        }
        return  result;
    }
    /**
     * Find item by Name.
     * @param name - parameter for searching.
     * @return item by name.
     */
    public Item findByName (String name){
        Item result = null;
        for(Item item : items ){
            if(item != null && item.getName().equals(name)){
                result = item;
            }
        }
        return  result;
    }
    /**
     * Find item by Date.
     * @param date - parameter for searching.
     * @return item by Date.
     */
    public Item findByDate( Date date){
        Item result = null;
        for(Item item : items ){
            if(item != null && item.getDate().equals(date)){
                result = item;
            }
        }
        return  result;
    }
    /**
     * Delete item by index.
     * @param id - parameter for index.
     * @return list of items after deleting.
     */
    public Item[] deleteItem(String id) {
        Item item = findByID(id);
        for (int i = 0; i < items.length; i++)
        {
            if (items[i].equals(item))
            {
                items[i] = null;
                sortItems(items);
                break;
            }
        }
        return items;
    }
    /**
     * Update item by index.
     * @param id - index for update.
     * @return updated item.
     */
    public Item[] updateItem(String id) {
        Item item = findByID(id);
        for (int i = 0; i < items.length; i++)
        {
            if (items[i].equals(item))
            {
                items[i].setName("");
                items[i].setDescription("");
                break;
            }
        }
        return items;
    }

    private String generateID() {
        return (System.currentTimeMillis() / 1000000000) / 100 + String.valueOf(random.nextInt(100));
    }

    /**
     * Sort list of items.
     * @param items - list for sorting.
     */
    public void sortItems(Item[] items) {
        Item b;
        for (int i = 0; i < items.length - 1; i++)
        {
            if (items[i] == null && items[i + 1] != null)
            {
                b = items[i + 1];
                items[i + 1] = items[i];
                items[i] = b;
            }
        }
    }
    /**
     * Choose type of active in menu.
     * @return type of active.
     */
    public Choose getChoose() {
        boolean flag ;
        Choose choose = null;
        do
        {
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
            }
            else {
                menu.showErrorOfEnter();
                flag = true;
            }
        }while (flag);
        return choose;
    }

    public Item[] getItems () {
            return items;
        }
}
