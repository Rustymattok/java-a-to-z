package servlets;

import org.junit.Test;
import persistent.DbStorePostgres;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JSONhallsTest {
    JSONhalls jsoNhalls =new JSONhalls();


    @Test
    public void parsText() {
        String text ="list%5B%5D=120&list%5B%5D=121&list%5B%5D=122&list%5B%5D=123&list%5B%5D=124";
       // System.out.println(jsoNhalls.parsText(text));
        jsoNhalls.parsText(text);
    }
}