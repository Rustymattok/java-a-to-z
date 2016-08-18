package food.model;

import java.util.Date;
/**
 * Class describe foo for shop.
 */
public class Shop extends Food {

    public Shop(String name, Date expaireDate, Date creatDate, double price, double discount) {
        super(name, expaireDate, creatDate, price, discount);
    }
}
