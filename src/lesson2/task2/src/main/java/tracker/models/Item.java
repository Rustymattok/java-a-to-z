package ru.makarov.model;


import java.util.Date;

public class Item{
    private String id;
    private String name;
    private String description;
    private Date date;

    public Item(){
    }

    public Item(String name,String description,Date date){
        this.name = name;
        this.description  = description;
        this.date =  date;
    }

    public void setID(String id){
        this.id = id;
    }

    public void setName(String name){
        if(this.name != null)
        {
            this.name = null;
        }
            this.name = name;
    }

    public void setDescription(String description){
        if(this.description != null)
        {
            this.description = null;
        }
        this.description = description;
    }

    public void setDate(){
        if(this.date != null)
        {
            this.date = null;
        }
        this.date = new Date();
    }

    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Date getDate(){
        return date;
    }
}