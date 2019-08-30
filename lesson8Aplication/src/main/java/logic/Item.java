package logic;
/*
'[{"firstname": "text1","lastname": "text2","infoU": "text3"},{"firstname": "text4","lastname": "text5","infoU": "text6"},{"firstname": "vova","lastname": "makarov","infoU": "111"}]'
 */
public class Item {

    private String firstname;
    private String lastname;
    private String infoU;

    public Item() {
    }

    public Item(String firstname, String lastname, String infoU) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.infoU = infoU;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInfoU() {
        return infoU;
    }

    public void setInfoU(String infoU) {
        this.infoU = infoU;
    }
}
