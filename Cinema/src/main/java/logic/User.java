package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describe parameter of users
 */
public class User {
    private String name;
    private String phone;
    private Double balance;
    private Integer id;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public User() {
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User(String name, String phone, Double balance) {
        this.name = name;
        this.phone = phone;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
