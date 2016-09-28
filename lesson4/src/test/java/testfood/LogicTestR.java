package testfood;

import food.extend.RFood;
import java.util.ArrayList;
import java.util.Date;
/**
 * Class for prelimery tests of application in work.
 */
public class LogicTestR {
    private ArrayList<RFood> list;

    public void   initList(){
        list = new ArrayList<RFood>();
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,5),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,5),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,23),new Date(1984,11,5),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,16),35,12,true));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,27),35,12,false));
        list.add(new RFood("apple",new Date(1984,11,27),new Date(1984,11,26),35,12,true));
    }

    public ArrayList<RFood> getList() {
        return list;
    }
}