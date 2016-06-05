package ru.makarov.start;

import ru.makarov.interfaces.Input;
import ru.makarov.model.Item;

public class StubInput implements Input
{

    @Override
    public Item addItem(Item item)
    {
       // item =  new Item("test","test describe",new Date());
        item.setName("test");
        item.setDescription("test");
        item.setDate();
        return item;
    }

}
