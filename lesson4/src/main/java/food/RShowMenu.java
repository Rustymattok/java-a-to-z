package food;

import food.logic.ControllQuality;
import food.logic.RControllQuality;

public class RShowMenu  {
    protected RControllQuality controllQuality;

    public RShowMenu(RControllQuality controllQuality) {
        this.controllQuality = controllQuality;
    }

    public void show(){
        for (int i = 0; i < controllQuality.getStoreges().size(); i++) {
            System.out.println();
            System.out.println(controllQuality.getStoreges().get(i).getFoodList().size());
            for (int j = 0; j < controllQuality.getStoreges().get(i).getFoodList().size(); j++) {
                System.out.println(controllQuality.getStoreges().get(i).getFoodList().get(j));
            }
        }
    }
}
