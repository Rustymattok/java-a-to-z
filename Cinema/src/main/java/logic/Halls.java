package logic;
/**
 * Class descripe parameters of halls.
 */
public class Halls {
    private Integer id;
    private String row;
    private String place;
    private String status;
    private double price;

    public Halls(Integer id,String row, String place, String status) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.status = status;
    }

    public Halls(Integer id, String row, String place, String status, double price) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.status = status;
        this.price = price;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
