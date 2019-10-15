package servlets;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONaccountTest {

    @Test
    public void parsText() {
        JSONaccount jsoNaccount = new JSONaccount();
        jsoNaccount.parsText("list%5B%5D=161&list%5B%5D=143");
    }
}