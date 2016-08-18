package foodpart1.model;

import java.util.Date;

/**
 * Class describe foo for Warehouse.
 */
public class Warehouse extends Food {

    public Warehouse(String name, Date expaireDate, Date creatDate, double price, double discount) {
        super(name, expaireDate, creatDate, price, discount);
    }
}
