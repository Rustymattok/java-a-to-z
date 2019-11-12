package logic;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Halls)) return false;
        Halls halls = (Halls) o;
        return Double.compare(halls.price, price) == 0 &&
                id.equals(halls.id) &&
                row.equals(halls.row) &&
                place.equals(halls.place) &&
                status.equals(halls.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, place, status, price);
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
