package logic;

import java.util.ArrayList;
import java.util.List;
/**
 * Class describe Item.
 */
public class User {
    private String id;
    private String name;
    private String login;
    private String role;
    private String email;
    private String country;
    private String city;
  //  private   ArrayList<String> roles = new ArrayList<String>();

    public User() {
    }

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public User(String id, String name, String login, String email, String role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = role;
    }
    public User(String id,String name, String login,String email,String role,String country, String city) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.country = country;
        this.city = city;
        this.role = role;
    }

//    public User(String name, String login, String email,String role) {
//        this.name = name;
//        this.login = login;
//        this.email = email;
//        this.role = role;
//    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public ArrayList<String> getRoles() {
//        roles.add(String.valueOf(ClientType.ADMINISTRATOR));
//        roles.add(String.valueOf(ClientType.USER));
//        roles.add(String.valueOf(ClientType.GUEST));
//        return roles;
//    }
}
