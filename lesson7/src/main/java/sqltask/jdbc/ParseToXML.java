package sqltask.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Class for parsing to XML.
 */
public class ParseToXML {

    private FullList fullList;
    private String filWay;
    private List<Entry> list = new ArrayList<Entry>();
    private DataBase dataBase;


    public ParseToXML(DataBase dataBase, String filWay) {
        this.dataBase = dataBase;
        this.filWay = filWay;
    }

    public void takeList(){
        dataBase.connectToDataBase();
        dataBase.initTable();
        readData();
        fullList = new FullList(list);
        Jaxb jaxb = new Jaxb(fullList,filWay);
        jaxb.startConvert();
    }
    public void readData(){
        dataBase.importToXML(list);
    }

    public void show(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getField());
        }
    }

}
