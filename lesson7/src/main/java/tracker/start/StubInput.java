package tracker.start;


import tracker.interfaces.Input;
import tracker.models.Item;

/**
 * Class for init text without console. It can be use for tests.
 */
public class StubInput implements Input {
    public Item addItem(Item item) {
        item.setName("test");
        item.setDescription("test");
        item.setDate();
        return item;
    }
}
