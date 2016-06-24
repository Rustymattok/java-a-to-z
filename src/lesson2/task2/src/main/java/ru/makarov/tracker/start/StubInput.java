package ru.makarov.tracker.start;

import ru.makarov.tracker.interfaces.Input;
import ru.makarov.tracker.models.Item;

public class StubInput implements Input {
    @Override
    public Item addItem(Item item) {
       // item =  new Item("test","test describe",new Date());
        item.setName("test");
        item.setDescription("test");
        item.setDate();
        return item;
    }
}
