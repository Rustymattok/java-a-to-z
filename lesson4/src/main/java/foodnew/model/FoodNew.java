package foodnew.model;

import java.util.Date;

public class FoodNew extends Food {
    private boolean flag;

    public FoodNew(String name, Date expaireDate, Date creatDate, double price, double discount, boolean flag) {
        super(name, expaireDate, creatDate, price, discount);
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
