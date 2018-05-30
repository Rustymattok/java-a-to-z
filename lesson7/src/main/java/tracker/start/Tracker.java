package tracker.start;

import tracker.models.Choose;
import tracker.models.Item;

import java.util.Random;
/**
 * Logic of tracker.
 */
public class Tracker implements AutoCloseable{
    /**
     * @param items - list of items.
     * @param position - index of items.
     * @param random - activate random methods.
     * @param menu - activate for show methods.
     */
    private DataBase dataBase;
    private static final Random random = new Random();
    private ShowMenu menu = new ShowMenu();
    private Item[] items;

    public Tracker(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    /**
     * Add items
     *
     * @param item - item wich you need to add to list.
     * @return list of items.
     */
    public Item addItem(Item item) {
        item.setID(generateID());
        dataBase.addItem(item);
        return item;
    }
    /**
     * Find item using ID.
     *
     * @param id - index for searching.
     * @return item by index.
     */
    public Item findByID(String id) {
        Item result = null;
        result = dataBase.searchById(id);
        return result;
    }
    /**
     * Delete item by index.
     * @param id - parameter for index.
     * @return list of items after deleting.
     */
    public void deleteItem(String id) {
        dataBase.deleteItem(id);    }
    /**
     * Update item.
     * @return updated item.
     */
    public void updateItem(Item item) {
        dataBase.editItem(item);
    }
    /**
     *
     * @return id - generated data.
     */
    private String generateID() {
        boolean flag  = false;
        String generatedId="";
        while (flag == false) {
            generatedId = (System.currentTimeMillis() / 1000000000) / 100 + String.valueOf(random.nextInt(100));
            if (findByID(generatedId).getName() == null) {
                flag = true;
            }
        }
        return generatedId;
    }

    public void close() throws Exception {
        dataBase.closeData();
    }
}
