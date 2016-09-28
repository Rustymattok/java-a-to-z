package food.extend;

import food.model.Food;
import java.util.Date;
/**
 * Class with common parameters of Rfood.
 */
public class RFood extends Food {
    /**
     * @param canReproduct - false or true.
     */
    private boolean canReproduct;

    public RFood(String name, Date expaireDate, Date creatDate, double price, double discount, boolean canReproduct) {
        super(name, expaireDate, creatDate, price, discount);
        this.canReproduct = canReproduct;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }
}
