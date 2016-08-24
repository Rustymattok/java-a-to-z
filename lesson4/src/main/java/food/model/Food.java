package food.model;

import java.util.Date;
/**
 * Class with common parameters of food.
 */
public class Food {
    private String name;
    private Date expaireDate;
    private Date creatDate;
    private double price;
    private double discount;

    public Food() {
    }

    public Food(String name, Date expaireDate, Date creatDate, double price, double discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.creatDate = creatDate;
        this.price = price;
        this.discount = discount;
    }
    /**
     * Method for calculation shelf life.
     * @return - % of shelf life.
     */
    public double calculateDay(){
        double result;
        result = 100 - (expaireDate.getDate() - creatDate.getDate())*100/expaireDate.getDate();
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expaireDate=" + expaireDate +
                ", creatDate=" + creatDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }

    public void test(){
        System.out.println(calculateDay());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
