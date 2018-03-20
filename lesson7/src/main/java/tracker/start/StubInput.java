package ru.makarov.tracker.start;

import ru.makarov.tracker.interfaces.Input;
import ru.makarov.tracker.models.Item;
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
