package testfood;

import food.extend.FoodTempr;

import java.util.ArrayList;
import java.util.Date;

public class LogicTestTempr  {
    private ArrayList<FoodTempr> list;

    public void   initList(){
        list = new ArrayList<FoodTempr>();
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,5),35,12,true,12));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,5),35,12,true,0));
        list.add(new FoodTempr("apple",new Date(1984,11,23),new Date(1984,11,5),35,12,true,0));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,true,12));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,true,9));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,true,7));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,16),35,12,true,3));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,false,8));
        list.add(new FoodTempr("apple",new Date(1984,11,27),new Date(1984,11,26),35,12,true,5));
    }

    public ArrayList<FoodTempr> getList() {
        return list;
    }
}

