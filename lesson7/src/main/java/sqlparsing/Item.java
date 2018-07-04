package tracker.models;

import java.util.Date;

/**
 * Class describe Item  - parameteres and its methods.
 */
public class Item{
    /**
     * @param id - id for item.
     * @param name - name for item.
     * @param description - description of item.
     * @param date - date of ctreated item.
     */
    private Integer id;
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

    public void setID(Integer id){
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

    public Integer getID(){
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