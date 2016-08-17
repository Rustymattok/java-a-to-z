package ru.makarov.tracker.interfaces;

import ru.makarov.tracker.models.Item;
/**
 * Common interface for add Item.
 */
public interface Input {
    Item addItem(Item item);
}
