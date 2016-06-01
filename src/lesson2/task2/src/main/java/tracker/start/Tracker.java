package ru.makarov.tracker.start;

import ru.makarov.tracker.model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public Item editItem(String id){
        Item item = new Item();//todo не нравится что то

        if (id != null){
            item = findByID(id);
            String name ="";
            String description ="";
            BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readerDescription = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                System.out.print("Введите имя заявки: ");
                name = readerName.readLine();
                System.out.print("ВВедите описание: ");
                description = readerDescription.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            item.setName(name);
            item.setDescription(description);
            item.setDate();
        }
        return item;
    }

    public Item[] removeItem(String id){
        for (int i = 0; i < items.length ; i++)
        {
            if(items[i] == findByID(id)){
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

    public void showItems(){
        int position = 0 ;
        for(Item item : items ){
            if (items[position] == null){
                break;
            }
            position++;
            System.out.println("имя заявки: " + item.getName() + "." + " описание: " + item.getDescription() + "."
                    + " id-заявки ноиер  " + position + ": = " + item.getID() + "." +
            " дата создания заявки: " + item.getDate());
        }
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