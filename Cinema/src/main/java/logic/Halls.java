package logic;

public class Halls {
    private String row;
    private String place;
    private String status;

    public Halls(String row, String place, String status) {
        this.row = row;
        this.place = place;
        this.status = status;
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
}
