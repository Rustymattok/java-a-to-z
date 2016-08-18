package food.logic;

import food.model.Food;
import food.model.FoodNew;

import java.util.ArrayList;
import java.util.Date;
/**
 * Class for prelimery tests of application in work.
 */
public class LogicTest  {

    public ArrayList<Food> initList(){
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,23),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,5),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,27),35,12));
        list.add(new Food("apple",new Date(1984,11,27),new Date(1984,11,26),35,12));
        return list;
    }

}
