package ru.makarov.start;

import ru.makarov.model.Item;

import java.util.Random;


public class Tracker
{
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random random = new Random();

    public Item addItem(Item item)
    {
        item.setID(generateID());
        this.items[position++] = item;
        return item;
    }

    public Item findByID(String id){
        Item result = null;
        for(Item item : items){
            if(item != null && item.getID().equals(id)){
                result = item;
            }
        }
        return result;
    }

    public Item[] deleteItem(String id){
        Item item = findByID(id);
        for (int i = 0; i < items.length ; i++)
        {
            if(items[i] == item){
                items[i] = null;
                sortItems(items);
                break;
            }
        }
        return items;
    }

    private String generateID(){
        return (System.currentTimeMillis()/1000000000)/100 + String.valueOf(random.nextInt(100));
    }

    public void sortItems(Item[] items){
        Item b;
        for (int i = 0; i < items.length-1; i++)
        {
            if(items[i]==null && items[i+1]!=null){
                b = items[i+1];
                items[i+1] = items[i];
                items[i] = b;
            }
        }
    }

    public Item[] getItems()
    {
        return items;
    }

}


