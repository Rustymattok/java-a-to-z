package food.extend;

import java.util.Date;
/**
 * Class with common parameters of food with temperature..
 */
public class FoodTempr extends RFood {
    private  double tempr;

    public FoodTempr(String name, Date expaireDate, Date creatDate, double price, double discount, boolean canReproduct,double tempr) {
        super(name, expaireDate, creatDate, price, discount, canReproduct);
        this.tempr = tempr;
    }

    public double getTempr() {
        return tempr;
    }
}

